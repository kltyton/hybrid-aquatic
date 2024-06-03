package dev.hybridlabs.aquatic.world.biome

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.client.sound.MusicType
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BiomeMoodSound
import net.minecraft.sound.SoundEvents.MUSIC_UNDER_WATER
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.biome.SpawnSettings.SpawnEntry
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.carver.ConfiguredCarver
import net.minecraft.world.gen.feature.DefaultBiomeFeatures
import net.minecraft.world.gen.feature.OceanPlacedFeatures
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures

object HybridAquaticBiomes {
    val SARGASSUM_SEA: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "sargassum_sea")
    )

    val RED_MEADOW: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "red_meadow")
    )

    val TROPICAL_BEACH: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "tropical_beach")
    )

    val GLOWING_BEACH: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "glowing_beach")
    )

    val TIDE_POOLS: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "tide_pools")
    )

    fun bootstrap(context: Registerable<Biome>) {
        context.register(SARGASSUM_SEA, sargassumSea(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)))
        context.register(RED_MEADOW, redMeadow(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)))
        context.register(TIDE_POOLS, tidePools(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE), context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)))
    }

    private fun globalOverworldGeneration(builder: GenerationSettings.LookupBackedBuilder) {
        DefaultBiomeFeatures.addLandCarvers(builder)
        DefaultBiomeFeatures.addAmethystGeodes(builder)
        DefaultBiomeFeatures.addDungeons(builder)
        DefaultBiomeFeatures.addMineables(builder)
        DefaultBiomeFeatures.addSprings(builder)
        DefaultBiomeFeatures.addFrozenTopLayer(builder)
    }

    fun sargassumSea(featureRegistry: RegistryEntryLookup<PlacedFeature>,
                     carverRegistry: RegistryEntryLookup<ConfiguredCarver<*>>):
            Biome {
        val spawnBuilder = SpawnSettings.Builder()
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(EntityType.COD, 2, 2, 5))
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(EntityType.SALMON, 2, 2, 5))
        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, SpawnEntry(EntityType.DOLPHIN, 1, 1, 3))

        val biomeBuilder = GenerationSettings.LookupBackedBuilder(featureRegistry, carverRegistry)

        globalOverworldGeneration(biomeBuilder)
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_WARM)

        return Biome.Builder()
            .precipitation(true)
            .downfall(0.5f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects(
                BiomeEffects.Builder()
                    .waterColor(0x98a869)
                    .waterFogColor(0x535c39)
                    .skyColor(0x7BA4FF)
                    .grassColor(0x5bd959)
                    .foliageColor(0x5bd959)
                    .fogColor(0xC0D8FF)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.createIngameMusic(MUSIC_UNDER_WATER)).build()
            )
            .build()
    }

    fun redMeadow(featureRegistry: RegistryEntryLookup<PlacedFeature>,
                     carverRegistry: RegistryEntryLookup<ConfiguredCarver<*>>):
            Biome {
        val spawnBuilder = SpawnSettings.Builder()
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(EntityType.TROPICAL_FISH, 2, 2, 5))
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(EntityType.PUFFERFISH, 1, 1, 2))

        val biomeBuilder = GenerationSettings.LookupBackedBuilder(featureRegistry, carverRegistry)

        globalOverworldGeneration(biomeBuilder)
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEA_PICKLE)

        return Biome.Builder()
            .precipitation(true)
            .downfall(0.5f)
            .temperature(0.6f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects(
                BiomeEffects.Builder()
                    .waterColor(0x00bfff)
                    .waterFogColor(0x1d61ad)
                    .skyColor(0x7BA4FF)
                    .grassColor(0x5bd959)
                    .foliageColor(0x5bd959)
                    .fogColor(0xC0D8FF)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.createIngameMusic(MUSIC_UNDER_WATER)).build()
            )
            .build()
    }

    fun tidePools(featureRegistry: RegistryEntryLookup<PlacedFeature>,
                  carverRegistry: RegistryEntryLookup<ConfiguredCarver<*>>):
            Biome {
        val spawnBuilder = SpawnSettings.Builder()
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(EntityType.TROPICAL_FISH, 2, 1, 3))

        val biomeBuilder = GenerationSettings.LookupBackedBuilder(featureRegistry, carverRegistry)

        globalOverworldGeneration(biomeBuilder)
        biomeBuilder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, UndergroundPlacedFeatures.LUSH_CAVES_CLAY)

        return Biome.Builder()
            .precipitation(true)
            .downfall(0.5f)
            .temperature(0.6f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects(
                BiomeEffects.Builder()
                    .waterColor(0x00bfff)
                    .waterFogColor(0x1d61ad)
                    .skyColor(0x7BA4FF)
                    .grassColor(0x5bd959)
                    .foliageColor(0x5bd959)
                    .fogColor(0xC0D8FF)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.createIngameMusic(MUSIC_UNDER_WATER)).build()
            )
            .build()
    }
}