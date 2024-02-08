package dev.hybridlabs.aquatic.effect

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class Clarity : StatusEffect(StatusEffectCategory.BENEFICIAL, 0x606060) {

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return duration % 40 == 0
    }
}
