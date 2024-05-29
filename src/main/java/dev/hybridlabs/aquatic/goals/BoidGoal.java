package dev.hybridlabs.aquatic.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;

public class BoidGoal extends Goal {
    public static final Logger LOGGER = LogManager.getLogger();

    public final float separationInfluence;
    public final float separationRange;
    public final float alignmentInfluence;
    public final float cohesionInfluence;
    private final MobEntity mob;
    private int timeToFindNearbyEntities;
    List<? extends MobEntity> nearbyMobs;
    private boolean enabled = true;

    public BoidGoal(MobEntity mob, float separationInfluence, float separationRange, float alignmentInfluence, float cohesionInfluence) {
        timeToFindNearbyEntities = 0;

        this.mob = mob;
        this.separationInfluence = separationInfluence;
        this.separationRange = separationRange;
        this.alignmentInfluence = alignmentInfluence;
        this.cohesionInfluence = cohesionInfluence;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    public void tick() {
        if (!enabled) {
            return;
        }

        if (--this.timeToFindNearbyEntities <= 0) {
            this.timeToFindNearbyEntities = 40;
            nearbyMobs = getNearbyEntitiesOfSameClass(mob);
        } else {
            nearbyMobs.removeIf(LivingEntity::isDead);
        }

        if (nearbyMobs.isEmpty()) {
            LOGGER.warn("No nearby entities found. There should always be at least the entity itself. Will disable behavior for this entity instead of crash for compatibility reasons");
            enabled = false;
        }

        mob.addVelocity(random());
        mob.addVelocity(cohesion());
        mob.addVelocity(alignment());
        mob.addVelocity(separation());
    }

    public static List<? extends MobEntity> getNearbyEntitiesOfSameClass(MobEntity mob) {
        Predicate<MobEntity> predicate = (_mob) -> true;

        return mob.getEntityWorld().getEntitiesByClass(mob.getClass(), mob.getBoundingBox().expand(4.0, 4.0, 4.0), predicate);
    }

    public Vec3d random() {
        var velocity = mob.getVelocity();

        if (Math.abs((float) velocity.x) < 0.1 && Math.abs((float) velocity.z) < 0.1)
            return new Vec3d(randomSign() * 0.2, 0, randomSign() * 0.2);

        return Vec3d.ZERO;
    }

    public int randomSign() {
        var isNegative = mob.getRandom().nextBoolean();

        if (isNegative) {
            return -1;
        }

        return 1;
    }

    public Vec3d separation() {
        var c = Vec3d.ZERO;

        for (MobEntity nearbyMob : nearbyMobs) {
            if ((nearbyMob.getPos().subtract(mob.getPos()).length()) < separationRange) {
                c = c.subtract(nearbyMob.getPos().subtract(mob.getPos()));
            }
        }

        return c.multiply(separationInfluence);
    }

    public Vec3d alignment() {
        var c = Vec3d.ZERO;

        for (MobEntity nearbyMob : nearbyMobs) {
            c = c.add(nearbyMob.getVelocity());
        }

        c = c.multiply(1f / nearbyMobs.size());
        c = c.subtract(mob.getVelocity());
        return c.multiply(alignmentInfluence);
    }

    public Vec3d cohesion() {
        var c = Vec3d.ZERO;

        for (MobEntity nearbyMob : nearbyMobs) {
            c = c.add(nearbyMob.getPos());
        }

        c = c.multiply(1f / nearbyMobs.size());
        c = c.subtract(mob.getPos());
        return c.multiply(cohesionInfluence);
    }
}