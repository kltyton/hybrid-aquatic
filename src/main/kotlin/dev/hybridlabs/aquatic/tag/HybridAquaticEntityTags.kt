package dev.hybridlabs.aquatic.tag

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.entity.EntityType
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier

object HybridAquaticEntityTags {
    val NONE = create("prey/none")
    val BULL_SHARK_PREY = create("prey/bull_shark")
    val FRILLED_SHARK_PREY = create("prey/frilled_shark")
    val GREAT_WHITE_SHARK_PREY = create("prey/great_white_shark")
    val HAMMERHEAD_SHARK_PREY = create("prey/hammerhead_shark")
    val THRESHER_SHARK_PREY = create("prey/thresher_shark")
    val TIGER_SHARK_PREY = create("prey/tiger_shark")
    val STINGRAY_PREY = create("prey/stingray")
    val MORAY_EEL_PREY = create("prey/moray_eel")
    val LIONFISH_PREY = create("prey/lionfish")
    val OPAH_PREY = create("prey/opah")
    val NEEDLEFISH_PREY = create("prey/needlefish")
    val PIRANHA_PREY = create("prey/piranha")
    val MAHI_PREY = create("prey/mahi_mahi")
    val TUNA_PREY = create("prey/tuna")
    val CUTTLEFISH_PREY = create("prey/cuttlefish")
    val TRIGGERFISH_PREY = create("prey/triggerfish")
    val FIREFLY_SQUID_PREY = create("prey/firefly_squid")
    val SUNFISH_PREY = create("prey/sunfish")
    val OARFISH_PREY = create("prey/oarfish")
    val OCTOPUS_PREY = create("prey/octopus")
    val ANGLERFISH_PREY = create("prey/anglerfish")
    val DRAGONFISH_PREY = create("prey/dragonfish")

    val LARGE_PREY = create("large_prey")
    val MEDIUM_PREY = create("medium_prey")
    val SMALL_PREY = create("small_prey")
    val CRITTER = create("critter")
    val CRAB = create("crab")
    val SHRIMP = create("shrimp")
    val JELLYFISH = create("jellyfish")
    val FISHES = create("fishes")
    val SHARKS = create("sharks")

    private fun create(id: String): TagKey<EntityType<*>> {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier(HybridAquatic.MOD_ID, id))
    }
}
