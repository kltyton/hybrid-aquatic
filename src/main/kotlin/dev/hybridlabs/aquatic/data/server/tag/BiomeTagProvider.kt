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
        getOrCreateTagBuilder(HybridAquaticBiomeTags.ANGLERFISH_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BARRELEYE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BASKING_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BETTA_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
        )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))
            .addOptional(Identifier("regions_unexplored", "marsh"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.STINGRAY_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MANTA_RAY_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.PARROTFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BULL_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CLOWNFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COWFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GOLDFISH_SPAWN_BIOMES)
            .add(BiomeKeys.CHERRY_GROVE,
                )
            .addOptional(Identifier("regions_unexplored", "mauve_hills"))
            .addOptional(Identifier("regions_unexplored", "magnolia_woodland"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.KOI_SPAWN_BIOMES)
            .add(BiomeKeys.CHERRY_GROVE,
                )
            .addOptional(Identifier("regions_unexplored", "mauve_hills"))
            .addOptional(Identifier("regions_unexplored", "magnolia_woodland"))

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

        getOrCreateTagBuilder(HybridAquaticBiomeTags.VAMPIRE_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.BAMBOO_JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP
        )
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("wythers", "waterlily_swamp"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "marsh"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HORSESHOE_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SPIDER_CRAB_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.YETI_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GIANT_ISOPOD_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SHRIMP_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CRAYFISH_SPAWN_BIOMES)
            .add(BiomeKeys.SWAMP)
            .forceAddTag(BiomeTags.IS_RIVER)
            .addOptional(Identifier("wythers", "waterlily_swamp"))
            .addOptional(Identifier("wythers", "gravelly_river"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))
            .addOptional(Identifier("regions_unexplored", "muddy_river"))
            .addOptional(Identifier("regions_unexplored", "marsh"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LOBSTER_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COCONUT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.BEACH,
        )
            .addOptional(Identifier("wythers", "tropical_beach"))
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CUTTLEFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DISCUS_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
        )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DRAGONFISH_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.UMBRELLA_OCTOPUS_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FIDDLER_CRAB_SPAWN_BIOMES)
            .add(
            BiomeKeys.MANGROVE_SWAMP,
            BiomeKeys.BEACH,
                )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FIREFLY_SQUID_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FLASHLIGHT_FISH_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FRILLED_SHARK_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_NETTLE_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GLOWING_SUCKER_OCTOPUS_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GOURAMI_SPAWN_BIOMES).add(
            BiomeKeys.MANGROVE_SWAMP,
        )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GREAT_WHITE_SHARK_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HAMMERHEAD_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LIONFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MAHI_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
        )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MOON_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FRIED_EGG_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CAULIFLOWER_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NOMURA_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ATOLLA_JELLYFISH_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LIONS_MANE_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BARREL_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COMPASS_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BLUE_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MAUVE_STINGER_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MORAY_EEL_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NAUTILUS_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NEEDLEFISH_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OARFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OPAH_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OSCAR_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.PIRANHA_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.BAMBOO_JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))
            .addOptional(Identifier("regions_unexplored", "bamboo_forest"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.RATFISH_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ROCKFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_ANGEL_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "hyacinth_deeps"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_CUCUMBER_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_PIG_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.REGULAR_SEA_CUCUMBER_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEAHORSE_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.STARFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BRITTLESTAR_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COT_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.STONEFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SUNFISH_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OCEAN_SUNFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SHARPTAIL_SUNFISH_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HOODWINKER_SUNFISH_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GIANT_SUNFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.THRESHER_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TIGER_BARB_SPAWN_BIOMES)
            .add(
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP
            )
            .addOptional(Identifier("wythers", "waterlily_swamp"))
            .addOptional(Identifier("terralith", "orchid_swamp"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TIGER_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TOADFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TRIGGERFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.UNICORN_FISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.VAMPIRE_SQUID_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.WHALE_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TUNA_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.YELLOWFIN_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BLUEFIN_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BLACKFIN_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DANIO_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            BiomeKeys.MANGROVE_SWAMP,
        )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TETRA_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            BiomeKeys.MANGROVE_SWAMP,
        )
            .addOptional(Identifier("wythers", "jungle_river"))
            .addOptional(Identifier("wythers", "tropical_forest_river"))
            .addOptional(Identifier("wythers", "flooded_jungle"))
            .addOptional(Identifier("terralith", "warm_river"))
            .addOptional(Identifier("terralith", "orchid_swamp"))
            .addOptional(Identifier("regions_unexplored", "tropical_river"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ANEMONE_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TUBE_SPONGE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GIANT_CLAM_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            )
            .addOptional(Identifier("regions_unexplored", "rocky_reef"))

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MESSAGE_IN_A_BOTTLE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_BEACH)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HYDROTHERMAL_VENT_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
    }
}
