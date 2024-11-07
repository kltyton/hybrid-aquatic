package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class SeaBassEntity(entityType: EntityType<out SeaBassEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world, variants = hashMapOf(
        "black" to FishVariant.biomeVariant("black", HybridAquaticBiomeTags.OCEAN,
            ignore = listOf(FishVariant.Ignore.ANIMATION, FishVariant.Ignore.MODEL)),
        ),
        listOf(
            HybridAquaticEntityTags.NONE),
        listOf(
            HybridAquaticEntityTags.LARGE_PREY,
            HybridAquaticEntityTags.SHARK)) {

    override fun getLimitPerChunk(): Int {
        return 2
    }

        companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}