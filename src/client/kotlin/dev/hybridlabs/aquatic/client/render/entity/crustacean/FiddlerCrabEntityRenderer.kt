package dev.hybridlabs.aquatic.client.render.entity.crustacean

import dev.hybridlabs.aquatic.client.model.entity.FiddlerCrabEntityModel
import dev.hybridlabs.aquatic.client.render.entity.critter.HybridAquaticCritterEntityRenderer
import dev.hybridlabs.aquatic.entity.critter.HybridAquaticCritterEntity
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory.Context
import net.minecraft.client.util.math.MatrixStack

class FiddlerCrabEntityRenderer(context: Context) : HybridAquaticCritterEntityRenderer<HybridAquaticCritterEntity>(context, FiddlerCrabEntityModel()) {
    override fun render(
        entity: HybridAquaticCritterEntity?,
        entityYaw: Float,
        partialTick: Float,
        poseStack: MatrixStack?,
        bufferSource: VertexConsumerProvider?,
        packedLight: Int
    ) {
        val size = HybridAquaticCritterEntity.getScaleAdjustment(entity!!, 0.05f)
        poseStack!!.scale(size, size, size)
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight)
    }
}
