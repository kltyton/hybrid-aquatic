package dev.hybridlabs.aquatic.entity.miniboss

import net.minecraft.block.Blocks
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.goal.ActiveTargetGoal
import net.minecraft.entity.ai.goal.MeleeAttackGoal
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.Angerable
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.tag.FluidTags
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.*
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.*


@Suppress("LeakingThis")
open class HybridAquaticMinibossEntity(type: EntityType<out HybridAquaticMinibossEntity>, world: World) : HostileEntity(type, world),
    Angerable, GeoEntity {

    private val factory = GeckoLibUtil.createInstanceCache(this)
    private var attackTick = 0
    private var angerTime = 0
    private var angryAt: UUID? = null
    private var attemptAttack: Boolean
        get() = dataTracker.get(ATTEMPT_ATTACK)
        set(attemptAttack) {
            dataTracker.set(ATTEMPT_ATTACK, attemptAttack)
        }

    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(ATTEMPT_ATTACK, false)
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(1, AttackGoal(this))
        targetSelector.add(2, ActiveTargetGoal(this, PlayerEntity::class.java, 10, true, true, null))
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        super.writeCustomDataToNbt(nbt)
        nbt.putInt("AttackTick", this.attackTick)
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        super.readCustomDataFromNbt(nbt)
        this.attackTick = nbt.getInt("AttackTick")
    }

    override fun tick() {
        super.tick()
        if (isAiDisabled) {
            return
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
        setAngerTime(random.nextInt(10))
    }

    override fun tryAttack(target: Entity?): Boolean {
        this.attackTick = 10
        world.sendEntityStatus(this, 4.toByte())
        return super.tryAttack(target)
    }

    override fun isPushedByFluids(): Boolean {
        return false
    }

    override fun canImmediatelyDespawn(distanceSquared: Double): Boolean {
        return false
    }

    override fun canBreatheInWater(): Boolean {
        return true
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
        if (event.isMoving) {
            event.controller.setAnimation(WALK_ANIMATION)
        } else {
            event.controller.setAnimation(IDLE_ANIMATION)
        }
        return PlayState.CONTINUE
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }

    internal open class AttackGoal(private val miniboss: HybridAquaticMinibossEntity) : MeleeAttackGoal(miniboss, 0.6, false) {
        override fun attack(target: LivingEntity, squaredDistance: Double) {
            val d = getSquaredMaxAttackDistance(target)
            if (squaredDistance <= d && this.isCooledDown) {
                resetCooldown()
                mob.tryAttack(target)
                miniboss.attemptAttack = true
            }
        }

        override fun getSquaredMaxAttackDistance(entity: LivingEntity): Double {
            return (4.0f + entity.width).toDouble()
        }

        override fun start() {
            super.start()
            miniboss.attemptAttack = false
        }

        override fun stop() {
            super.stop()
            miniboss.attemptAttack = false
        }
    }

    private fun shouldProximityAttack(player: PlayerEntity): Boolean {

        return player.squaredDistanceTo(this) <= 24 && !player.isCreative
    }

    override fun isAngryAt(player: PlayerEntity?): Boolean {
        return true
    }

    companion object {

        val WALK_ANIMATION: RawAnimation  = RawAnimation.begin().then("walk", Animation.LoopType.LOOP)
        val IDLE_ANIMATION: RawAnimation  = RawAnimation.begin().then("idle", Animation.LoopType.LOOP)

        val ATTEMPT_ATTACK: TrackedData<Boolean> =
            DataTracker.registerData(HybridAquaticMinibossEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)

        val FLIPPED_ANIMATION: RawAnimation = RawAnimation.begin().then("flipped", Animation.LoopType.LOOP)

        fun canSpawn(
            type: EntityType<out HostileEntity>,
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
    }
}

