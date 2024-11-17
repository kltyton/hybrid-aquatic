package dev.hybridlabs.aquatic.client.model.entity.fish

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.entity.fish.FlashlightFishEntity
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

class FlashlightFishEntityModel : HybridAquaticFishEntityModel<FlashlightFishEntity>("flashlight_fish") {

    private val onTextureFuture: CompletableFuture<Identifier> = CompletableFuture.supplyAsync {
        Identifier(HybridAquatic.MOD_ID, "textures/entity/fish/flashlight_fish/flashlight_fish.png")
    }

    private val offTextureFuture: CompletableFuture<Identifier> = CompletableFuture.supplyAsync {
        Identifier(HybridAquatic.MOD_ID, "textures/entity/fish/flashlight_fish/flashlight_fish_off.png")
    }

    override fun getTextureResource(animatable: FlashlightFishEntity?): Identifier {
        val isLightOn = animatable?.isLightOn ?: true

        return if (isLightOn) {
            onTextureFuture.get()
        } else {
            offTextureFuture.get()
        }
    }
}
