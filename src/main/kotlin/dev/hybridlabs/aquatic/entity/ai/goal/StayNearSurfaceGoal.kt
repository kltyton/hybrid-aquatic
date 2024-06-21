package dev.hybridlabs.aquatic.entity.ai.goal

import net.minecraft.block.Blocks
import net.minecraft.entity.ai.goal.Goal
import net.minecraft.entity.mob.MobEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d

@Suppress("DEPRECATION")
class StayNearSurfaceGoal(private val mob: MobEntity) : Goal() {

    override fun canStart(): Boolean {
        return true
    }

    override fun tick() {
        val blockPos = mob.blockPos
        val blockAbove = mob.entityWorld.getBlockState(blockPos.up(17))
        val ceilingAbove = isSolidBlockAbove(blockPos)
        val waterBelow = isWaterBelow(blockPos)

        if (blockAbove.isOf(Blocks.WATER) && !ceilingAbove && waterBelow) {
            setUpwardVelocity()
        }
    }

    private fun isSolidBlockAbove(pos: BlockPos): Boolean {
        for (i in 1..16) {
            val state = mob.entityWorld.getBlockState(pos.up(i))
            if (state.isSolid) {
                val airGapBelow = mob.entityWorld.getBlockState(pos.up(i - 1)).isOf(Blocks.AIR)
                if (!airGapBelow) {
                    return true
                }
            }
        }
        return false
    }

    private fun isWaterBelow(pos: BlockPos): Boolean {
        for (i in 1..8) {
            val state = mob.entityWorld.getBlockState(pos.down(i))
            if (state.isOf(Blocks.WATER)) {
                return true
            }
        }
        return false
    }

    private fun setUpwardVelocity() {
        val upwardVelocity = 0.25
        val currentVelocity = mob.velocity
        mob.velocity = Vec3d(currentVelocity.x, upwardVelocity, currentVelocity.z)
    }
}