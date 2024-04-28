package dev.hybridlabs.aquatic.world.tree

import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticConfiguredFeatures
import net.minecraft.block.sapling.SaplingGenerator
import net.minecraft.registry.RegistryKey
import net.minecraft.world.gen.feature.ConfiguredFeature

class CoconutPalmSaplingGenerator : SaplingGenerator() {
    override fun getTreeFeature(
        random: net.minecraft.util.math.random.Random,
        bees: Boolean
    ): RegistryKey<ConfiguredFeature<*, *>> {
        return HybridAquaticConfiguredFeatures.COCONUT_PALM
    }
}