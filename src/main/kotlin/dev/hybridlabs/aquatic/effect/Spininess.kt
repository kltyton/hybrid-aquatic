package dev.hybridlabs.aquatic.effect

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.registry.tag.DamageTypeTags

class Spininess : StatusEffect(StatusEffectCategory.BENEFICIAL, 0xFFFFFF) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return duration % 40 == 0
    }

    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int) {
        entity.recentDamageSource?.let { damageSource ->
            val attacker = damageSource.source
            if (attacker is LivingEntity && !attacker.isDead) {
                if (!damageSource.isIn(DamageTypeTags.AVOIDS_GUARDIAN_THORNS) && !damageSource.isOf(DamageTypes.THORNS)) {
                    attacker.damage(entity.damageSources.thorns(entity), 2.0f)
                }
            }
        }
    }
}
