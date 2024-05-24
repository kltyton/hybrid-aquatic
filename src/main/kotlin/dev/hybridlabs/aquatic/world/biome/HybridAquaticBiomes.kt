package dev.hybridlabs.aquatic.world.biome

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.entity.HybridAquaticEntityTypes
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BiomeMoodSound
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.biome.SpawnSettings.SpawnEntry
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.DefaultBiomeFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures

object HybridAquaticBiomes {
    val TROPICAL_BEACH: RegistryKey<Biome> = RegistryKey.of(
        RegistryKeys.BIOME,
        Identifier(HybridAquatic.MOD_ID, "tropical_beach")
    )
    fun bootstrap(context: Registerable<Biome>) {
        context.register(TROPICAL_BEACH, tropicalBeach(context))
    }

    fun globalOverworldGeneration(builder: GenerationSettings.LookupBackedBuilder) {
        DefaultBiomeFeatures.addLandCarvers(builder)
        DefaultBiomeFeatures.addAmethystGeodes(builder)
        DefaultBiomeFeatures.addDungeons(builder)
        DefaultBiomeFeatures.addMineables(builder)
        DefaultBiomeFeatures.addSprings(builder)
        DefaultBiomeFeatures.addFrozenTopLayer(builder)
    }

    fun tropicalBeach(context: Registerable<Biome>): Biome {
        val spawnBuilder = SpawnSettings.Builder()
        spawnBuilder.spawn(SpawnGroup.CREATURE, SpawnEntry(HybridAquaticEntityTypes.COCONUT_CRAB, 2, 1, 3))
        spawnBuilder.spawn(SpawnGroup.CREATURE, SpawnEntry(EntityType.TURTLE, 5, 2, 5))

        val biomeBuilder = GenerationSettings.LookupBackedBuilder(
            context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
            context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER)
        )

        globalOverworldGeneration(biomeBuilder)
        biomeBuilder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_JUNGLE)

        return Biome.Builder()
            .precipitation(true)
            .downfall(0.4f)
            .temperature(0.7f)
            .generationSettings(biomeBuilder.build())
            .spawnSettings(spawnBuilder.build())
            .effects(
                BiomeEffects.Builder()
                    .waterColor(0x3bbcd9)
                    .waterFogColor(0x3183bd)
                    .skyColor(0x30c918)
                    .grassColor(0x5bd959)
                    .foliageColor(0x5bd959)
                    .fogColor(0x22a1e6)
                    .moodSound(BiomeMoodSound.CAVE)
                    .build()
            )
            .build()
    }
}