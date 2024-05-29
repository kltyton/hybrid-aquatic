package dev.hybridlabs.aquatic.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;

public class HeightBoundsGoal extends Goal {
    private final MobEntity mob;
    private final float minHeight;
    private final float maxHeight;

    public HeightBoundsGoal(MobEntity mob, float minHeight, float maxHeight) {
        this.mob = mob;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean canStart() {
        return mob.getY() > maxHeight || mob.getY() < maxHeight;
    }

    @Override
    public void tick() {
        mob.addVelocity(bounds());
    }

    public Vec3d bounds() {
        var amount = 0.1;
        var dY = Math.abs((float) mob.getVelocity().y);

        if (dY > amount) {
            amount = dY;
        }

        if (mob.getY() > maxHeight) {
            return new Vec3d(0, -amount, 0);
        }
        if (mob.getY() < minHeight)
            return new Vec3d(0, amount, 0);

        return Vec3d.ZERO;
    }
}
