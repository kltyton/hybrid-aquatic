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

class StarfishEntity(entityType: EntityType<out StarfishEntity>, world: World) :
    HybridAquaticCritterEntity(entityType, world, variants = hashMapOf(
        "blue" to CritterVariant.biomeVariant("blue", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "green" to CritterVariant.biomeVariant("green", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "purple" to CritterVariant.biomeVariant("purple", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "red" to CritterVariant.biomeVariant("red", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "yellow" to CritterVariant.biomeVariant("yellow", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_blue" to CritterVariant.biomeVariant("medium_blue", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_green" to CritterVariant.biomeVariant("medium_green", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_orange" to CritterVariant.biomeVariant("medium_orange", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_purple" to CritterVariant.biomeVariant("medium_purple", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_red" to CritterVariant.biomeVariant("medium_red", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_yellow" to CritterVariant.biomeVariant("medium_yellow", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_blue" to CritterVariant.biomeVariant("medium_knobbed_red", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_green" to CritterVariant.biomeVariant("medium_knobbed_green", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_orange" to CritterVariant.biomeVariant("medium_knobbed_orange", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_purple" to CritterVariant.biomeVariant("medium_knobbed_purple", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_red" to CritterVariant.biomeVariant("medium_knobbed_red", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "medium_knobbed_yellow" to CritterVariant.biomeVariant("medium_knobbed_yellow", HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES),
        "crown_of_thorns" to CritterVariant.biomeVariant("crown_of_thorns", HybridAquaticBiomeTags.COT_SPAWN_BIOMES),
        "brittlestar_black" to CritterVariant.biomeVariant("brittlestar_black", HybridAquaticBiomeTags.BRITTLESTAR_SPAWN_BIOMES),
        "brittlestar_yellow" to CritterVariant.biomeVariant("brittlestar_yellow", HybridAquaticBiomeTags.BRITTLESTAR_SPAWN_BIOMES),
        "brittlestar_white" to CritterVariant.biomeVariant("brittlestar_white", HybridAquaticBiomeTags.BRITTLESTAR_SPAWN_BIOMES),)) {

        companion object {
            fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 100.0)
            }
        }

    override fun <E : GeoAnimatable> predicate(event: AnimationState<E>): PlayState {
        if (isSubmergedInWater) {
            event.controller.setAnimation(WALK_ANIMATION)
        }
        return PlayState.CONTINUE
    }

    override fun tick() {
        super.tick()
        if (!isWet) {
            this.speed = 0.01F
        }
    }
    override fun getMaxSize() : Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}