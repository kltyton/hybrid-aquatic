package dev.hybridlabs.aquatic.goals;

import net.minecraft.command.argument.EntityAnchorArgumentType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;

public class LimitSpeedAndLookInVelocityDirectionGoal extends Goal {
    private final MobEntity mob;
    private final float minSpeed;
    private final float maxSpeed;

    public LimitSpeedAndLookInVelocityDirectionGoal(MobEntity mob, float minSpeed, float maxSpeed) {
        this.mob = mob;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void tick() {
        var velocity = mob.getVelocity();
        var speed = velocity.length();

        if (speed < minSpeed)
            velocity = velocity.multiply(minSpeed);
        if (speed > maxSpeed)
            velocity = velocity.multiply(maxSpeed);

        mob.setVelocity(velocity);
        mob.lookAt(EntityAnchorArgumentType.EntityAnchor.EYES, mob.getPos().add(velocity.multiply(3)));
    }
}
