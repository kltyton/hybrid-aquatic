package dev.hybridlabs.aquatic.enchantment

import dev.hybridlabs.aquatic.entity.HybridAquaticEntityTypes
import dev.hybridlabs.aquatic.item.HybridAquaticItems
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentTarget
import net.minecraft.entity.EntityType
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.Items

class LiveCatchEnchantment : Enchantment(Rarity.RARE, EnchantmentTarget.FISHING_ROD, arrayOf(EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND)) {
    override fun getMinPower(level: Int): Int {
        return 25
    }

    override fun getMaxLevel(): Int {
        return 1
    }

    companion object {
        //TODO: Probably need to move all of this into data so other people can modify this list. Not very important
        val ITEM_TO_ENTITYTYPE = hashMapOf(
            Items.COD to EntityType.COD,
            Items.SALMON to EntityType.SALMON,
            Items.TROPICAL_FISH to EntityType.TROPICAL_FISH,
            Items.PUFFERFISH to EntityType.PUFFERFISH,
            HybridAquaticItems.LIONFISH to HybridAquaticEntityTypes.LIONFISH,
            HybridAquaticItems.MAHI_MAHI to HybridAquaticEntityTypes.MAHIMAHI,
            HybridAquaticItems.TUNA to HybridAquaticEntityTypes.TUNA,
            HybridAquaticItems.OPAH to HybridAquaticEntityTypes.OPAH,
            HybridAquaticItems.ROCKFISH to HybridAquaticEntityTypes.ROCKFISH,
            HybridAquaticItems.BLUE_SPOTTED_STINGRAY to HybridAquaticEntityTypes.BLUE_SPOTTED_STINGRAY,
            HybridAquaticItems.MORAY_EEL to HybridAquaticEntityTypes.MORAY_EEL,
            HybridAquaticItems.NEEDLEFISH to HybridAquaticEntityTypes.NEEDLEFISH,
            HybridAquaticItems.PIRANHA to HybridAquaticEntityTypes.PIRANHA,
            HybridAquaticItems.ANGLERFISH to HybridAquaticEntityTypes.ANGLERFISH,
            HybridAquaticItems.BARRELEYE to HybridAquaticEntityTypes.BARRELEYE,
            HybridAquaticItems.BLUE_TANG to HybridAquaticEntityTypes.BLUE_TANG,
            HybridAquaticItems.CLOWNFISH to HybridAquaticEntityTypes.CLOWNFISH,
            HybridAquaticItems.COWFISH to HybridAquaticEntityTypes.COWFISH,
            HybridAquaticItems.TRIGGERFISH to HybridAquaticEntityTypes.TRIGGERFISH,
            HybridAquaticItems.TIGER_BARB to HybridAquaticEntityTypes.TIGER_BARB,
            HybridAquaticItems.BETTA to HybridAquaticEntityTypes.BETTA,
            HybridAquaticItems.TETRA to HybridAquaticEntityTypes.TETRA,
            HybridAquaticItems.DANIO to HybridAquaticEntityTypes.DANIO,
            HybridAquaticItems.DISCUS to HybridAquaticEntityTypes.DISCUS,
            HybridAquaticItems.RATFISH to HybridAquaticEntityTypes.RATFISH,
            HybridAquaticItems.FLASHLIGHT_FISH to HybridAquaticEntityTypes.FLASHLIGHT_FISH,
            HybridAquaticItems.GOURAMI to HybridAquaticEntityTypes.GOURAMI,
        )
    }
}