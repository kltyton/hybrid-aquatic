package dev.hybridlabs.aquatic.world

import dev.hybridlabs.aquatic.entity.HybridAquaticEntityTypes
import dev.hybridlabs.aquatic.tag.HybridAquaticBiomeTags
import dev.hybridlabs.aquatic.utils.HybridAquaticSpawnGroup
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.tag.TagKey
import net.minecraft.world.biome.Biome

/**
 * Applies biome modifications for entities when initialised.
 */
object EntityBiomeModifications {
    init {
        // fish
        addFish(HybridAquaticEntityTypes.AFRICAN_BUTTERFLY, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.MARSHES), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.TETRA, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.MARSHES, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 2, 3)
        addFish(HybridAquaticEntityTypes.TIGER_BARB, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.SWAMP,  HybridAquaticBiomeTags.MARSHES, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 2, 3)
        addFish(HybridAquaticEntityTypes.GOURAMI, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.MARSHES, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.DISCUS, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.PIRANHA, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.TROPICAL_RIVERS), 5, 2, 5)
        addFish(HybridAquaticEntityTypes.OSCAR, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.TROPICAL_RIVERS), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.DANIO, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.MARSHES, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 2, 3)
        addFish(HybridAquaticEntityTypes.BETTA, listOf(HybridAquaticBiomeTags.SWAMP, HybridAquaticBiomeTags.MARSHES), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.GOLDFISH, listOf(HybridAquaticBiomeTags.CHERRY), 1, 1, 2)
        addFish(HybridAquaticEntityTypes.CARP, listOf(HybridAquaticBiomeTags.CHERRY, HybridAquaticBiomeTags.RIVERS), 1, 1, 2)
        addFish(HybridAquaticEntityTypes.MANTA_RAY, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.FLASHLIGHT_FISH, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 5, 1, 5)
        addFish(HybridAquaticEntityTypes.MAHI, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 3)
        addFish(HybridAquaticEntityTypes.NEEDLEFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 3)
        addFish(HybridAquaticEntityTypes.MACKEREL, listOf(HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS), 5, 3, 5)
        addFish(HybridAquaticEntityTypes.OPAH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.OARFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.ROCKFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 3)
        addFish(HybridAquaticEntityTypes.SEA_BASS, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 3)
        addFish(HybridAquaticEntityTypes.SEAHORSE, listOf(HybridAquaticBiomeTags.REEF), 1, 1, 2)
        addFish(HybridAquaticEntityTypes.LIONFISH, listOf(HybridAquaticBiomeTags.REEF), 3, 1, 2)
        addFish(HybridAquaticEntityTypes.STONEFISH, listOf(HybridAquaticBiomeTags.REEF), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.STINGRAY, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 3, 1, 2)
        addFish(HybridAquaticEntityTypes.TOADFISH, listOf(HybridAquaticBiomeTags.REEF), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.SURGEONFISH, listOf(HybridAquaticBiomeTags.REEF), 5, 1, 3)
        addFish(HybridAquaticEntityTypes.CLOWNFISH, listOf(HybridAquaticBiomeTags.REEF), 5, 1, 2)
        addFish(HybridAquaticEntityTypes.COWFISH, listOf(HybridAquaticBiomeTags.REEF), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.TRIGGERFISH, listOf(HybridAquaticBiomeTags.REEF), 3, 1, 1)
        addFish(HybridAquaticEntityTypes.PARROTFISH, listOf(HybridAquaticBiomeTags.REEF), 5, 1, 2)
        addFish(HybridAquaticEntityTypes.MORAY_EEL, listOf(HybridAquaticBiomeTags.REEF), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.SUNFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 1)
        addFish(HybridAquaticEntityTypes.TUNA, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 5, 1, 3)


        // underground fishes
        addUndergroundFish(HybridAquaticEntityTypes.ANGLERFISH, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 5, 1, 2)
        addUndergroundFish(HybridAquaticEntityTypes.BARRELEYE, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addUndergroundFish(HybridAquaticEntityTypes.DRAGONFISH, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 5, 1, 1)
        addUndergroundFish(HybridAquaticEntityTypes.FRILLED_SHARK, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addUndergroundFish(HybridAquaticEntityTypes.RATFISH, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 5, 1, 2)
        addUndergroundFish(HybridAquaticEntityTypes.SEA_ANGEL, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS), 3, 1, 1)

        // cephalopods
        addCephalopod(HybridAquaticEntityTypes.FIREFLY_SQUID, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)
        addCephalopod(HybridAquaticEntityTypes.CUTTLEFISH, listOf(HybridAquaticBiomeTags.REEF), 3, 1, 1)

        // underground cephalopods
        addUndergroundCephalopod(HybridAquaticEntityTypes.VAMPIRE_SQUID, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addUndergroundCephalopod(HybridAquaticEntityTypes.NAUTILUS, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addUndergroundCephalopod(HybridAquaticEntityTypes.UMBRELLA_OCTOPUS, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 1)
        addUndergroundCephalopod(HybridAquaticEntityTypes.GLOWING_SUCKER_OCTOPUS, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)

        // jellies
        addJelly(HybridAquaticEntityTypes.BARREL_JELLYFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addJelly(HybridAquaticEntityTypes.MOON_JELLYFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 5, 1, 2)
        addJelly(HybridAquaticEntityTypes.MAUVE_STINGER, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.FRIED_EGG_JELLYFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.CAULIFLOWER_JELLYFISH, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.COMPASS_JELLYFISH, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.BLUE_JELLYFISH, listOf(HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.SEA_NETTLE, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)
        addJelly(HybridAquaticEntityTypes.NOMURA_JELLYFISH, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS), 1, 1, 1)
        addJelly(HybridAquaticEntityTypes.LIONS_MANE_JELLYFISH, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS), 1, 1, 1)

        // underground jellies
        addUndergroundJelly(HybridAquaticEntityTypes.ATOLLA_JELLYFISH, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 2)

        // sharks
        addShark(HybridAquaticEntityTypes.GREAT_WHITE_SHARK, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addShark(HybridAquaticEntityTypes.TIGER_SHARK, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)
        addShark(HybridAquaticEntityTypes.HAMMERHEAD_SHARK, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 5, 1, 2)
        addShark(HybridAquaticEntityTypes.THRESHER_SHARK, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addShark(HybridAquaticEntityTypes.BULL_SHARK, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)
        addShark(HybridAquaticEntityTypes.WHALE_SHARK, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 1)
        addShark(HybridAquaticEntityTypes.BASKING_SHARK, listOf(HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS), 1, 1, 1)

        // crustaceans
        addCrustacean(HybridAquaticEntityTypes.DUNGENESS_CRAB, listOf(HybridAquaticBiomeTags.SANDY_BEACHES), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.FIDDLER_CRAB, listOf(HybridAquaticBiomeTags.SWAMP, HybridAquaticBiomeTags.MANGROVES, HybridAquaticBiomeTags.MARSHES), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.GHOST_CRAB, listOf(HybridAquaticBiomeTags.SANDY_BEACHES), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.HORSESHOE_CRAB, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS), 1, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.LIGHTFOOT_CRAB, listOf(HybridAquaticBiomeTags.ROCKY_BEACHES), 3, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.FLOWER_CRAB, listOf(HybridAquaticBiomeTags.REEF, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.MANGROVES, HybridAquaticBiomeTags.MARSHES), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.VAMPIRE_CRAB, listOf(HybridAquaticBiomeTags.JUNGLE, HybridAquaticBiomeTags.TROPICAL_RIVERS), 3, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.SHRIMP, listOf(HybridAquaticBiomeTags.REEF), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.LOBSTER, listOf(HybridAquaticBiomeTags.REEF,  HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 1)
        addCrustacean(HybridAquaticEntityTypes.DECORATOR_CRAB, listOf(HybridAquaticBiomeTags.REEF), 3, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.CRAYFISH, listOf(HybridAquaticBiomeTags.RIVERS), 5, 1, 2)
        addCrustacean(HybridAquaticEntityTypes.COCONUT_CRAB, listOf(HybridAquaticBiomeTags.SANDY_BEACHES), 3, 1, 1)
        addCrustacean(HybridAquaticEntityTypes.HERMIT_CRAB, listOf(HybridAquaticBiomeTags.SANDY_BEACHES, HybridAquaticBiomeTags.TROPICAL_OCEANS), 3, 1, 2)

        //underground crustaceans
        addUndergroundCrustacean(HybridAquaticEntityTypes.YETI_CRAB, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS), 2, 2, 2)
        addUndergroundCrustacean(HybridAquaticEntityTypes.GIANT_ISOPOD, listOf(HybridAquaticBiomeTags.COLD_OCEANS), 1, 1, 1)
        addUndergroundCrustacean(HybridAquaticEntityTypes.SPIDER_CRAB, listOf(HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS), 3, 1, 2)

        //critters
        addCritter(HybridAquaticEntityTypes.NUDIBRANCH, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 3, 1, 2)
        addCritter(HybridAquaticEntityTypes.STARFISH, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 3, 1, 3)
        addCritter(HybridAquaticEntityTypes.SEA_CUCUMBER, listOf(HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.REEF), 3, 1, 3)
        addCritter(HybridAquaticEntityTypes.SEA_URCHIN, listOf(HybridAquaticBiomeTags.ARCTIC_OCEANS, HybridAquaticBiomeTags.COLD_OCEANS, HybridAquaticBiomeTags.TEMPERATE_OCEANS, HybridAquaticBiomeTags.TROPICAL_OCEANS, HybridAquaticBiomeTags.REEF), 5, 1, 3)
    }

    private fun addFish(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.FISH.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addUndergroundFish(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.FISH_UNDERGROUND.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addCephalopod(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.CEPHALOPOD.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addUndergroundCephalopod(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(
            entityType,
            spawnTags,
            HybridAquaticSpawnGroup.CEPHALOPOD_UNDERGROUND.spawnGroup,
            weight,
            minGroup,
            maxGroup
        )
    }

    private fun addShark(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.SHARK.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addJelly(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.JELLY.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addUndergroundJelly(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.JELLY_UNDERGROUND.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addCrustacean(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.CRUSTACEAN.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun addUndergroundCrustacean(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(
            entityType,
            spawnTags,
            HybridAquaticSpawnGroup.CRUSTACEAN_UNDERGROUND.spawnGroup,
            weight,
            minGroup,
            maxGroup
        )
    }

    private fun addCritter(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        add(entityType, spawnTags, HybridAquaticSpawnGroup.CRITTER.spawnGroup, weight, minGroup, maxGroup)
    }

    private fun add(
        entityType: EntityType<*>,
        spawnTags: List<TagKey<Biome>>,
        spawnGroup: SpawnGroup,
        weight: Int,
        minGroup: Int,
        maxGroup: Int
    ) {
        spawnTags.forEach { spawnTag ->
            BiomeModifications.addSpawn({ it.hasTag(spawnTag) }, spawnGroup, entityType, weight, minGroup, maxGroup)
        }
    }
}