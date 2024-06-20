package dev.hybridlabs.aquatic.entity.crustacean

import dev.hybridlabs.aquatic.tag.HybridAquaticBlockTags
import dev.hybridlabs.aquatic.tag.HybridAquaticItemTags
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityData
import net.minecraft.entity.EntityGroup
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.ai.control.MoveControl
import net.minecraft.entity.ai.goal.LookAroundGoal
import net.minecraft.entity.ai.goal.LookAtEntityGoal
import net.minecraft.entity.ai.goal.TemptGoal
import net.minecraft.entity.ai.goal.WanderAroundGoal
import net.minecraft.entity.ai.pathing.AmphibiousSwimNavigation
import net.minecraft.entity.ai.pathing.EntityNavigation
import net.minecraft.entity.ai.pathing.PathNodeType
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.data.TrackedData
import net.minecraft.entity.data.TrackedDataHandlerRegistry
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.*
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.*
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil

@Suppress("DEPRECATION", "LeakingThis", "UNUSED_PARAMETER")
open class HybridAquaticCrustaceanEntity(
    type: EntityType<out HybridAquaticCrustaceanEntity>,
    world: World,
    private val variantCount: Int = 1,
    open val canDig: Boolean,
    open val canDance: Boolean,
) : WaterCreatureEntity(type, world), GeoEntity {
    private val factory = GeckoLibUtil.createInstanceCache(this)
    private var landNavigation: EntityNavigation = createNavigation(world)
    private var songSource: BlockPos? = null
    private var songPlaying: Boolean = false

    var diggingCooldown: Int = 0
    var isDigging: Boolean
        get() = dataTracker.get(IS_DIGGING)
        set(bool) {
            dataTracker.set(IS_DIGGING, bool)
        }

    var variant: Int
        get() = dataTracker.get(VARIANT).coerceAtLeast(0).coerceAtMost(variantCount-1)
        set(int) {
            dataTracker.set(VARIANT, int)
        }

    var size: Int
        get() = dataTracker.get(CRUSTACEAN_SIZE)
        set(size) {
            dataTracker.set(CRUSTACEAN_SIZE, size)
        }

    override fun initDataTracker() {
        super.initDataTracker()
        dataTracker.startTracking(MOISTNESS, getMaxMoistness())
        dataTracker.startTracking(IS_DIGGING, false)
        dataTracker.startTracking(VARIANT, 0)
        dataTracker.startTracking(CRUSTACEAN_SIZE, 0)
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(2, WanderAroundGoal(this, 0.3))
        goalSelector.add(2, LookAroundGoal(this))
        goalSelector.add(1, TemptGoal(this, 0.5, Ingredient.fromTag(HybridAquaticItemTags.CRUSTACEAN_TEMPT_ITEMS), false))
        goalSelector.add(8, LookAtEntityGoal(this, PlayerEntity::class.java, 10.0f))
    }

    override fun initialize(
        world: ServerWorldAccess,
        difficulty: LocalDifficulty,
        spawnReason: SpawnReason,
        entityData: EntityData?,
        entityNbt: NbtCompound?
    ): EntityData? {
        this.air = getMaxMoistness()
        this.variant = this.random.nextInt(variantCount)
        this.size = this.random.nextBetween(getMinSize(),getMaxSize())
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt)
    }

    // region movement
    override fun createNavigation(world: World): EntityNavigation {
        return AmphibiousSwimNavigation(this, world)
    }

    init {
        setPathfindingPenalty(PathNodeType.WATER, 0.0f)
        moveControl = MoveControl(this)
        navigation = this.landNavigation
        stepHeight = 1.0F
    }

    override fun getPathfindingFavor(pos: BlockPos?, world: WorldView?): Float {
        return 0.0f
    }

    override fun hasNoDrag(): Boolean {
        return false
    }

    override fun shouldSwimInFluids(): Boolean {
        return false
    }

    // end region

    override fun setNearbySongPlaying(songPosition: BlockPos?, playing: Boolean) {
        songSource = songPosition
        songPlaying = playing
        super.setNearbySongPlaying(songPosition, playing)
    }

    override fun mobTick() {
        if (diggingCooldown > 0) {
            diggingCooldown--
            if (isDigging) {
                this.movementSpeed = 0.0F
            }
        }

        super.mobTick()
    }


    override fun getGroup(): EntityGroup? {
        return EntityGroup.ARTHROPOD
    }

    protected open fun getMinSize(): Int {
        return 0
    }

    protected open fun getMaxSize(): Int {
        return 0
    }

    override fun writeCustomDataToNbt(nbt: NbtCompound) {
        super.writeCustomDataToNbt(nbt)
        nbt.putInt(MOISTNESS_KEY, moistness)
        nbt.putInt(DIGGING_COOLDOWN_KEY, diggingCooldown)
        nbt.putInt(VARIANT_KEY, variant)
        nbt.putInt(CRUSTACEAN_SIZE_KEY, size)
    }

    override fun readCustomDataFromNbt(nbt: NbtCompound) {
        super.readCustomDataFromNbt(nbt)
        moistness = nbt.getInt(MOISTNESS_KEY)
        diggingCooldown = nbt.getInt(DIGGING_COOLDOWN_KEY)
        variant = nbt.getInt(VARIANT_KEY).coerceAtLeast(0).coerceAtMost(variantCount-1)
        size = nbt.getInt(CRUSTACEAN_SIZE_KEY)
    }

    override fun isPushedByFluids(): Boolean {
        return false
    }

    // region sounds

    override fun calculateNextStepSoundDistance(): Float {
        return this.distanceTraveled + 0.5f
    }

    override fun getMinAmbientSoundDelay(): Int {
        return 200
    }

    override fun getHurtSound(source: DamageSource): SoundEvent {
        return SoundEvents.ENTITY_TURTLE_EGG_CRACK
    }

    override fun getDeathSound(): SoundEvent {
        return SoundEvents.ENTITY_TURTLE_EGG_BREAK
    }

    override fun getAmbientSound(): SoundEvent {
        return SoundEvents.ENTITY_COD_AMBIENT
    }

    // endregion

    // region water breathing

    private var moistness: Int
        get() = dataTracker.get(MOISTNESS)
        set(moistness) {
            dataTracker.set(MOISTNESS, moistness)
        }

    override fun tick() {
        super.tick()
        if (isAiDisabled) {
            return
        }

        if (isSubmergedInWater) {
            moistness = getMaxMoistness()
        } else if (!isSubmergedInWater) {
            moistness -= 1
            if (moistness <= -20) {
                moistness = 0
                damage(this.damageSources.dryOut(), 1.0f)
            }
        }
    }

    override fun getNextAirOnLand(air: Int): Int {
        return this.maxAir
    }

    override fun tickWaterBreathingAir(air: Int) {}

    private fun getMaxMoistness(): Int {
        return 3000
    }

    // endregion

    override fun getLimitPerChunk(): Int {
        return 4
    }

    override fun canImmediatelyDespawn(distanceSquared: Double): Boolean {
        return !hasCustomName()
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

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }

    open fun <E : GeoAnimatable> predicate(event: AnimationState<E>): PlayState {
        if (event.isMoving) {
            event.controller.setAnimation(WALK_ANIMATION)
        } else {
            event.controller.setAnimation(IDLE_ANIMATION)
        }
        if (canDig && isDigging) {
            event.controller.setAnimation(DIG_ANIMATION)
        }
        if (canDance && songPlaying)
            event.controller.setAnimation(DANCE_ANIMATION)
        return PlayState.CONTINUE
    }

    companion object {
        val MOISTNESS: TrackedData<Int> = DataTracker.registerData(HybridAquaticCrustaceanEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
        val VARIANT: TrackedData<Int> = DataTracker.registerData(HybridAquaticCrustaceanEntity::class.java, TrackedDataHandlerRegistry.INTEGER)
        val CRUSTACEAN_SIZE: TrackedData<Int> = DataTracker.registerData(HybridAquaticCrustaceanEntity::class.java, TrackedDataHandlerRegistry.INTEGER)

        val DANCE_ANIMATION: RawAnimation = RawAnimation.begin().then("dance", Animation.LoopType.LOOP)
        val DIG_ANIMATION: RawAnimation = RawAnimation.begin().then("dig", Animation.LoopType.LOOP)
        val WALK_ANIMATION: RawAnimation = RawAnimation.begin().then("walk", Animation.LoopType.LOOP)
        val IDLE_ANIMATION: RawAnimation = RawAnimation.begin().then("idle", Animation.LoopType.LOOP)
        val HIDING_ANIMATION: RawAnimation = RawAnimation.begin().then("hide", Animation.LoopType.LOOP)

        fun canSpawn(
            type: EntityType<out WaterCreatureEntity?>?,
            world: WorldAccess,
            reason: SpawnReason?,
            pos: BlockPos,
            random: Random?
        ): Boolean {
            val topY = world.seaLevel + 6
            val bottomY = world.seaLevel - 48

            return pos.y in bottomY..topY &&
                    world.getBlockState(pos.down()).isIn(HybridAquaticBlockTags.CRABS_SPAWN_ON) &&
                    (world.isWater(pos) || world.isAir(pos))
        }

        fun canUndergroundSpawn(
            type: EntityType<out WaterCreatureEntity?>?,
            world: WorldAccess,
            reason: SpawnReason?,
            pos: BlockPos,
            random: Random?
        ): Boolean {
            val topY = world.seaLevel + 6
            val bottomY = world.seaLevel - 48

            return pos.y in bottomY..topY &&
                    world.getBaseLightLevel(pos, 0) == 0 &&
                    world.getBlockState(pos).isOf(Blocks.WATER) &&
                    world.getBlockState(pos.down()).isIn(HybridAquaticBlockTags.CRABS_SPAWN_ON)
        }

        fun getScaleAdjustment(crustacean : HybridAquaticCrustaceanEntity, adjustment : Float): Float {
            return 1.0f + (crustacean.size * adjustment)
        }

        const val MOISTNESS_KEY = "Moistness"
        const val VARIANT_KEY = "Variant"
        const val CRUSTACEAN_SIZE_KEY = "CrustaceanSize"

        val IS_DIGGING: TrackedData<Boolean> =
            DataTracker.registerData(HybridAquaticCrustaceanEntity::class.java, TrackedDataHandlerRegistry.BOOLEAN)
        const val DIGGING_COOLDOWN_KEY = "DiggingCooldown"
    }
}