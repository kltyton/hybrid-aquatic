package dev.hybridlabs.aquatic.client.model.armor

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.item.DivingArmorItem
import net.minecraft.util.Identifier
import software.bernie.geckolib.model.GeoModel

class DivingArmorModel : GeoModel<DivingArmorItem?>() {
    override fun getModelResource(animatable: DivingArmorItem?): Identifier {
        return Identifier(HybridAquatic.MOD_ID, "geo/diving_armor.geo.json")
    }

    override fun getTextureResource(animatable: DivingArmorItem?): Identifier {
        return Identifier(HybridAquatic.MOD_ID, "textures/armor/diving_armor.png")
    }

    override fun getAnimationResource(animatable: DivingArmorItem?): Identifier {
        return Identifier(HybridAquatic.MOD_ID, "animations/diving_armor.animation.json")
    }
}