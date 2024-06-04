package dev.hybridlabs.aquatic.block

import dev.hybridlabs.aquatic.world.tree.CoconutPalmSaplingGenerator
import net.minecraft.block.BlockState
import net.minecraft.block.SaplingBlock
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.registry.tag.BlockTags
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

class CoconutPalmSaplingBlock(settings: Settings) : SaplingBlock(CoconutPalmSaplingGenerator(), settings) {
    override fun canPlantOnTop(floor: BlockState, world: BlockView?, pos: BlockPos?): Boolean {
        return floor.isIn(BlockTags.SAND)
    }

    override fun canPathfindThrough(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        type: NavigationType?
    ): Boolean {
        return true
    }
}