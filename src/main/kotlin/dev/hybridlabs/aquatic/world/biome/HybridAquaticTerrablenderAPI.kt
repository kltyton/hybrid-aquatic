package dev.hybridlabs.aquatic.world.biome

import dev.hybridlabs.aquatic.HybridAquatic
import dev.hybridlabs.aquatic.world.biome.surface.HybridAquaticMaterialRules
import net.minecraft.util.Identifier
import terrablender.api.Regions
import terrablender.api.SurfaceRuleManager
import terrablender.api.TerraBlenderApi

class HybridAquaticTerrablenderAPI : TerraBlenderApi {
    override fun onTerraBlenderInitialized() {
        Regions.register(HybridAquaticOverworldRegion(Identifier(HybridAquatic.MOD_ID, "overworld"), 4))

        SurfaceRuleManager.addSurfaceRules(
            SurfaceRuleManager.RuleCategory.OVERWORLD,
            HybridAquatic.MOD_ID,
            HybridAquaticMaterialRules.makeRules())
    }
}