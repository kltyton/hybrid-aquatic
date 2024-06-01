package dev.hybridlabs.aquatic.world.biome

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.entity.HybridAquaticEntityTypes
import net.minecraft.client.sound.MusicType
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registerable
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
import net.minecraft.world.gen.feature.DefaultBiomeFeatures
import net.minecraft.world.gen.feature.OceanPlacedFeatures

object HybridAquaticBiomes {
    val SARGASSUM_SEA: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "sargassum_sea")
    )

    fun bootstrap(context: Registerable<Biome>) {
        context.register(SARGASSUM_SEA, sargassumSea(context))
    }

    fun globalOverworldGeneration(builder: GenerationSettings.LookupBackedBuilder) {
        DefaultBiomeFeatures.addLandCarvers(builder)
        DefaultBiomeFeatures.addAmethystGeodes(builder)
        DefaultBiomeFeatures.addDungeons(builder)
        DefaultBiomeFeatures.addMineables(builder)
        DefaultBiomeFeatures.addSprings(builder)
        DefaultBiomeFeatures.addFrozenTopLayer(builder)
    }

    fun sargassumSea(context: Registerable<Biome>): Biome {
        val spawnBuilder = SpawnSettings.Builder()
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(HybridAquaticEntityTypes.MAHIMAHI, 2, 1, 3))
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(HybridAquaticEntityTypes.YELLOWFIN_TUNA, 2, 1, 3))
        spawnBuilder.spawn(SpawnGroup.WATER_AMBIENT, SpawnEntry(HybridAquaticEntityTypes.TRIGGERFISH, 2, 1, 3))
        spawnBuilder.spawn(SpawnGroup.WATER_CREATURE, SpawnEntry(EntityType.TURTLE, 5, 2, 5))

        val biomeBuilder = GenerationSettings.LookupBackedBuilder(
            context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
        )

        globalOverworldGeneration(biomeBuilder)
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_WARM)
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_DEEP_WARM)

        return Biome.Builder()
            .precipitation(true)
            .downfall(0.4f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects(
                BiomeEffects.Builder()
                    .waterColor(0x98a869)
                    .waterFogColor(0x535c39)
                    .skyColor(0x30c918)
                    .grassColor(0x5bd959)
                    .foliageColor(0x5bd959)
                    .fogColor(0x22a1e6)
                    .moodSound(BiomeMoodSound.CAVE)
                    .music(MusicType.createIngameMusic(MUSIC_UNDER_WATER)).build()
            )
            .build()
    }
}