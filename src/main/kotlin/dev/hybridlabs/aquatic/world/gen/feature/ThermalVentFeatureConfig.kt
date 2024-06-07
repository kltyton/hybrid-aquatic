package dev.hybridlabs.aquatic.world.gen.feature

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.world.gen.feature.FeatureConfig

class ThermalVentFeatureConfig(
    val floorSearchRange: Int,
    val placementRadiusAroundFloor: Int,
    val placementProbabilityPerValidPosition: Float
) : FeatureConfig {
    companion object {
        val CODEC: Codec<ThermalVentFeatureConfig> =
            RecordCodecBuilder.create { instance: RecordCodecBuilder.Instance<ThermalVentFeatureConfig> ->
                instance.group(
                    Codec.intRange(0, 512).fieldOf("floor_search_range")
                        .forGetter { config: ThermalVentFeatureConfig -> config.floorSearchRange },
                    Codec.intRange(0, 64).fieldOf("placement_radius_around_floor")
                        .forGetter { config: ThermalVentFeatureConfig -> config.placementRadiusAroundFloor },
                    Codec.floatRange(0.0f, 1.0f).fieldOf("placement_probability_per_valid_position")
                        .forGetter { config: ThermalVentFeatureConfig -> config.placementProbabilityPerValidPosition }
                ).apply(instance) { floorSearchRange: Int, placementRadiusAroundFloor: Int, placementProbabilityPerValidPosition: Float ->
                    ThermalVentFeatureConfig(
                        floorSearchRange,
                        placementRadiusAroundFloor,
                        placementProbabilityPerValidPosition
                    )
                }
            }
    }
}