package dev.hybridlabs.aquatic.tag

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.world.biome.Biome

object HybridAquaticBiomeTags {

    val BOTTLE_SPAWN_BIOMES = create("bottle_spawn_biomes")

    val OCEAN = create("ocean")
    val DEEP_OCEAN = create("deep_ocean")
    val ALL_OCEANS = create("all_oceans")
    val ALL_DEEP_OCEANS = create("deep_oceans")
    val COLD_OCEANS = create("cold_oceans")
    val DEEP_COLD_OCEANS = create("deep_cold_oceans")
    val ALL_COLD_OCEANS = create("all_cold_oceans")
    val DEEP_WARM_OCEANS = create("deep_warm_oceans")
    val ALL_WARM_OCEANS = create("all_warm_oceans")
    val REEF = create("reef")
    val JUNGLE = create("jungle")
    val CHERRY = create("cherry")
    val SWAMP = create("swamp")
    val MARSHES = create("marshes")
    val MANGROVES = create("mangroves")
    val RIVERS = create("rivers")
    val TROPICAL_RIVERS = create("tropical_rivers")
    val SANDY_BEACHES = create("sandy_beaches")
    val ROCKY_BEACHES = create("rocky_beaches")

    private fun create(id: String): TagKey<Biome> {
        return TagKey.of(RegistryKeys.BIOME, Identifier(HybridAquatic.MOD_ID, id))
    }
}
