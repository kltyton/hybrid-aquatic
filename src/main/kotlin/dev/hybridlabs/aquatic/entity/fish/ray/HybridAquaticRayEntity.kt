package dev.hybridlabs.aquatic.entity.fish.ray

import dev.hybridlabs.aquatic.entity.ai.goal.StayInWaterGoal
import dev.hybridlabs.aquatic.entity.fish.HybridAquaticFishEntity
import dev.hybridlabs.aquatic.tag.HybridAquaticEntityTags
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.entity.MovementType
import net.minecraft.entity.ai.control.MoveControl
import net.minecraft.entity.ai.pathing.MobNavigation
import net.minecraft.entity.ai.pathing.SwimNavigation
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import kotlin.math.sqrt

@Suppress("LeakingThis", "CanBeParameter")
open class HybridAquaticRayEntity(
    type: EntityType<out HybridAquaticFishEntity>,
    world: World,
    private val variants: Map<String, FishVariant> = hashMapOf(),
    override val prey: TagKey<EntityType<*>>,
    override val predator: TagKey<EntityType<*>>,
    override val assumeDefault: Boolean = false,
    override val collisionRules: List<VariantCollisionRules> = listOf()
) : HybridAquaticFishEntity(type, world, variants, HybridAquaticEntityTags.NONE, HybridAquaticEntityTags.NONE) {
    private val landNavigation: MobNavigation = MobNavigation(this, world)
    private val waterNavigation: SwimNavigation = SwimNavigation(this, world)

    init {
        moveControl = RayMoveControl(this)
    }

    override fun initGoals() {
        super.initGoals()
        goalSelector.add(1, StayInWaterGoal(this))
    }

    override fun shouldFlopOnLand(): Boolean {
        return false
    }

    override fun shouldSwimInFluids(): Boolean {
        return true
    }

    override fun travel(movementInput: Vec3d?) {
        if (isLogicalSideForUpdatingMovement && isTouchingWater) {
            if (isNearSeafloor()) {
                super.travel(movementInput)
            } else {
                updateVelocity(0.01f, movementInput)
                move(MovementType.SELF, velocity)
                velocity = velocity.multiply(0.9)
            }
        } else {
            super.travel(movementInput)
        }
    }

    override fun updateSwimming() {
        if (!world.isClient) {
            if (canMoveVoluntarily() && isTouchingWater) {
                navigation = if (isNearSeafloor()) {
                    landNavigation
                } else {
                    waterNavigation
                }
                isSwimming = true
            } else {
                navigation = landNavigation
                isSwimming = false
            }
        }
    }

    private fun isNearSeafloor(): Boolean {
        val blockPos = this.blockPos.down(1)
        val blockState = world.getBlockState(blockPos)
        return !blockState.isOf(Blocks.WATER) && this.isSubmergedInWater
    }

    private class RayMoveControl(private val ray: HybridAquaticRayEntity) : MoveControl(ray) {
        override fun tick() {
            val livingEntity = ray.target
            if (ray.isTouchingWater) {
                if (livingEntity != null && livingEntity.y > ray.y) {
                    ray.velocity = ray.velocity.add(0.0, 0.002, 0.0)
                }

                if (state != State.MOVE_TO || ray.navigation.isIdle) {
                    ray.movementSpeed = 0.0f
                    return
                }

                val d = targetX - ray.x
                var e = targetY - ray.y
                val f = targetZ - ray.z
                val g = sqrt(d * d + e * e + f * f)
                e /= g
                val h = (MathHelper.atan2(f, d) * 57.2957763671875).toFloat() - 90.0f
                ray.yaw = wrapDegrees(ray.yaw, h, 90.0f)
                ray.bodyYaw = ray.yaw
                val i = (speed * ray.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)).toFloat()
                val j = MathHelper.lerp(0.125f, ray.movementSpeed, i)
                ray.movementSpeed = j
                ray.velocity = ray.velocity.add(j * d * 0.005, j * e * 0.1, j * f * 0.005)
            } else {
                if (!ray.isOnGround) {
                    ray.velocity = ray.velocity.add(0.0, -0.008, 0.0)
                }

                super.tick()
            }
        }
    }
}