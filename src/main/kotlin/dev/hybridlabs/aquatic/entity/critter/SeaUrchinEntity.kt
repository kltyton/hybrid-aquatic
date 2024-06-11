package dev.hybridlabs.aquatic.entity.critter

import dev.hybridlabs.aquatic.entity.HybridAquaticEntityTypes
import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.entity.mob.PathAwareEntity
import net.minecraft.registry.tag.DamageTypeTags
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.`object`.PlayState

class SeaUrchinEntity(entityType: EntityType<out SeaUrchinEntity>, world: World) :
    HybridAquaticCritterEntity(entityType, world, variants = hashMapOf(
        "long_black" to CritterVariant.biomeVariant("long_black", HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES),
        "long_blue" to CritterVariant.biomeVariant("long_blue", HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES),
        "long_purple" to CritterVariant.biomeVariant("long_purple", HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES),
        "long_red" to CritterVariant.biomeVariant("long_red", HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES))) {

    private var timeUntilNextBreak = 0
    private var spawnUrchinOnNextBreak = false

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100.0)
        }
    }

    override fun <E : GeoAnimatable> predicate(event: AnimationState<E>): PlayState {
        if (isSubmergedInWater) {
            event.controller.setAnimation(WALK_ANIMATION)
        }
        return PlayState.CONTINUE
    }

    override fun damage(source: DamageSource, amount: Float): Boolean {
        return if (world.isClient) {
            false
        } else {
            if (!source.isIn(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !source.isOf(DamageTypes.THORNS)) {
                val attacker = source.source
                if (attacker is LivingEntity) {
                    attacker.damage(this.damageSources.thorns(this), 2.0f)
                }
            }
            super.damage(source, amount)
        }
    }

    override fun tick() {
        super.tick()

        if (world.isClient) {
            return
        }

        if (timeUntilNextBreak > 0) {
            timeUntilNextBreak--
            return
        }

        if (world.random.nextInt(6000) < 300) {
            breakKelpUnderneath()
            timeUntilNextBreak = 2400 + world.random.nextInt(1200)
        }
    }

    private fun breakKelpUnderneath() {
        val posUnderneath = BlockPos(this.x.toInt(), (this.y+1).toInt(), this.z.toInt())
        if (world.getBlockState(posUnderneath).isOf(Blocks.KELP_PLANT)) {
            world.setBlockState(posUnderneath, Blocks.AIR.defaultState)
            if (spawnUrchinOnNextBreak) {
                val newUrchin = HybridAquaticEntityTypes.SEA_URCHIN.create(world)
                newUrchin?.refreshPositionAndAngles(this.x, this.y, this.z, this.yaw, 0.0f)
                world.spawnEntity(newUrchin)
                spawnUrchinOnNextBreak = false
            } else {
                spawnUrchinOnNextBreak = true
            }
        }
    }

    override fun getMaxSize(): Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}
