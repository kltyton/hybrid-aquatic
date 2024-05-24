package dev.hybridlabs.aquatic.entity.pirate

import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.mob.PillagerEntity
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.passive.IronGolemEntity
import net.minecraft.entity.passive.MerchantEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.SimpleInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.RangedWeaponItem
import net.minecraft.registry.tag.FluidTags
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil

open class HybridAquaticPirateEntity(
    type: EntityType<out HybridAquaticPirateEntity>,
    world: World,
    private val inventory: SimpleInventory = SimpleInventory(5),

) : PillagerEntity(type, world), GeoEntity {
    private val factory = GeckoLibUtil.createInstanceCache(this)
    private var attemptAttack: Boolean
        get() = dataTracker.get(ATTEMPT_ATTACK)
        set(attemptAttack) {
            dataTracker.set(ATTEMPT_ATTACK, attemptAttack)
        }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(3, CrossbowAttackGoal(this, 1.0, 8.0f))
        goalSelector.add(3, MeleeAttackGoal(this, 1.0, true))
        goalSelector.add(8, WanderAroundGoal(this, 0.6))
        goalSelector.add(9, LookAtEntityGoal(this, PlayerEntity::class.java, 15.0f, 1.0f))
        goalSelector.add(10, LookAtEntityGoal(this, MobEntity::class.java, 15.0f))
        targetSelector.add(2, ActiveTargetGoal(this, PlayerEntity::class.java, true))
        targetSelector.add(3, ActiveTargetGoal(this, MerchantEntity::class.java, false))
        targetSelector.add(3, ActiveTargetGoal(this, IronGolemEntity::class.java, true))
    }

    override fun canUseRangedWeapon(weapon: RangedWeaponItem): Boolean {
        return weapon === Items.CROSSBOW
    }

    override fun initEquipment(random: Random?, localDifficulty: LocalDifficulty?) {
        this.equipStack(EquipmentSlot.MAINHAND, ItemStack(Items.CROSSBOW))
    }

    override fun getAmbientSound(): SoundEvent {
        return SoundEvents.ENTITY_PILLAGER_AMBIENT
    }

    override fun getDeathSound(): SoundEvent {
        return SoundEvents.ENTITY_PILLAGER_DEATH
    }

    override fun getHurtSound(source: DamageSource?): SoundEvent {
        return SoundEvents.ENTITY_PILLAGER_HURT
    }

    override fun getCelebratingSound(): SoundEvent {
        return SoundEvents.ENTITY_PILLAGER_CELEBRATE
    }

    override fun getInventory(): SimpleInventory {
        return this.inventory
    }

    override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {
        controllerRegistrar.add(
            AnimationController(
                this,
                "controller",
                0,
                ::predicate
            )
        )
    }

    open fun <E : GeoAnimatable> predicate(event: AnimationState<E>): PlayState {
        return PlayState.STOP
    }

    internal class AttackGoal(private val pirate: HybridAquaticPirateEntity) : MeleeAttackGoal(pirate, 1.0, true) {

        override fun attack(target: LivingEntity, squaredDistance: Double) {
            val d = getSquaredMaxAttackDistance(target)
            if (squaredDistance <= d && this.isCooledDown) {
                resetCooldown()
                mob.tryAttack(target)
                pirate.isSprinting = true
                pirate.attemptAttack = true
            }
        }

        override fun getSquaredMaxAttackDistance(entity: LivingEntity): Double {
            return (1.25f + entity.width).toDouble()
        }

        override fun start() {
            super.start()
            pirate.attemptAttack = false
        }

        override fun stop() {
            super.stop()
            pirate.attemptAttack = false
        }
    }

    companion object {
        fun canSpawn(
            type: EntityType<out WaterCreatureEntity>,
            world: WorldAccess,
            reason: SpawnReason?,
            pos: BlockPos,
            random: Random?
        ): Boolean {
            val topY = world.seaLevel
            val bottomY = world.seaLevel - 24

            return pos.y in bottomY..topY &&
                    world.getFluidState(pos.down()).isIn(FluidTags.WATER) &&
                    world.getBlockState(pos.up()).isOf(Blocks.WATER)
        }

        val ATTEMPT_ATTACK: TrackedData<Boolean> =
            DataTracker.registerData(HybridAquaticPirateEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
    }
}