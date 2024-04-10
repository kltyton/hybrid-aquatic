package dev.hybridlabs.aquatic.entity.miniboss

import dev.hybridlabs.aquatic.entity.critter.HybridAquaticCritterEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.brain.task.TaskTriggerer.predicate
import net.minecraft.entity.mob.WaterCreatureEntity
import net.minecraft.world.World
import software.bernie.geckolib.animatable.GeoEntity
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animation.AnimatableManager
import software.bernie.geckolib.core.animation.AnimationController
import software.bernie.geckolib.core.animation.AnimationState
import software.bernie.geckolib.core.`object`.PlayState
import software.bernie.geckolib.util.GeckoLibUtil


@Suppress("LeakingThis")
open class HybridAquaticMinibossEntity(type: EntityType<out HybridAquaticMinibossEntity>, world: World, private val variantCount: Int = 1) : WaterCreatureEntity(type, world),
    GeoEntity {

    private val factory = GeckoLibUtil.createInstanceCache(this)

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
            event.controller.setAnimation(HybridAquaticCritterEntity.WALK_ANIMATION)
        } else {
            event.controller.setAnimation(HybridAquaticCritterEntity.IDLE_ANIMATION)
        }
        return PlayState.CONTINUE
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return factory
    }
}

