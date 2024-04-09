package dev.hybridlabs.aquatic.entity.fish

import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects
import dev.hybridlabs.aquatic.entity.shark.HybridAquaticSharkEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.goal.ActiveTargetGoal
import net.minecraft.entity.ai.goal.MeleeAttackGoal
import net.minecraft.entity.ai.goal.RevengeGoal
import net.minecraft.entity.ai.goal.UniversalAngerGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.mob.Angerable
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.passive.ChickenEntity
import net.minecraft.entity.passive.FishEntity
import net.minecraft.entity.passive.RabbitEntity
import net.minecraft.world.Difficulty
import net.minecraft.world.World
import java.util.*

class PiranhaEntity(entityType: EntityType<out PiranhaEntity>, world: World) :
    HybridAquaticSchoolingFishEntity(entityType, world), Angerable {

    private var angerTime = 0
    private var angryAt: UUID? = null

    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0)
        }
        val ATTEMPT_ATTACK: TrackedData<Boolean> =
            DataTracker.registerData(PiranhaEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
    }
    private var attemptAttack: Boolean
        get() = dataTracker.get(ATTEMPT_ATTACK)
        set(attemptAttack) {
            dataTracker.set(ATTEMPT_ATTACK, attemptAttack)
        }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(1, AttackGoal(this))
        targetSelector.add(5, UniversalAngerGoal(this, true))
        targetSelector.add(7, ActiveTargetGoal(this, FishEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, ChickenEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, RabbitEntity::class.java, true, true))
        targetSelector.add(3, RevengeGoal(this, *arrayOfNulls(0)).setGroupRevenge(*arrayOfNulls(5)))
    }
    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(ATTEMPT_ATTACK, false)
    }

    internal class AttackGoal(private val piranha: PiranhaEntity) : MeleeAttackGoal(piranha,1.2, true) {
        override fun attack(target: LivingEntity, squaredDistance: Double) {
            val d = getSquaredMaxAttackDistance(target)
            if (squaredDistance <= d && this.isCooledDown) {
                resetCooldown()
                mob.tryAttack(target)
                piranha.attemptAttack = true
                    }
                }
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

    override fun getAngerTime(): Int {
        return angerTime
    }

    override fun setAngerTime(angerTime: Int) {
        this.angerTime = angerTime
    }

    override fun getAngryAt(): UUID? {
        return angryAt
    }

    override fun setAngryAt(angryAt: UUID?) {
        this.angryAt = angryAt
    }

    override fun chooseRandomAngerTime() {
        setAngerTime(HybridAquaticSharkEntity.ANGER_TIME_RANGE.get(random))
    }

    override fun getMaxSize(): Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}