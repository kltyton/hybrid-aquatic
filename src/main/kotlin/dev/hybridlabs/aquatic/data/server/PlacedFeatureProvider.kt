@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.aquatic.data.server

import dev.hybridlabs.aquatic.block.HybridAquaticBlocks
import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticConfiguredFeatures
import dev.hybridlabs.aquatic.world.gen.feature.HybridAquaticPlacedFeatures
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier
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
                    PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                    CountPlacementModifier.of(100),
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
                    CountPlacementModifier.of(20),
                    BiomePlacementModifier.of()
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
                    CountPlacementModifier.of(25),
                    BiomePlacementModifier.of()
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
                    CountPlacementModifier.of(50),
                    BiomePlacementModifier.of()
                )
            )
        )
    }

    override fun getName(): String {
        return "Placed Features"
    }
}
