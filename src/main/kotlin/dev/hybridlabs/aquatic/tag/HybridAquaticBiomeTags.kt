package dev.hybridlabs.aquatic.tag

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome

object HybridAquaticBiomeTags {
    val CLOWNFISH_SPAWN_BIOMES = create("clownfish_spawn_biomes")

    val TUNA_SPAWN_BIOMES = create("tuna_spawn_biomes")
    val YELLOWFIN_SPAWN_BIOMES = create("yellowfin_spawn_biomes")
    val BLUEFIN_SPAWN_BIOMES = create("bluefin_spawn_biomes")
    val BLACKFIN_SPAWN_BIOMES = create("blackfin_spawn_biomes")

    val MAHIMAHI_SPAWN_BIOMES = create("mahimahi_spawn_biomes")

    val SUNFISH_SPAWN_BIOMES = create("sunfish_spawn_biomes")
    val OCEAN_SUNFISH_SPAWN_BIOMES = create("ocean_sunfish_spawn_biomes")
    val SHARPTAIL_SUNFISH_SPAWN_BIOMES = create("sharptail_sunfish_spawn_biomes")
    val HOODWINKER_SUNFISH_SPAWN_BIOMES = create("hoodwinker_sunfish_spawn_biomes")
    val GIANT_SUNFISH_SPAWN_BIOMES = create("giant_sunfish_spawn_biomes")

    val SURGEONFISH_SPAWN_BIOMES = create("surgeonfish_spawn_biomes")
    val COWFISH_SPAWN_BIOMES = create("cowfish_spawn_biomes")
    val SEAHORSE_SPAWN_BIOMES = create("seahorse_spawn_biomes")

    val GOLDFISH_SPAWN_BIOMES = create("goldfish_spawn_biomes")
    val KOI_SPAWN_BIOMES = create("koi_spawn_biomes")

    val STINGRAY_SPAWN_BIOMES = create("stingray_spawn_biomes")
    val MANTA_RAY_SPAWN_BIOMES = create("manta_ray_spawn_biomes")

