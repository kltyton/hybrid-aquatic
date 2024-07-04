package dev.hybridlabs.aquatic.client.render.entity.crustacean

import dev.hybridlabs.aquatic.client.model.entity.crustacean.KarkinosEntityModel
import dev.hybridlabs.aquatic.entity.crustacean.HybridAquaticCrustaceanEntity
import net.minecraft.client.render.entity.EntityRendererFactory.Context

class KarkinosEntityRenderer(context: Context) : HybridAquaticCrustaceanEntityRenderer<HybridAquaticCrustaceanEntity>(context, KarkinosEntityModel()) {
    override fun getMotionAnimThreshold(animatable: HybridAquaticCrustaceanEntity): Float {
        return 0.0025f
    }
}