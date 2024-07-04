package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class BettaEntity(entityType: EntityType<out BettaEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world, variants = hashMapOf(
        "black" to FishVariant.biomeVariant("black", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "blue" to FishVariant.biomeVariant("blue", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "blue_yellow" to FishVariant.biomeVariant("blue_yellow", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "green" to FishVariant.biomeVariant("green", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "pink" to FishVariant.biomeVariant("pink", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "red" to FishVariant.biomeVariant("red", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),
        "white" to FishVariant.biomeVariant("white", HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES),),
        HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.NONE) {
    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}