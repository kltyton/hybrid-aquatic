package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.goals.BoidGoal
import dev.hybridlabs.aquatic.goals.LimitSpeedAndLookInVelocityDirectionGoal
import dev.hybridlabs.aquatic.goals.StayInWaterGoal
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World

class FlashlightFishEntity(entityType: EntityType<out FlashlightFishEntity>, world: World) :
    HybridAquaticSchoolingFishEntity(entityType, world, HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.NONE) {

    override fun initGoals() {
        super.initGoals()
            goalSelector.add(5, BoidGoal(this, 0.4f, 0.5f, 4 / 20f, 4 / 20f))
            goalSelector.add(2, LimitSpeedAndLookInVelocityDirectionGoal(this, 0.2f, 0.4f))
            goalSelector.add(3, StayInWaterGoal(this))
    }

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }
    }
}