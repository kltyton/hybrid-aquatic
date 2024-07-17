package dev.hybridlabs.aquatic.effect

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class Thalassophobia : StatusEffect(StatusEffectCategory.HARMFUL, 0x9abbb7) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return duration % 40 == 0
    }
}
