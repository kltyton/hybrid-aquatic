package dev.hybridlabs.aquatic.world.gen

import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes
import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticPlacedFeatures
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.biome.BiomeKeys
import net.minecraft.world.gen.GenerationStep

object HybridAquaticTreeGeneration {
    fun generateTrees() {
        BiomeModifications.addFeature(
            BiomeSelectors.includeByKey(HybridAquaticBiomes.TROPICAL_BEACH),
            GenerationStep.Feature.VEGETAL_DECORATION, HybridAquaticPlacedFeatures.COCONUT_PALM_PLACED
        )
    }
}