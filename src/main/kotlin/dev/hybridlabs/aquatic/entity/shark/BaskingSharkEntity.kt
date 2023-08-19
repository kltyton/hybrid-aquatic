package dev.hybridlabs.aquatic.entity.shark

import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class BaskingSharkEntity(entityType: EntityType<out BaskingSharkEntity>, world: World) :
    HybridAquaticSharkEntity(entityType, world, HybridAquaticEntityTags.BASKING_SHARK_PREY, true,false, false, false, false) {
        companion object {
            fun createMobAttributes(): DefaultAttributeContainer.Builder {
                return WaterCreatureEntity.createMobAttributes()
                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.4)
                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                    .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0)

            }
        }
    }
