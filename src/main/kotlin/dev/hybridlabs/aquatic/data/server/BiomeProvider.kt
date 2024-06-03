package dev.hybridlabs.aquatic.data.server

import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes
import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes.redMeadow
import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes.sargassumSea
import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes.tidePools
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class BiomeProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(lookup: RegistryWrapper.WrapperLookup, entries: Entries) {
        entries.add(HybridAquaticBiomes.SARGASSUM_SEA,
            sargassumSea(lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE),
                lookup.getWrapperOrThrow(RegistryKeys.CONFIGURED_CARVER)))

        entries.add(HybridAquaticBiomes.RED_MEADOW,
            redMeadow(lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE),
                lookup.getWrapperOrThrow(RegistryKeys.CONFIGURED_CARVER)))

        entries.add(HybridAquaticBiomes.TIDE_POOLS,
            tidePools(lookup.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE),
                lookup.getWrapperOrThrow(RegistryKeys.CONFIGURED_CARVER))
        )
    }

    override fun getName(): String {
        return "Biomes"
    }
}
