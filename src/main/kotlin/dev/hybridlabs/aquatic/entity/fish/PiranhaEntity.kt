package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.Difficulty
import net.minecraft.world.World

class PiranhaEntity(entityType: EntityType<out PiranhaEntity>, world: World) :
    HybridAquaticSchoolingFishEntity(entityType, world, HybridAquaticEntityTags.PIRANHA_PREY, HybridAquaticEntityTags.PIRANHA_PREDATOR) {

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(1, AttackGoal(this))
    }


    override fun tryAttack(target: Entity?): Boolean {
        if (super.tryAttack(target)) {
            if (target is LivingEntity) {
                var i = 0
                if (world.difficulty == Difficulty.NORMAL) {
                    i = 7
                } else if (world.difficulty == Difficulty.HARD) {
                    i = 15
                }

                if (i > 0) {
                    target.addStatusEffect(StatusEffectInstance(HybridAquaticStatusEffects.BLEEDING, i * 20, 0), this)
                }
            }

            return true
        } else {
            return false
        }
    }

    override fun getMaxSize(): Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}