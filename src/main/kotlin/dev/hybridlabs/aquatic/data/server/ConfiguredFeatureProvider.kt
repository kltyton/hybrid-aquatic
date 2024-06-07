@file:Suppress("UnstableApiUsage")

package dev.hybridlabs.aquatic.data.server

import dev.hybridlabs.aquatic.block.HybridAquaticBlocks
import dev.hybridlabs.aquatic.tag.HybridAquaticBlockTags
import dev.hybridlabs.aquatic.world.gen.feature.*
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.registry.RegistryWrapper
import net.minecraft.state.property.Properties
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler.NoiseParameters
import net.minecraft.world.gen.blockpredicate.BlockPredicate
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize
import net.minecraft.world.gen.foliage.JungleFoliagePlacer
import net.minecraft.world.gen.stateprovider.BlockStateProvider
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider
import net.minecraft.world.gen.trunk.StraightTrunkPlacer
import java.util.concurrent.CompletableFuture

class ConfiguredFeatureProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: RegistryWrapper.WrapperLookup, entries: Entries) {
        // anemone patch
        entries.add(
            HybridAquaticConfiguredFeatures.ANEMONE_PATCH,
            ConfiguredFeature(
                Feature.NO_BONEMEAL_FLOWER, RandomPatchFeatureConfig(
                    2, 2, 2,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            BlockStateProvider.of(HybridAquaticBlocks.ANEMONE.defaultState.with(Properties.WATERLOGGED, true))
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.ANEMONES_GENERATE_IN)
                    )
                )
            )
        )

        entries.add(
            HybridAquaticConfiguredFeatures.COCONUT_PALM,
            ConfiguredFeature(
                Feature.TREE,
                TreeFeatureConfig.Builder(
                    BlockStateProvider.of(HybridAquaticBlocks.COCONUT_PALM_LOG),
                    StraightTrunkPlacer(5, 4, 3),
                    BlockStateProvider.of(HybridAquaticBlocks.COCONUT_PALM_LEAVES),
                    JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                    TwoLayersFeatureSize(1,0,2)
                )
                    .dirtProvider(BlockStateProvider.of(Blocks.SAND))
                    .build()
            )
        )


        // tube sponge patch
        entries.add(
            HybridAquaticConfiguredFeatures.TUBE_SPONGE_PATCH,
            ConfiguredFeature(
                Feature.FLOWER,
                RandomPatchFeatureConfig(
                    4, 2, 2,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            BlockStateProvider.of(HybridAquaticBlocks.TUBE_SPONGE.defaultState.with(Properties.WATERLOGGED, true))
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.TUBE_SPONGE_GENERATE_IN)
                    )
                )
            )
        )

        // giant clam patch
        entries.add(
            HybridAquaticConfiguredFeatures.GIANT_CLAM_PATCH,
            ConfiguredFeature(
                Feature.NO_BONEMEAL_FLOWER, RandomPatchFeatureConfig(
                    2, 2, 2,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            BlockStateProvider.of(HybridAquaticBlocks.GIANT_CLAM.defaultState.with(Properties.WATERLOGGED, true))
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.GIANT_CLAM_GENERATE_IN)
                    )
                )
            )
        )

        // message in a bottle
        entries.add(
            HybridAquaticConfiguredFeatures.MESSAGE_IN_A_BOTTLE,
            ConfiguredFeature(
                HybridAquaticFeatures.MESSAGE_IN_A_BOTTLE, MessageInABottleFeatureConfig(
                    SimpleBlockStateProvider.of(HybridAquaticBlocks.MESSAGE_IN_A_BOTTLE)
                )
            )
        )

        // thermal vents
        entries.add(
            HybridAquaticConfiguredFeatures.THERMAL_VENT,
            ConfiguredFeature(
                HybridAquaticFeatures.THERMAL_VENT, ThermalVentFeatureConfig(
                    5,
                    1,
                    0.5F
                )
            )
        )

        // sargassum
        entries.add(
            HybridAquaticConfiguredFeatures.SARGASSUM,
            ConfiguredFeature(
                HybridAquaticFeatures.SARGASSUM, SargassumFeatureConfig(
                    SimpleBlockStateProvider.of(HybridAquaticBlocks.SARGASSUM)
                )
            )
        )

        // dense sargassum
        entries.add(
            HybridAquaticConfiguredFeatures.DENSE_SARGASSUM,
            ConfiguredFeature(
                HybridAquaticFeatures.DENSE_SARGASSUM, DenseSargassumFeatureConfig(
                    SimpleBlockStateProvider.of(HybridAquaticBlocks.SARGASSUM)
                )
            )
        )

        // floating sargassum
        entries.add(
            HybridAquaticConfiguredFeatures.FLOATING_SARGASSUM,
            ConfiguredFeature(
                Feature.RANDOM_PATCH, RandomPatchFeatureConfig(
                    500, 10, 10,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            BlockStateProvider.of(HybridAquaticBlocks.FLOATING_SARGASSUM.defaultState.with(Properties.WATERLOGGED, true))
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.FLOATING_SARGASSUM_GENERATE_IN)
                    )
                )
            )
        )

        // red algae
        entries.add(
            HybridAquaticConfiguredFeatures.RED_ALGAE,
            ConfiguredFeature(
                Feature.RANDOM_PATCH, RandomPatchFeatureConfig(
                    5, 3, 3,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            BlockStateProvider.of(HybridAquaticBlocks.SHORT_RED_ALGAE.defaultState)
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.RED_ALGAE_GENERATE_IN)
                    )
                )
            )
        )

        // red algae meadow
        entries.add(
            HybridAquaticConfiguredFeatures.RED_ALGAE_MEADOW,
            ConfiguredFeature(
                Feature.RANDOM_PATCH, RandomPatchFeatureConfig(
                    500, 10, 10,
                    PlacedFeatures.createEntry(
                        Feature.SIMPLE_BLOCK,
                        SimpleBlockFeatureConfig(
                            NoiseBlockStateProvider(
                                237L,
                                NoiseParameters(-4, 1.0, *DoubleArray(0)),
                                1.0f ,
                                listOf<BlockState>(
                                    HybridAquaticBlocks.SHORT_RED_ALGAE.defaultState,
                                    HybridAquaticBlocks.RED_ALGAE.defaultState,
                                    HybridAquaticBlocks.TALL_RED_ALGAE.defaultState
                                )
                            )
                        ),
                        BlockPredicate.matchingBlockTag(HybridAquaticBlockTags.RED_ALGAE_GENERATE_IN)
                    )
                )
            )
        )

        // dense kelp warm
        entries.add(
            HybridAquaticConfiguredFeatures.DENSE_KELP_WARM,
            ConfiguredFeature(
                HybridAquaticFeatures.DENSE_KELP_WARM, DenseKelpWarmFeatureConfig(
                    SimpleBlockStateProvider.of(HybridAquaticBlocks.DENSE_KELP)
                )
            )
        )

        // dense kelp cold
        entries.add(
            HybridAquaticConfiguredFeatures.DENSE_KELP_COLD,
            ConfiguredFeature(
                HybridAquaticFeatures.DENSE_KELP_COLD, DenseKelpColdFeatureConfig(
                    SimpleBlockStateProvider.of(HybridAquaticBlocks.DENSE_KELP)
                )
            )
        )
    }

    override fun getName(): String {
        return "Configured Features"
    }
}
