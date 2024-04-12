package dev.hybridlabs.aquatic.client.render.entity.cephalopods

import dev.hybridlabs.aquatic.client.model.entity.VampireSquidEntityModel
import dev.hybridlabs.aquatic.entity.cephalopod.HybridAquaticCephalopodEntity
import net.minecraft.client.render.entity.EntityRendererFactory.Context

class VampireSquidEntityRenderer(context: Context) : HybridAquaticCephalopodEntityRenderer<HybridAquaticCephalopodEntity>(context, VampireSquidEntityModel(), true, true)