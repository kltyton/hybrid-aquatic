package dev.hybridlabs.aquatic.world.gen.feature

import com.mojang.serialization.Codec
import dev.hybridlabs.aquatic.block.HybridAquaticBlocks
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.KelpBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Vec3i
import net.minecraft.util.math.random.Random
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.WorldAccess
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.util.CaveSurface
import net.minecraft.world.gen.feature.util.FeatureContext
import java.util.*
import java.util.function.Predicate

class ThermalVentFeature(codec: Codec<ThermalVentFeatureConfig>?) : Feature<ThermalVentFeatureConfig>(codec) {
    override fun generate(context: FeatureContext<ThermalVentFeatureConfig>): Boolean {
        val structureWorldAccess = context.world
        val blockPos = context.origin
        val config = context.config
        val random = context.random
        val optionalInt = getFloorHeight(structureWorldAccess, blockPos, config)
        if (!optionalInt.isPresent) {
            return false
        } else {
            val blockPos2 = blockPos.withY(optionalInt.asInt)
            val vec3i = Vec3i(config.placementRadiusAroundFloor, config.placementRadiusAroundFloor, config.placementRadiusAroundFloor)
            val box = Box(blockPos2.subtract(vec3i), blockPos2.add(vec3i))
            return BlockPos.stream(box)
                .filter { pos -> random.nextFloat() < config.placementProbabilityPerValidPosition }
                .filter { pos -> isValidPosition(structureWorldAccess, pos) }
                .mapToInt { pos ->
                    placeThermalVent(structureWorldAccess, pos, random)
                    1
                }
                .sum() > 0
        }
    }

    private fun placeThermalVent(world: StructureWorldAccess, pos: BlockPos, random: Random) {
        val blockState = HybridAquaticBlocks.THERMAL_VENT.defaultState
        val blockState2 = HybridAquaticBlocks.THERMAL_VENT_SHAFT.defaultState
        val k = 1 + random.nextInt(3)

        var blockPos2 = pos
        for (l in 0..k) {
            if (world.getBlockState(blockPos2).isOf(Blocks.WATER) && world.getBlockState(blockPos2.up()).isOf(Blocks.WATER) && blockState2.canPlaceAt(world, blockPos2)) {
                if (l == k) {
                    world.setBlockState(blockPos2, blockState.with(KelpBlock.AGE, random.nextInt(4) + 20) as BlockState, 2)
                } else {
                    world.setBlockState(blockPos2, blockState2, 2)
                }
            } else if (l > 0) {
                val blockPos3 = blockPos2.down()
                if (blockState.canPlaceAt(world, blockPos3) && !world.getBlockState(blockPos3.down()).isOf(HybridAquaticBlocks.THERMAL_VENT)) {
                    world.setBlockState(blockPos3, blockState.with(KelpBlock.AGE, random.nextInt(4) + 20) as BlockState, 2)
                }
                break
            }
            blockPos2 = blockPos2.up()
        }
    }

    private fun getFloorHeight(world: StructureWorldAccess, pos: BlockPos, config: ThermalVentFeatureConfig): OptionalInt {
        val predicate: Predicate<BlockState> = Predicate { state -> state.isOf(Blocks.WATER) }
        val predicate2: Predicate<BlockState> = Predicate { state -> !state.isOf(Blocks.WATER) }
        val optional: Optional<CaveSurface> = CaveSurface.create(world, pos, config.floorSearchRange, predicate, predicate2)
        return optional.map { it.floorHeight }.orElseGet { OptionalInt.empty() }
    }

    private fun isValidPosition(world: StructureWorldAccess, pos: BlockPos): Boolean {
        if (!isWaterOrAir(world, pos) && !isWaterOrAir(world, pos.down())) {
            for (direction in Direction.Type.HORIZONTAL) {
                if (isWaterOrAir(world, pos.offset(direction))) {
                    return false
                }
            }
            return true
        } else {
            return false
        }
    }

    private fun isWaterOrAir(world: WorldAccess, pos: BlockPos): Boolean {
        val blockState = world.getBlockState(pos)
        return blockState.isOf(Blocks.WATER) || blockState.isAir
    }
}
