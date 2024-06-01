package dev.hybridlabs.aquatic.world.gen.feature

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.PlacedFeature

/**
 * A registry of placed features for Hybrid Aquatic.
 */
object HybridAquaticPlacedFeatures {

    val ANEMONE_PATCH = register("anemone_patch")

    val GIANT_CLAM_PATCH = register("giant_clam_patch")

    val THERMAL_VENT = register("thermal_vent")

    val TUBE_SPONGE_PATCH = register("sponge_patch")

    val COCONUT_PALM_PLACED = register("coconut_palm_placed")

    val MESSAGE_IN_A_BOTTLE = register("message_in_a_bottle")

    val SARGASSUM = register("sargassum")

    val DENSE_SARGASSUM = register("dense_sargassum")

    val FLOATING_SARGASSUM = register("floating_sargassum")

    val GLOWING_PLANKTON = register("glowing_plankton")

    val DENSE_KELP_WARM = register("dense_kelp_warm")

    val DENSE_KELP_COLD = register("dense_kelp_cold")

    private fun register(id: String): RegistryKey<PlacedFeature> {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier(HybridAquatic.MOD_ID, id))
    }
}