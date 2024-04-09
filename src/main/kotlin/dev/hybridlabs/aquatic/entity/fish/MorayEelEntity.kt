package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.entity.crustacean.HybridAquaticCrabEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.goal.ActiveTargetGoal
import net.minecraft.entity.ai.goal.MeleeAttackGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.passive.FishEntity
import net.minecraft.world.World

class MorayEelEntity(entityType: EntityType<out MorayEelEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world) {
    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0)
        }

        val ATTEMPT_ATTACK: TrackedData<Boolean> =
            DataTracker.registerData(LionfishEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
    }

    private var attemptAttack: Boolean
        get() = dataTracker.get(ATTEMPT_ATTACK)
        set(attemptAttack) {
            dataTracker.set(ATTEMPT_ATTACK, attemptAttack)
        }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(1, AttackGoal(this))
        targetSelector.add(7, ActiveTargetGoal(this, FishEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, HybridAquaticCrabEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, LionfishEntity::class.java, true, true))
    }
    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(ATTEMPT_ATTACK, false)
    }

    internal class AttackGoal(private val morayEel: MorayEelEntity) : MeleeAttackGoal(morayEel,1.2, true) {
        override fun attack(target: LivingEntity, squaredDistance: Double) {
            val d = getSquaredMaxAttackDistance(target)
            if (squaredDistance <= d && this.isCooledDown) {
                resetCooldown()
                mob.tryAttack(target)
                morayEel.attemptAttack = true
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