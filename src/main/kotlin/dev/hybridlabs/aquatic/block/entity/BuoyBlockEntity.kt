package dev.hybridlabs.aquatic.block.entity

import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.world.World
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.*
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil
import software.bernie.geckolib.util.RenderUtils


class BuoyBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(HybridAquaticBlockEntityTypes.BUOY, pos, state), GeoAnimatable {
    private val animCache = GeckoLibUtil.createInstanceCache(this)

    private fun <E> predicate(event: AnimationState<E>): PlayState where E : BlockEntity?, E : GeoAnimatable {
        return if (world != null) {
            event.controller.setAnimation(FLOAT_ANIMATION)
            PlayState.CONTINUE
        } else {
            PlayState.STOP
        }
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
        return animCache
    }

    override fun getTick(p0: Any?): Double {
        return RenderUtils.getCurrentTick()
    }

    private fun givePlayersEffects(world: World, pos: BlockPos) {
        val j = 12

        val box = Box(
            pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble(),
            (pos.x + 1).toDouble(), (pos.y + 1).toDouble(), (pos.z + 1).toDouble()
        ).expand(j.toDouble()).stretch(0.0, world.height.toDouble(), 0.0)

        val list = world.getNonSpectatingEntities(PlayerEntity::class.java, box)
        if (list.isNotEmpty()) {
            for (entity in list) {
                if (pos.isWithinDistance(entity.blockPos, j.toDouble())) {
                    entity.addStatusEffect(StatusEffectInstance(HybridAquaticStatusEffects.CLARITY, 200, 0, true, false))
                }
            }
        }
    }

    companion object {
        val FLOAT_ANIMATION: RawAnimation = RawAnimation.begin().then("float", Animation.LoopType.LOOP)

        fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: BuoyBlockEntity) {
            blockEntity.givePlayersEffects(world, pos)
        }
    }
}
