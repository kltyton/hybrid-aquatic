package dev.hybridlabs.aquatic.item

import dev.hybridlabs.aquatic.HybridAquatic
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import java.util.function.Supplier

enum class HybridAquaticArmorMaterials(
    private val id: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>
) : ArmorMaterial {
    DIVING("diving", 25, intArrayOf(3, 8, 6, 3), 19,
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2f, 0.1f, Supplier<Ingredient> {
            Ingredient.ofItems(
                Items.COPPER_INGOT
            )
        });

    override fun getDurability(type: ArmorItem.Type): Int {
        return BASE_DURABILITY[type.ordinal] * this.durabilityMultiplier
    }

    override fun getProtection(type: ArmorItem.Type): Int {
        return protectionAmounts[type.ordinal]
    }

    override fun getEnchantability(): Int {
        return this.enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return this.equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return HybridAquatic.MOD_ID + ":" + this.id
    }

    override fun getToughness(): Float {
        return this.toughness
    }

    override fun getKnockbackResistance(): Float {
        return this.knockbackResistance
    }

    companion object {
        private val BASE_DURABILITY = intArrayOf(11, 16, 15, 13)
    }
}