    val LIONFISH_SPAWN_BIOMES = create("lionfish_spawn_biomes")
    val MOON_JELLYFISH_SPAWN_BIOMES = create("moon_jellyfish_spawn_biomes")
    val FRIED_EGG_JELLYFISH_SPAWN_BIOMES = create("fried_egg_jellyfish_spawn_biomes")
    val CAULIFLOWER_JELLYFISH_SPAWN_BIOMES = create("cauliflower_jellyfish_spawn_biomes")
    val NOMURA_JELLYFISH_SPAWN_BIOMES = create("nomura_jellyfish_spawn_biomes")
    val BARREL_JELLYFISH_SPAWN_BIOMES = create("barrel_jellyfish_spawn_biomes")
    val COMPASS_JELLYFISH_SPAWN_BIOMES = create("compass_jellyfish_spawn_biomes")
    val BLUE_JELLYFISH_SPAWN_BIOMES = create("blue_jellyfish_spawn_biomes")
    val ATOLLA_JELLYFISH_SPAWN_BIOMES = create("atolla_jellyfish_spawn_biomes")
    val LIONS_MANE_JELLYFISH_SPAWN_BIOMES = create("lions_mane_jellyfish_spawn_biomes")
    val MAUVE_STINGER_SPAWN_BIOMES = create("mauve_stinger_spawn_biomes")
    val OARFISH_SPAWN_BIOMES = create("oarfish_spawn_biomes")
    val ANGLERFISH_SPAWN_BIOMES = create("anglerfish_spawn_biomes")
    val TOADFISH_SPAWN_BIOMES = create("toadfish_spawn_biomes")
    val STONEFISH_SPAWN_BIOMES = create("stonefish_spawn_biomes")
    val SEA_ANGEL_SPAWN_BIOMES = create("sea_angel_spawn_biomes")
    val DRAGONFISH_SPAWN_BIOMES = create("dragonfish_spawn_biomes")
    val UMBRELLA_OCTOPUS_SPAWN_BIOMES = create("umbrella_octopus_spawn_biomes")
    val UNICORN_FISH_SPAWN_BIOMES = create("unicorn_fish_spawn_biomes")
    val ROCKFISH_SPAWN_BIOMES = create("rockfish_spawn_biomes")
    val MORAY_EEL_SPAWN_BIOMES = create("moray_eel_spawn_biomes")
    val OPAH_SPAWN_BIOMES = create("opah_spawn_biomes")
    val VAMPIRE_SQUID_SPAWN_BIOMES = create("vampire_squid_spawn_biomes")
    val FLASHLIGHT_FISH_SPAWN_BIOMES = create("flashlight_fish_spawn_biomes")
    val FIREFLY_SQUID_SPAWN_BIOMES = create("firefly_squid_spawn_biomes")
    val CUTTLEFISH_SPAWN_BIOMES = create("cuttlefish_spawn_biomes")
    val GLOWING_SUCKER_OCTOPUS_SPAWN_BIOMES = create("glowing_sucker_octopus_spawn_biomes")
    val TRIGGERFISH_SPAWN_BIOMES = create("triggerfish_spawn_biomes")
    val TIGER_BARB_SPAWN_BIOMES = create("tiger_barb_spawn_biomes")
    val OSCAR_SPAWN_BIOMES = create("oscar_spawn_biomes")
    val DANIO_SPAWN_BIOMES = create("danio_spawn_biomes")
    val GOURAMI_SPAWN_BIOMES = create("gourami_spawn_biomes")
    val BARRELEYE_SPAWN_BIOMES = create("barreleye_spawn_biomes")
    val PIRANHA_SPAWN_BIOMES = create("piranha_spawn_biomes")
    val RATFISH_SPAWN_BIOMES = create("ratfish_spawn_biomes")
    val DISCUS_SPAWN_BIOMES = create("discus_spawn_biomes")
    val TETRA_SPAWN_BIOMES = create("tetra_spawn_biomes")
    val NAUTILUS_SPAWN_BIOMES = create("nautilus_spawn_biomes")
    val BETTA_SPAWN_BIOMES = create("betta_spawn_biomes")
    val NEEDLEFISH_SPAWN_BIOMES = create("needlefish_spawn_biomes")
    val GREAT_WHITE_SHARK_SPAWN_BIOMES = create("great_white_shark_spawn_biomes")
    val TIGER_SHARK_SPAWN_BIOMES = create("tiger_shark_spawn_biomes")
    val HAMMERHEAD_SHARK_SPAWN_BIOMES = create("hammerhead_shark_spawn_biomes")
    val FRILLED_SHARK_SPAWN_BIOMES = create("frilled_shark_spawn_biomes")
    val THRESHER_SHARK_SPAWN_BIOMES = create("thresher_shark_spawn_biomes")
    val BULL_SHARK_SPAWN_BIOMES = create("bull_shark_spawn_biomes")
    val WHALE_SHARK_SPAWN_BIOMES = create("whale_shark_spawn_biomes")
    val BASKING_SHARK_SPAWN_BIOMES = create("basking_shark_spawn_biomes")
    val DUNGENESS_CRAB_SPAWN_BIOMES = create("dungeness_crab_spawn_biomes")
    val HERMIT_CRAB_SPAWN_BIOMES = create("hermit_crab_spawn_biomes")
    val FIDDLER_CRAB_SPAWN_BIOMES = create("fiddler_crab_spawn_biomes")
    val GHOST_CRAB_SPAWN_BIOMES = create("ghost_crab_spawn_biomes")
    val LIGHTFOOT_CRAB_SPAWN_BIOMES = create("lightfoot_crab_spawn_biomes")
    val FLOWER_CRAB_SPAWN_BIOMES = create("flower_crab_spawn_biomes")
    val VAMPIRE_CRAB_SPAWN_BIOMES = create("vampire_crab_spawn_biomes")
    val HORSESHOE_CRAB_SPAWN_BIOMES = create("horseshoe_crab_spawn_biomes")
    val SPIDER_CRAB_SPAWN_BIOMES = create("spider_crab_spawn_biomes")
    val YETI_CRAB_SPAWN_BIOMES = create("yeti_crab_spawn_biomes")
    val GIANT_ISOPOD_SPAWN_BIOMES = create("giant_isopod_spawn_biomes")
    val SHRIMP_SPAWN_BIOMES = create("shrimp_spawn_biomes")
    val CRAYFISH_SPAWN_BIOMES = create("crayfish_spawn_biomes")
    val LOBSTER_SPAWN_BIOMES = create("lobster_spawn_biomes")
    val COCONUT_CRAB_SPAWN_BIOMES = create("coconut_crab_spawn_biomes")

    val STARFISH_SPAWN_BIOMES = create("starfish_spawn_biomes")
    val KNOBBED_STARFISH_SPAWN_BIOMES = create("knobbed_starfish_spawn_biomes")
    val BRITTLESTAR_SPAWN_BIOMES = create("brittlestar_spawn_biomes")
    val COT_SPAWN_BIOMES = create("cot_spawn_biomes")

    val SEA_CUCUMBER_SPAWN_BIOMES = create("sea_cucumber_spawn_biomes")
    val SEA_PIG_SPAWN_BIOMES = create("sea_pig_spawn_biomes")
    val REGULAR_SEA_CUCUMBER_SPAWN_BIOMES = create("regular_sea_cucumber_spawn_biomes")

    val NUDIBRANCH_SPAWN_BIOMES = create("nudibranch_spawn_biomes")
    val SEA_URCHIN_SPAWN_BIOMES = create("sea_urchin_spawn_biomes")
    val SEA_NETTLE_SPAWN_BIOMES = create("sea_nettle_spawn_biomes")

    val ANEMONE_SPAWN_BIOMES = create("anemone_spawn_biomes")
    val TUBE_SPONGE_SPAWN_BIOMES = create("tube_sponge_spawn_biomes")
    val MESSAGE_IN_A_BOTTLE_SPAWN_BIOMES = create("message_in_a_bottle_spawn_biomes")
    val HYDROTHERMAL_VENT_SPAWN_BIOMES = create("thermal_vent_spawn_biomes")
    val GIANT_CLAM_SPAWN_BIOMES = create("giant_clam_spawn_biomes")

    private fun create(id: String): TagKey<Biome> {
        return TagKey.of(RegistryKeys.BIOME, Identifier(HybridAquatic.MOD_ID, id))
    }
}
