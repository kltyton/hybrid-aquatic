package dev.hybridlabs.aquatic.client.render.entity.crustacean

import dev.hybridlabs.aquatic.client.model.entity.crustacean.KarkinosEntityModel
import dev.hybridlabs.aquatic.client.render.entity.miniboss.HybridAquaticMinibossEntityRenderer
import dev.hybridlabs.aquatic.entity.miniboss.HybridAquaticMinibossEntity
import net.minecraft.client.render.entity.EntityRendererFactory.Context

class KarkinosEntityRenderer(context: Context) : HybridAquaticMinibossEntityRenderer<HybridAquaticMinibossEntity>(context, KarkinosEntityModel()) {
    override fun getMotionAnimThreshold(animatable: HybridAquaticMinibossEntity): Float {
        return 0.0025f
    }
}