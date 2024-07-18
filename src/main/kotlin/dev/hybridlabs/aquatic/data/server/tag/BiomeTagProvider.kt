package dev.hybridlabs.aquatic.data.server.tag

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BiomeTags
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeKeys
import java.util.concurrent.CompletableFuture

class BiomeTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider<Biome>(output, RegistryKeys.BIOME, registriesFuture) {
    override fun configure(arg: RegistryWrapper.WrapperLookup?) {
        // spawn biomes

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DUNGENESS_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HERMIT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )
            .addOptional(Identifier("wythers", "tropical_beach"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GHOST_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )
            .addOptional(Identifier("wythers", "tropical_beach"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LIGHTFOOT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )
            .addOptional(Identifier("wythers", "tropical_beach"))
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FLOWER_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH
        )
            .addOptional(Identifier("wythers", "tropical_beach"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COCONUT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.BEACH,
        )
            .addOptional(Identifier("wythers", "tropical_beach"))
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FIDDLER_CRAB_SPAWN_BIOMES)
            .add(
                BiomeKeys.MANGROVE_SWAMP,
                BiomeKeys.BEACH,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ROCKFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MESSAGE_IN_A_BOTTLE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_BEACH)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OCEAN)
            .add(BiomeKeys.OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DEEP_OCEAN)
            .add(BiomeKeys.DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ALL_DEEP_OCEANS)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ALL_OCEANS)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COLD_OCEANS)
            .add(BiomeKeys.COLD_OCEAN,
                BiomeKeys.FROZEN_OCEAN)

            getOrCreateTagBuilder(HybridAquaticBiomeTags.DEEP_COLD_OCEANS)
            .add(BiomeKeys.DEEP_COLD_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ALL_COLD_OCEANS)
            .add(BiomeKeys.COLD_OCEAN,
                BiomeKeys.FROZEN_OCEAN,
                BiomeKeys.DEEP_COLD_OCEAN,
                BiomeKeys.DEEP_FROZEN_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.WARM_OCEANS)
            .add(BiomeKeys.WARM_OCEAN,
                BiomeKeys.LUKEWARM_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DEEP_WARM_OCEANS)
            .add(BiomeKeys.DEEP_LUKEWARM_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ALL_WARM_OCEANS)
            .add(BiomeKeys.WARM_OCEAN,
                BiomeKeys.LUKEWARM_OCEAN,
                BiomeKeys.DEEP_LUKEWARM_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.REEF)
            .add(BiomeKeys.WARM_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TROPICAL_FRESHWATER)
            .forceAddTag(BiomeTags.IS_JUNGLE)
            .add(BiomeKeys.JUNGLE,
                BiomeKeys.BAMBOO_JUNGLE,
                BiomeKeys.SPARSE_JUNGLE)
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))
            .addOptional(Identifier("regions_unexplored", "muddy_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SWAMPLAND)
            .forceAddTag(BiomeTags.SWAMP_HUT_HAS_STRUCTURE)
            .add(BiomeKeys.SWAMP,
                BiomeKeys.MANGROVE_SWAMP)
            .addOptional(Identifier("wythers", "waterlily_swamp"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "marsh"))
            .addOptional(Identifier("regions_unexplored", "muddy_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.RIVERS)
            .forceAddTag(BiomeTags.IS_RIVER)
            .add(BiomeKeys.RIVER)
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))
            .addOptional(Identifier("regions_unexplored", "muddy_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CHERRY)
            .add(
                BiomeKeys.CHERRY_GROVE,
            )
            .addOptional(Identifier("regions_unexplored", "mauve_hills"))
            .addOptional(Identifier("regions_unexplored", "magnolia_woodland"))
    }
}
