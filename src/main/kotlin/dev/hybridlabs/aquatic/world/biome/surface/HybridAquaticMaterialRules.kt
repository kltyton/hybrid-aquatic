package dev.hybridlabs.aquatic.world.biome.surface

import dev.hybridlabs.aquatic.world.biome.HybridAquaticBiomes
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.world.gen.surfacebuilder.MaterialRules

object HybridAquaticMaterialRules {
    private val SAND: MaterialRules.MaterialRule = makeStateRule(Blocks.SAND)

    fun makeRules(): MaterialRules.MaterialRule {
        val isAtOrAboveWaterLevel: MaterialRules.MaterialCondition = MaterialRules.water(-1, 0)

        return MaterialRules.sequence(
            MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(HybridAquaticBiomes.SARGASSUM_SEA),
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, SAND)),
                MaterialRules.condition(MaterialRules.biome(HybridAquaticBiomes.RED_MEADOW),
                    MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, SAND)),
            )
        )
    }

    private fun makeStateRule(block: Block): MaterialRules.MaterialRule {
        return MaterialRules.block(block.defaultState)
    }
}
