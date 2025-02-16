package dev.hybridlabs.aquatic.entity.shark

import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class WhaleSharkEntity(entityType: EntityType<out WhaleSharkEntity>, world: World) :
    HybridAquaticSharkEntity(entityType, world, listOf(HybridAquaticEntityTags.NONE), true, false) {

    override fun getLimitPerChunk(): Int {
        return 1
    }

    companion object {
            fun createMobAttributes(): DefaultAttributeContainer.Builder {
                return WaterCreatureEntity.createMobAttributes()
                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                    .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 26.0)
            }
        }

    override fun getMaxSize(): Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}
