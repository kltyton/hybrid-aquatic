package dev.hybridlabs.aquatic.entity.ai.goal

import net.minecraft.block.Blocks
import net.minecraft.entity.ai.goal.Goal
import net.minecraft.entity.mob.MobEntity
import net.minecraft.util.math.Vec3d
import kotlin.math.abs

class StayNearSeabedGoal(private val mob: MobEntity) : Goal() {
    private var timer = 0

    override fun canStart(): Boolean {
        return true
    }

    override fun tick() {
        timer++
        if (timer >= 10) {
            val blockPos = mob.blockPos
            val blockBelow = mob.entityWorld.getBlockState(blockPos.down(3))
            val amount = amount()

            if (blockBelow.isOf(Blocks.WATER)) {
                mob.addVelocity(Vec3d(0.0, -amount.toDouble(), 0.0))
            }

            timer = 0
        }
    }

    private fun amount(): Float {
        var amount = 0.05f
        val dY = abs(mob.velocity.y.toFloat().toDouble()).toFloat()

        if (dY > amount) {
            amount = dY
        }

        return amount
    }
}
