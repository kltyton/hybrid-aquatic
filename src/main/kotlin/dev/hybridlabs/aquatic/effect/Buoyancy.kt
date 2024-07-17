package dev.hybridlabs.aquatic.effect

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.util.math.Vec3d

class Buoyancy : StatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFFFF) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return duration % 20 == 0
    }

    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int) {
        val currentVelocity = entity.velocity
        if (entity.isSubmergedInWater) {
            entity.velocity = Vec3d(currentVelocity.x, 1.0, currentVelocity.z)
        }
    }
}
