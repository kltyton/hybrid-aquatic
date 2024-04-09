package dev.hybridlabs.aquatic.entity.fish

import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.goal.ActiveTargetGoal
import net.minecraft.entity.ai.goal.MeleeAttackGoal
import net.minecraft.entity.ai.goal.RevengeGoal
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.passive.FishEntity
import net.minecraft.registry.tag.DamageTypeTags
import net.minecraft.world.World

class LionfishEntity(entityType: EntityType<out LionfishEntity>, world: World) :
    HybridAquaticFishEntity(entityType, world) {
    companion object {
        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75)
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
        targetSelector.add(7, ActiveTargetGoal(this, RockfishEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, ClownfishEntity::class.java, true, true))
        targetSelector.add(7, ActiveTargetGoal(this, BlueTangEntity::class.java, true, true))
    }
    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(PiranhaEntity.ATTEMPT_ATTACK, false)
    }

    internal class AttackGoal(private val lionfish: LionfishEntity) : MeleeAttackGoal(lionfish,1.2, true) {
        override fun attack(target: LivingEntity, squaredDistance: Double) {
            val d = getSquaredMaxAttackDistance(target)
            if (squaredDistance <= d && this.isCooledDown) {
                resetCooldown()
                mob.tryAttack(target)
                lionfish.attemptAttack = true
            }
        }
    }

    override fun shouldFlopOnLand(): Boolean {
        return false
    }

    override fun damage(source: DamageSource, amount: Float): Boolean {
        return if (world.isClient) {
            false
        } else {
            if (!source.isIn(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !source.isOf(DamageTypes.THORNS)) {
                val attacker = source.source
                if (attacker is LivingEntity) {
                    attacker.addStatusEffect(StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), this)
                    attacker.addStatusEffect(StatusEffectInstance(StatusEffects.POISON, 200, 0), this)
                }
            }
            super.damage(source, amount)
        }
    }

    override fun getMaxSize(): Int {
        return 5
    }

    override fun getMinSize(): Int {
        return -5
    }
}