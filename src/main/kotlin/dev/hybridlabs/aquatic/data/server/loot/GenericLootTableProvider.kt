package dev.hybridlabs.aquatic.data.server.loot

import dev.hybridlabs.aquatic.item.HybridAquaticItems
import dev.hybridlabs.aquatic.loot.HybridAquaticLootTables
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.context.LootContextTypes
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.Identifier
import java.util.function.BiConsumer

class GenericLootTableProvider(output: FabricDataOutput) : SimpleFabricLootTableProvider(output, LootContextTypes.GENERIC) {
    override fun accept(exporter: BiConsumer<Identifier, LootTable.Builder>) {
        exporter.accept(
            HybridAquaticLootTables.CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.COCOA_BEANS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )
        exporter.accept(
            HybridAquaticLootTables.OAK_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.OAK_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.OAK_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.OAK_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.ROSE_BUSH)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILAC)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.PEONY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILY_OF_THE_VALLEY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.ALLIUM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.POPPY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.DANDELION)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.AZURE_BLUET)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.SPRUCE_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.SPRUCE_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.SPRUCE_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.SPRUCE_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LARGE_FERN)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.FERN)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.RED_MUSHROOM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.BROWN_MUSHROOM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.SWEET_BERRIES)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.BIRCH_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.BIRCH_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.BIRCH_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.BIRCH_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.ROSE_BUSH)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.PEONY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILAC)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILY_OF_THE_VALLEY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.BROWN_MUSHROOM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.DARK_OAK_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.DARK_OAK_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.DARK_OAK_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.DARK_OAK_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.ROSE_BUSH)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.PEONY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILAC)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILY_OF_THE_VALLEY)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.BROWN_MUSHROOM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.RED_MUSHROOM)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.MANGROVE_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.MANGROVE_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.MANGROVE_PROPAGULE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.MANGROVE_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.LILY_PAD)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.FERN)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.MOSS_BLOCK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.CHERRY_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.CHERRY_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.CHERRY_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.CHERRY_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.PINK_PETALS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.JUNGLE_CRATE_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.JUNGLE_CRATE_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.JUNGLE_SAPLING)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.JUNGLE_LOG)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0f, 16.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.VINE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.FERN)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.COCOA_BEANS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.BAMBOO)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.MELON_SLICE)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0f, 8.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.HYDROTHERMAL_VENT_LOOT_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.HYDROTHERMAL_VENT_LOOT_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(Items.RAW_COPPER)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)))
                        )
                        .with(
                            ItemEntry.builder(Items.RAW_IRON)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)))
                            )
                        .with(
                            ItemEntry.builder(Items.RAW_GOLD)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                            )
                        )
                    )

        exporter.accept(
            HybridAquaticLootTables.TUBE_SPONGE_LOOT_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.TUBE_SPONGE_LOOT_ID)
                .pool(
                    LootPool.builder()
                        .with(
                            ItemEntry.builder(HybridAquaticItems.SPONGE_CHUNK)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                        )
                )
        )

        exporter.accept(
            HybridAquaticLootTables.CRAB_DIGGING_TREASURE_ID,
            LootTable.builder()
                .randomSequenceId(HybridAquaticLootTables.CRAB_DIGGING_TREASURE_ID)
                .pool(
                    LootPool.builder()
                        .with(ItemEntry.builder(Items.AIR).weight(10))
                        .with(ItemEntry.builder(Items.NAUTILUS_SHELL).weight(2))
                        .with(ItemEntry.builder(Items.GOLD_NUGGET).weight(3))
                        .with(ItemEntry.builder(Items.IRON_NUGGET).weight(5))
                )
        )
    }
}
