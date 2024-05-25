package dev.hybridlabs.aquatic.world.gen.feature

import com.mojang.serialization.Codec
import dev.hybridlabs.aquatic.block.SargassumSeaweedBlock
import net.minecraft.util.math.Direction
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.util.FeatureContext

class SargassumPatchFeature(codec: Codec<SargassumPatchFeatureConfig>) : Feature<SargassumPatchFeatureConfig>(codec) {
    override fun generate(context: FeatureContext<SargassumPatchFeatureConfig>): Boolean {
        val config = context.config
        val world = context.world
        val origin = context.origin
        context.random
        val state = config.toPlace[context.random, origin]

        if (state.block !is SargassumSeaweedBlock) {
            return false
        }

        val pos = context.origin.mutableCopy()

        if (!state.canPlaceAt(world, pos)) {
            if (state.canPlaceAt(world, pos.down())) {
                pos.move(Direction.DOWN)
            } else {
                return false
            }
        }
        return true
    }
}