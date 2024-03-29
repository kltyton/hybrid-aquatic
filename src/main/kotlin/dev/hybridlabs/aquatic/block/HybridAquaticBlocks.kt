package dev.hybridlabs.aquatic.block

import com.google.common.collect.ImmutableSet
import dev.hybridlabs.aquatic.HybridAquatic
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.MapColor
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.enums.Instrument
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

/**
 * The registry of all blocks in Hybrid Aquatic.
 */
object HybridAquaticBlocks {
    val ANEMONE = register("anemone", AnemoneBlock(
        FabricBlockSettings.create()
            .mapColor(MapColor.DARK_DULL_PINK)
            .ticksRandomly()
            .strength(0.4f)
            .nonOpaque()
            .pistonBehavior(PistonBehavior.DESTROY)
            .sounds(BlockSoundGroup.SLIME)
            .drops(Identifier(HybridAquatic.MOD_ID, "blocks/anemone"))
    ))

    val MESSAGE_IN_A_BOTTLE = register("message_in_a_bottle", MessageInABottleBlock(
        FabricBlockSettings.copyOf(Blocks.GLASS)
            .breakInstantly()
            .pistonBehavior(PistonBehavior.DESTROY)
    ))

    val BASKING_SHARK_PLUSHIE = register("basking_shark_plushie", createPlushieBlock(PlushieBlock.Variant.BASKING_SHARK, Blocks.GRAY_WOOL))
    val BULL_SHARK_PLUSHIE = register("bull_shark_plushie", createPlushieBlock(PlushieBlock.Variant.BULL_SHARK, Blocks.LIGHT_GRAY_WOOL))
    val FRILLED_SHARK_PLUSHIE = register("frilled_shark_plushie", createPlushieBlock(PlushieBlock.Variant.FRILLED_SHARK, Blocks.GRAY_WOOL))
    val GREAT_WHITE_SHARK_PLUSHIE = register("great_white_shark_plushie", createPlushieBlock(PlushieBlock.Variant.GREAT_WHITE_SHARK, Blocks.LIGHT_GRAY_WOOL))
    val HAMMERHEAD_SHARK_PLUSHIE = register("hammerhead_shark_plushie", createPlushieBlock(PlushieBlock.Variant.HAMMERHEAD_SHARK, Blocks.LIGHT_GRAY_WOOL))
    val THRESHER_SHARK_PLUSHIE = register("thresher_shark_plushie", createPlushieBlock(PlushieBlock.Variant.THRESHER_SHARK, Blocks.LIGHT_BLUE_WOOL))
    val TIGER_SHARK_PLUSHIE = register("tiger_shark_plushie", createPlushieBlock(PlushieBlock.Variant.TIGER_SHARK, Blocks.BLACK_WOOL))
    val WHALE_SHARK_PLUSHIE = register("whale_shark_plushie", createPlushieBlock(PlushieBlock.Variant.WHALE_SHARK, Blocks.LIGHT_GRAY_WOOL))

    val HYBRID_CRATE = register("hybrid_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
        .hardness(0.75F)
    ))

    val OAK_CRATE = register("oak_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
        .hardness(0.75F)
    ))

    val SPRUCE_CRATE = register("spruce_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)
        .hardness(0.75F)
    ))

    val BIRCH_CRATE = register("birch_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)
        .hardness(0.75F)
    ))

    val DARK_OAK_CRATE = register("dark_oak_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)
        .hardness(0.75F)
    ))

    val ACACIA_CRATE = register("acacia_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)
        .hardness(0.75F)
    ))

    val JUNGLE_CRATE = register("jungle_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)
        .hardness(0.75F)
    ))

    val MANGROVE_CRATE = register("mangrove_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)
        .hardness(0.75F)
    ))

    val CHERRY_CRATE = register("cherry_crate", CrateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)
        .hardness(0.75F)
    ))

    val TUBE_SPONGE = register("tube_sponge", TubeSpongeBlock(FabricBlockSettings.copyOf(Blocks.WET_SPONGE)
        .nonOpaque()
    ))

    val GIANT_CLAM = register("giant_clam", GiantClamBlock(FabricBlockSettings.copyOf(Blocks.TUFF)
        .nonOpaque()
        .hardness(1.0F)
        .pistonBehavior(PistonBehavior.DESTROY)
        .drops(Identifier(HybridAquatic.MOD_ID, "blocks/giant_clam"))
    ))

    val BUOY = register("buoy", BuoyBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
        .nonOpaque()
        .luminance(15)
        .hardness(0.75F)
    ))

    val HYDROTHERMAL_VENT = register("hydrothermal_vent", HydrothermalVentBlock(FabricBlockSettings.create()
        .nonOpaque()
        .hardness(1.0F)
        .pistonBehavior(PistonBehavior.DESTROY)
    ))

    private fun createPlushieBlock(variant: PlushieBlock.Variant, particleBlock: Block): PlushieBlock {
        return PlushieBlock(variant, particleBlock,
            FabricBlockSettings.create()
                .breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY)
                .sounds(BlockSoundGroup.WOOL)
                .instrument(Instrument.CUSTOM_HEAD)
        )
    }
    private fun register(id: String, block: Block): Block {
        return Registry.register(Registries.BLOCK, Identifier(HybridAquatic.MOD_ID, id), block)
    }

    /**
     * Adds [addedBlocks] to the supported blocks list of a block entity type.
     */
    fun <T : BlockEntity> BlockEntityType<T>.addBlocks(vararg addedBlocks: Block) {
        if (blocks !is ImmutableSet) {
            blocks.addAll(addedBlocks)
        } else {
            blocks = blocks.toMutableSet().apply {
                addAll(addedBlocks)
            }
        }
    }
}
