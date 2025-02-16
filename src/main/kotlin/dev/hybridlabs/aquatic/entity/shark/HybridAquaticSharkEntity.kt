package dev.hybridlabs.aquatic.entity.shark

import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects
import dev.hybridlabs.aquatic.entity.fish.HybridAquaticFishEntity
import net.minecraft.block.Blocks
import net.minecraft.entity.*
import net.minecraft.entity.ai.control.AquaticMoveControl
import net.minecraft.entity.ai.control.YawAdjustingLookControl
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.ai.pathing.PathNodeType
import net.minecraft.entity.ai.pathing.SwimNavigation
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.Angerable
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.tag.FluidTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.TimeHelper
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.math.random.Random
import net.minecraft.world.LocalDifficulty
import net.minecraft.world.ServerWorldAccess
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.constant.DefaultAnimations
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.animation.EasingType
import software.bernie.geckolib.util.GeckoLibUtil
import java.util.*


@Suppress("LeakingThis", "DEPRECATION", "UNUSED_PARAMETER")
open class HybridAquaticSharkEntity(
    entityType: EntityType<out HybridAquaticSharkEntity>,
    world: World,
    private val prey: List<TagKey<EntityType<*>>>,
    private val isPassive: Boolean,
    private val closePlayerAttack: Boolean
) : WaterCreatureEntity(entityType, world), Angerable, GeoEntity {
    private val factory = GeckoLibUtil.createInstanceCache(this)
    private var angerTime = 0
    private var angryAt: UUID? = null
    private var moistness: Int
        get() = dataTracker.get(MOISTNESS)
        set(moistness) {
            dataTracker.set(MOISTNESS, moistness)
        }
    private var hunger: Int
        get() = dataTracker.get(HUNGER)
        set(hunger) {
            dataTracker.set(HUNGER, hunger)
        }
    var size: Int
        get() = dataTracker.get(SHARK_SIZE)
        set(size) {
            dataTracker.set(SHARK_SIZE, size)
        }

    init {
        setPathfindingPenalty(PathNodeType.WATER, 0.0f)
        moveControl = AquaticMoveControl(this, 75, 5, movementSpeed, 0.1F, true)
        lookControl = YawAdjustingLookControl(this, 5)
        navigation = SwimNavigation(this, world)
    }

    companion object {
        const val MOISTNESS_KEY = "Moistness"
        const val SHARK_SIZE_KEY = "SharkSize"
        val SHARK_SIZE: TrackedData<Int> = DataTracker.registerData(HybridAquaticSharkEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
        val MOISTNESS: TrackedData<Int> =
            DataTracker.registerData(HybridAquaticSharkEntity::class.java, TrackedDataHandlerRegistry.INTEGER)

        const val MAX_HUNGER = 1200
        const val HUNGER_KEY = "Hunger"

        val HUNGER: TrackedData<Int> =
            DataTracker.registerData(HybridAquaticSharkEntity::class.java, TrackedDataHandlerRegistry.INTEGER)

        val ANGER_TIME_RANGE: UniformIntProvider = TimeHelper.betweenSeconds(10, 30)


        fun canSpawn(
            type: EntityType<out WaterCreatureEntity>,
            world: WorldAccess,
            reason: SpawnReason?,
            pos: BlockPos,
            random: Random?
        ): Boolean {
            val topY = world.seaLevel - 8
            val bottomY = world.seaLevel - 24

            return pos.y in bottomY..topY &&
                    world.getFluidState(pos.down()).isIn(FluidTags.WATER) &&
                    world.getBlockState(pos.up()).isOf(Blocks.WATER)
        }
        fun getScaleAdjustment(shark : HybridAquaticSharkEntity, adjustment : Float): Float {
            return 1.0f + (shark.size * adjustment)
        }
    }

    override fun getMaxHeadRotation(): Int {
        return 1
    }

    override fun getMaxLookPitchChange(): Int {
        return 1
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(4, SwimAroundGoal(this, 1.0, 2))
        goalSelector.add(4, LookAroundGoal(this))
        goalSelector.add(5, LookAtEntityGoal(this, PlayerEntity::class.java, 6.0f))
        goalSelector.add(1, MeleeAttackGoal(this, 1.1, false))
        targetSelector.add(2, ActiveTargetGoal(this, PlayerEntity::class.java, 10, true, true) { entity: LivingEntity -> shouldAngerAt(entity) || shouldProximityAttack(entity as PlayerEntity) && !isPassive})
        targetSelector.add(3, ActiveTargetGoal(this, LivingEntity::class.java, 10, true, true) { entity -> hunger <= 100 && prey.any { entity.type.isIn(it) } && !isPassive })
        targetSelector.add(1, ActiveTargetGoal(this, LivingEntity::class.java, 10, true, true) { it.hasStatusEffect(HybridAquaticStatusEffects.BLEEDING) && it !is HybridAquaticSharkEntity && !isPassive})
        }

    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(MOISTNESS, getMaxMoistness())
        dataTracker.startTracking(HUNGER, MAX_HUNGER)
        dataTracker.startTracking(SHARK_SIZE, 0)
    }

    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?,
        entityNbt: NbtCompound?
    ): EntityData? {
        this.air = getMaxMoistness()
        pitch = 0.0f
        this.size = this.random.nextBetween(getMinSize(),getMaxSize())
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt)
    }

    override fun tick() {
        super.tick()
        if (isAiDisabled) {
            return
        }

    if (this.isWet) {
            moistness = getMaxMoistness()
        } else {
            moistness -= 1
            if (moistness <= -20) {
                moistness = 0
                damage(this.damageSources.dryOut(), 1.0f)
            }
        }

        if (!this.isSubmergedInWater) {
            this.pitch = 0.0f
        }

        isSprinting = isAttacking

        if (isAttacking) {
            attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)?.baseValue = 3.0
        } else {
            attributes.getCustomInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)?.baseValue = 1.0
        }
        if (hunger > 0) hunger -= 1
    }

    override fun tickMovement() {
        this.tickHandSwing()
        super.tickMovement()
    }

    override fun tickWaterBreathingAir(air: Int) {}

    private fun getMaxMoistness(): Int {
        return 1200
    }

    override fun travel(movementInput: Vec3d?) {
        super.travel(movementInput)
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        super.writeCustomDataToNbt(nbt)
        this.writeAngerToNbt(nbt)
        nbt.putInt(MOISTNESS_KEY, moistness)
        nbt.putInt(HUNGER_KEY, hunger)
        nbt.putInt(SHARK_SIZE_KEY, size)
        nbt.putBoolean("FromFishingNet", fromFishingNet)
    }

    private var fromFishingNet = false

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        super.readCustomDataFromNbt(nbt)
        this.readAngerFromNbt(this.world, nbt)
        moistness = nbt.getInt(MOISTNESS_KEY)
        hunger = nbt.getInt(HUNGER_KEY)
        size = nbt.getInt(SHARK_SIZE_KEY)
        fromFishingNet = nbt.getBoolean("FromFishingNet")
    }

    protected open fun getMinSize() : Int {
        return 0
    }

    protected open fun getMaxSize() : Int {
        return 0
    }

    override fun getActiveEyeHeight(pose: EntityPose, dimensions: EntityDimensions): Float {
        return dimensions.height * 0.65f
    }

    override fun canImmediatelyDespawn(distanceSquared: Double): Boolean {
        return false
    }

    override fun getLimitPerChunk(): Int {
        return 3
    }

    //#region SFX
    override fun getHurtSound(source: DamageSource): SoundEvent {
        return SoundEvents.ENTITY_HOSTILE_HURT
    }

    override fun getDeathSound(): SoundEvent {
        return SoundEvents.ENTITY_HOSTILE_DEATH
    }

    override fun getAmbientSound(): SoundEvent {
        return SoundEvents.ENTITY_COD_AMBIENT
    }

    override fun getSwimSound(): SoundEvent {
        return SoundEvents.ENTITY_DOLPHIN_SWIM
    }

    //#endregion
    override fun getMaxAir(): Int {
        return 4800
    }

    public override fun getNextAirOnLand(air: Int): Int {
        return this.maxAir
    }

    override fun registerControllers(controllerRegistrar: AnimatableManager.ControllerRegistrar) {
        controllerRegistrar.add(
            AnimationController(
                this,
                "Swim/Run",
                20
            ) { state: AnimationState<HybridAquaticSharkEntity> ->
                if (!this.isSubmergedInWater && isOnGround) {
                    state.setAndContinue(DefaultAnimations.SIT)
                } else {
                    if (state.isMoving) {
                        state.setAndContinue(if (this.isSprinting) DefaultAnimations.RUN else DefaultAnimations.SWIM)
                    } else {
                        state.setAndContinue(DefaultAnimations.SWIM)
                    }
                }
            }.setOverrideEasingType(EasingType.EASE_IN_OUT_SINE)
        )
        controllerRegistrar.add(DefaultAnimations.genericAttackAnimation(this, DefaultAnimations.ATTACK_BITE))
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }

    private fun shouldProximityAttack(player: PlayerEntity): Boolean {
        if (customName?.string == "friend")
            return false

        return closePlayerAttack && player.squaredDistanceTo(this) <= 12 && !player.isCreative
    }

    //#region Angerable Implementation Details
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
        setAngerTime(ANGER_TIME_RANGE.get(random))
    }
    //#endregion

    override fun dropLoot(source: DamageSource, causedByPlayer: Boolean) {
        val attacker = source.attacker
        if (attacker !is HybridAquaticFishEntity && attacker !is HybridAquaticSharkEntity) {
            super.dropLoot(source, causedByPlayer)
        }
    }
}