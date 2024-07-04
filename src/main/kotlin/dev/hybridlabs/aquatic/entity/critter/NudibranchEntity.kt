package dev.hybridlabs.aquatic.entity.critter

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.`object`.PlayState

class NudibranchEntity(entityType: EntityType<out NudibranchEntity>, world: World) :
    HybridAquaticCritterEntity(entityType, world, variants = hashMapOf(
        "pyjama" to CritterVariant.biomeVariant("pyjama", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "bullock" to CritterVariant.biomeVariant("bullock", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "sagami" to CritterVariant.biomeVariant("sagami", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "festiva" to CritterVariant.biomeVariant("festiva", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "magnificent" to CritterVariant.biomeVariant("magnificent", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "kubaryana" to CritterVariant.biomeVariant("kubaryana", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "yonowae" to CritterVariant.biomeVariant("yonowae", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "kuniei" to CritterVariant.biomeVariant("kuniei", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES),
        "baba" to CritterVariant.biomeVariant("baba", HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES))) {

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
        }
    }

    override fun <E : GeoAnimatable> predicate(event: AnimationState<E>): PlayState {
        if (isSubmergedInWater) {
            event.controller.setAnimation(WALK_ANIMATION)
        } else {
            event.controller.setAnimation(FLOP_ANIMATION)
        }
        return PlayState.CONTINUE
    }
    override fun getMaxSize() : Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}