package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class SeahorseEntity(entityType: EntityType<out SeahorseEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world, variants = hashMapOf(
        "common" to FishVariant.biomeVariant("common", HybridAquaticBiomeTags.SEAHORSE_SPAWN_BIOMES),
        "big_belly" to FishVariant.biomeVariant("big_belly", HybridAquaticBiomeTags.SEAHORSE_SPAWN_BIOMES),
        "pygmy" to FishVariant.biomeVariant("pygmy", HybridAquaticBiomeTags.SEAHORSE_SPAWN_BIOMES)),
        HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.NONE) {

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}