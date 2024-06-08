package dev.hybridlabs.aquatic.client.model.entity.cephalopod

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.entity.cephalopod.HybridAquaticCephalopodEntity
import net.minecraft.util.Identifier
import software.bernie.geckolib.model.GeoModel

abstract class HybridAquaticCephalopodEntityModel<T: HybridAquaticCephalopodEntity> (private val id: String) : GeoModel<T>() {
    override fun getModelResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(HybridAquaticCephalopodEntity.CephalopodVariant.Ignore.MODEL))
            return Identifier(HybridAquatic.MOD_ID, "geo/${id}_${variant.variantName}.geo.json")
        return Identifier(HybridAquatic.MOD_ID, "geo/$id.geo.json")
    }

    override fun getTextureResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(HybridAquaticCephalopodEntity.CephalopodVariant.Ignore.TEXTURE))
            return Identifier(HybridAquatic.MOD_ID, "textures/entity/${id}_${variant.variantName}.png")
        return Identifier(HybridAquatic.MOD_ID, "textures/entity/$id.png")
    }

    override fun getAnimationResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(HybridAquaticCephalopodEntity.CephalopodVariant.Ignore.ANIMATION))
            return Identifier(HybridAquatic.MOD_ID, "animations/${id}_${variant.variantName}.animation.json")
        return Identifier(HybridAquatic.MOD_ID, "animations/$id.animation.json")
    }
}