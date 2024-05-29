package dev.hybridlabs.aquatic.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;

public class StayInWaterGoal extends Goal {
    private final MobEntity mob;

    public StayInWaterGoal(MobEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void tick() {
        var blockPos = mob.getBlockPos();
        var blockAbove = mob.getEntityWorld().getBlockState(blockPos.up(1));
        var blockBelow = mob.getEntityWorld().getBlockState(blockPos.down(1));
        var amount = amount();

        if(blockAbove.isAir()) {
            mob.addVelocity(new Vec3d(0, -amount, 0));
        }

        if(blockBelow.isSolid()) {
            mob.addVelocity(new Vec3d(0, amount, 0));
        }
    }

    float amount() {
        var amount = 0.5f;
        var dY = Math.abs((float) mob.getVelocity().y);

        if (dY > amount) {
            amount = dY;
        }

        return amount;
    }
}
