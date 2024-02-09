package dev.hybridlabs.aquatic.item

import dev.hybridlabs.aquatic.client.render.armor.DivingArmorRenderer
import net.minecraft.client.render.entity.model.BipedEntityModel
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import software.bernie.geckolib.animatable.GeoItem
import software.bernie.geckolib.animatable.client.RenderProvider
import software.bernie.geckolib.core.animatable.GeoAnimatable
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache
import software.bernie.geckolib.core.animation.*
import software.bernie.geckolib.core.`object`.PlayState
import java.util.function.Consumer
import java.util.function.Supplier


open class DivingArmorItem(material: ArmorMaterial?, type: Type?, settings: Settings?) :
    ArmorItem(material, type, settings), GeoItem {
    private val cache: AnimatableInstanceCache = SingletonAnimatableInstanceCache(
        this
    )
    private val renderProvider: Supplier<Any> = GeoItem.makeRenderer(this)


    override fun createRenderer(consumer: Consumer<Any?>) {
        consumer.accept(object : RenderProvider {
            private var renderer: DivingArmorRenderer? = null

            override fun getHumanoidArmorModel(
                livingEntity: LivingEntity?, itemStack: ItemStack?,
                equipmentSlot: EquipmentSlot?, original: BipedEntityModel<LivingEntity?>?
            ): BipedEntityModel<LivingEntity>? {
                if (this.renderer == null) this.renderer = DivingArmorRenderer()

                renderer!!.prepForRender(livingEntity, itemStack, equipmentSlot, original)

                return this.renderer
            }
        })
    }

    override fun getRenderProvider(): Supplier<Any> {
        return this.renderProvider
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
        if (isPerspectiveAware) {
            event.controller.setAnimation(IDLE_ANIMATION)
            return PlayState.CONTINUE
        }
        return PlayState.STOP
    }

    override fun getAnimatableInstanceCache(): AnimatableInstanceCache {
        return this.cache
    }
    companion object {
        val IDLE_ANIMATION: RawAnimation  = RawAnimation.begin().then("idle", Animation.LoopType.LOOP)
    }
}