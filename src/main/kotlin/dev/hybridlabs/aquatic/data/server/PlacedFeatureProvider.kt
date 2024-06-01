@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.aquatic.data.server

import dev.hybridlabs.aquatic.block.HybridAquaticBlocks
import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticConfiguredFeatures
import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.world.Heightmap
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures
import net.minecraft.world.gen.placementmodifier.*
import java.util.concurrent.CompletableFuture

class PlacedFeatureProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: RegistryWrapper.WrapperLookup, entries: Entries) {
        // anemone patch
        entries.add(
            HybridAquaticPlacedFeatures.ANEMONE_PATCH,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.ANEMONE_PATCH),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    CountPlacementModifier.of(1),
                    BiomePlacementModifier.of()
                )
            )
        )

        // giant clam patch
        entries.add(
            HybridAquaticPlacedFeatures.GIANT_CLAM_PATCH,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.GIANT_CLAM_PATCH),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    CountPlacementModifier.of(1),
                    BiomePlacementModifier.of()
                )
            )
        )

        // sponge patch
        entries.add(
            HybridAquaticPlacedFeatures.TUBE_SPONGE_PATCH,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.TUBE_SPONGE_PATCH),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    CountPlacementModifier.of(1),
                    BiomePlacementModifier.of()
                )
            )
        )

        // coconut palms
        entries.add(
            HybridAquaticPlacedFeatures.COCONUT_PALM_PLACED,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.COCONUT_PALM),
            VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1F, 0),
                HybridAquaticBlocks.COCONUT_PALM_SAPLING)
            )
        )

        // message in a bottle
        entries.add(
            HybridAquaticPlacedFeatures.MESSAGE_IN_A_BOTTLE,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.MESSAGE_IN_A_BOTTLE),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                    RarityFilterPlacementModifier.of(150),
                    BiomePlacementModifier.of()
                )
            )
        )

        // thermal vents
        entries.add(
            HybridAquaticPlacedFeatures.THERMAL_VENT,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.THERMAL_VENT),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.BOTTOM_TO_120_RANGE,
                    SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG, Int.MIN_VALUE, -2),
                    CountPlacementModifier.of(1),
                    BiomePlacementModifier.of()
                )
            )
        )

        // sargassum
        entries.add(
            HybridAquaticPlacedFeatures.SARGASSUM,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.SARGASSUM),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(80.0, 80, 0)
                )
            )
        )

        // dense sargassum
        entries.add(
            HybridAquaticPlacedFeatures.DENSE_SARGASSUM,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.DENSE_SARGASSUM),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    CountPlacementModifier.of(1),
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(0.5, 10, 1)
                )
            )
        )

        // floating sargassum
        entries.add(
            HybridAquaticPlacedFeatures.FLOATING_SARGASSUM,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.FLOATING_SARGASSUM),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(0.5, 10, 1)
                )
            )
        )

        // glowing plankton
        entries.add(
            HybridAquaticPlacedFeatures.GLOWING_PLANKTON,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.GLOWING_PLANKTON),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(0.5, 10, 1)
                )
            )
        )

        // dense kelp warm
        entries.add(
            HybridAquaticPlacedFeatures.DENSE_KELP_WARM,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.DENSE_KELP_WARM),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(80.0, 80, 0)
                )
            )
        )

        // dense kelp cold
        entries.add(
            HybridAquaticPlacedFeatures.DENSE_KELP_COLD,
            PlacedFeature(entries.ref(HybridAquaticConfiguredFeatures.DENSE_KELP_COLD),
                listOf(
                    SquarePlacementModifier.of(),
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    BiomePlacementModifier.of(),
                    NoiseThresholdCountPlacementModifier.of(120.0, 80, 0)
                )
            )
        )
    }

    override fun getName(): String {
        return "Placed Features"
    }
}
