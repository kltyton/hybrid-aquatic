package dev.hybridlabs.aquatic.data.server.tag

import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BiomeTags
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeKeys
import java.util.concurrent.CompletableFuture

class BiomeTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider<Biome>(output, RegistryKeys.BIOME, registriesFuture) {
    override fun configure(arg: RegistryWrapper.WrapperLookup?) {
        // spawn biomes
        getOrCreateTagBuilder(HybridAquaticBiomeTags.ANGLERFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BARRELEYE_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

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

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BLUE_SPOTTED_STINGRAY_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SURGEONFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BULL_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CLOWNFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COWFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DUNGENESS_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HERMIT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GHOST_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LIGHTFOOT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            BiomeKeys.STONY_SHORE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FLOWER_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.VAMPIRE_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.BAMBOO_JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.HORSESHOE_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SPIDER_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.YETI_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GIANT_ISOPOD_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SHRIMP_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CRAYFISH_SPAWN_BIOMES).add(
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP,
            BiomeKeys.RIVER,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.LOBSTER_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COCONUT_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.BEACH,
            HybridAquaticBiomes.TROPICAL_BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CUTTLEFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DISCUS_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DRAGONFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.UMBRELLA_OCTOPUS_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FIDDLER_CRAB_SPAWN_BIOMES).add(
            BiomeKeys.MANGROVE_SWAMP,
            BiomeKeys.BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FIREFLY_SQUID_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FLASHLIGHT_FISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FRILLED_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_NETTLE_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GLOWING_SUCKER_OCTOPUS_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GOURAMI_SPAWN_BIOMES).add(
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP,
        )

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

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MAHIMAHI_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MOON_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.TROPICAL_BEACH
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FRIED_EGG_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.CAULIFLOWER_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NOMURA_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ATOLLA_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

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
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COMPASS_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BLUE_JELLYFISH_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MAUVE_STINGER_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.TROPICAL_BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MORAY_EEL_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NAUTILUS_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NEEDLEFISH_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.NUDIBRANCH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OARFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OPAH_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.OSCAR_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.PIRANHA_SPAWN_BIOMES).add(
            BiomeKeys.JUNGLE,
            BiomeKeys.SPARSE_JUNGLE,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.RATFISH_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ROCKFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_ANGEL_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_CUCUMBER_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_PIG_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.REGULAR_SEA_CUCUMBER_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEA_URCHIN_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
            )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SEAHORSE_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.STARFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.KNOBBED_STARFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.BRITTLESTAR_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.COT_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.STONEFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
        )

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

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TIGER_BARB_SPAWN_BIOMES).add(
            BiomeKeys.SWAMP,
            BiomeKeys.MANGROVE_SWAMP,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TIGER_SHARK_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TOADFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.BEACH,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TRIGGERFISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.UNICORN_FISH_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.VAMPIRE_SQUID_SPAWN_BIOMES).add(
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

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
            HybridAquaticBiomes.SARGASSUM_SEA
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

        getOrCreateTagBuilder(HybridAquaticBiomeTags.ANEMONE_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.TUBE_SPONGE_SPAWN_BIOMES).add(
            BiomeKeys.OCEAN,
            BiomeKeys.DEEP_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.WARM_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.GIANT_CLAM_SPAWN_BIOMES).add(
            BiomeKeys.WARM_OCEAN,
            BiomeKeys.LUKEWARM_OCEAN,
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.MESSAGE_IN_A_BOTTLE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)
            .forceAddTag(BiomeTags.IS_BEACH)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.SARGASSUM_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN,
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DENSE_SARGASSUM_SPAWN_BIOMES).add(
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.FLOATING_SARGASSUM_SPAWN_BIOMES).add(
            HybridAquaticBiomes.SARGASSUM_SEA
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.RED_ALGAE_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_OCEAN)

        getOrCreateTagBuilder(HybridAquaticBiomeTags.RED_ALGAE_MEADOW_SPAWN_BIOMES).add(
            HybridAquaticBiomes.RED_MEADOW
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DENSE_KELP_WARM_SPAWN_BIOMES).add(
            BiomeKeys.LUKEWARM_OCEAN,
            BiomeKeys.DEEP_LUKEWARM_OCEAN,
            BiomeKeys.OCEAN
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.DENSE_KELP_COLD_SPAWN_BIOMES).add(
            BiomeKeys.COLD_OCEAN,
            BiomeKeys.DEEP_COLD_OCEAN,
            BiomeKeys.FROZEN_OCEAN,
            BiomeKeys.DEEP_FROZEN_OCEAN,
            BiomeKeys.DEEP_OCEAN,
        )

        getOrCreateTagBuilder(HybridAquaticBiomeTags.THERMAL_VENT_SPAWN_BIOMES)
            .forceAddTag(BiomeTags.IS_DEEP_OCEAN)

        getOrCreateTagBuilder(BiomeTags.IS_OCEAN).add(
            HybridAquaticBiomes.RED_MEADOW,
            HybridAquaticBiomes.SARGASSUM_SEA,
        )

        getOrCreateTagBuilder(BiomeTags.IS_BEACH).add(
            HybridAquaticBiomes.TROPICAL_BEACH,
        )

        getOrCreateTagBuilder(BiomeTags.SHIPWRECK_HAS_STRUCTURE).add(
            HybridAquaticBiomes.RED_MEADOW,
            HybridAquaticBiomes.SARGASSUM_SEA,
        )

        getOrCreateTagBuilder(BiomeTags.OCEAN_RUIN_WARM_HAS_STRUCTURE).add(
            HybridAquaticBiomes.RED_MEADOW,
            HybridAquaticBiomes.SARGASSUM_SEA,
        )

        getOrCreateTagBuilder(BiomeTags.RUINED_PORTAL_OCEAN_HAS_STRUCTURE).add(
            HybridAquaticBiomes.RED_MEADOW,
            HybridAquaticBiomes.SARGASSUM_SEA,
        )

        getOrCreateTagBuilder(BiomeTags.PLAYS_UNDERWATER_MUSIC).add(
            HybridAquaticBiomes.RED_MEADOW,
            HybridAquaticBiomes.SARGASSUM_SEA,
        )
    }
}
