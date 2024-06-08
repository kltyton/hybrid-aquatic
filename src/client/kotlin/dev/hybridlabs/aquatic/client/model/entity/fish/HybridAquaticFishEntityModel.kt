package dev.hybridlabs.aquatic.client.model.entity.fish

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.entity.fish.HybridAquaticFishEntity
import dev.hybridlabs.aquatic.entity.fish.HybridAquaticFishEntity.FishVariant.Ignore.*
import net.minecraft.util.Identifier
import software.bernie.geckolib.model.GeoModel

abstract class HybridAquaticFishEntityModel<T: HybridAquaticFishEntity> (private val id: String) : GeoModel<T>() {
    override fun getModelResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(MODEL))
            return Identifier(HybridAquatic.MOD_ID, "geo/${id}_${variant.variantName}.geo.json")
        return Identifier(HybridAquatic.MOD_ID, "geo/$id.geo.json")
    }

    override fun getTextureResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(TEXTURE))
            return Identifier(HybridAquatic.MOD_ID, "textures/entity/${id}_${variant.variantName}.png")
        return Identifier(HybridAquatic.MOD_ID, "textures/entity/$id.png")
    }

    override fun getAnimationResource(animatable: T?): Identifier {
        val variant = animatable?.variant
        if (variant != null && !variant.ignore.contains(ANIMATION))
            return Identifier(HybridAquatic.MOD_ID, "animations/${id}_${variant.variantName}.animation.json")
        return Identifier(HybridAquatic.MOD_ID, "animations/$id.animation.json")
    }
}