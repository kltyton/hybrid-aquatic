package dev.hybridlabs.aquatic.block.entity

import dev.hybridlabs.aquatic.effect.HybridAquaticStatusEffects
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.effect.StatusEffects.ABSORPTION
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

    companion object {
        val FLOAT_ANIMATION: RawAnimation = RawAnimation.begin().then("float", Animation.LoopType.LOOP)

        fun tick(world: World, pos: BlockPos, state: BlockState, blockEntity: BuoyBlockEntity) {
            for (entitiesByClass in world.getEntitiesByClass(
                PlayerEntity::class.java,
                Box(pos.x - 6.0, pos.y - 6.0, pos.z - 6.0, pos.x + 6.0, pos.y + 6.0, pos.z + 6.0)
            ) { true }) {
                val effect = StatusEffectInstance(HybridAquaticStatusEffects.CLARITY, 16, 1)
                entitiesByClass.addStatusEffect(effect)
            }
        }
    }
}
