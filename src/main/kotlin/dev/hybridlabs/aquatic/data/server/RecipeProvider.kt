package dev.hybridlabs.aquatic.data.server

import dev.hybridlabs.aquatic.item.HybridAquaticItems
import dev.hybridlabs.aquatic.tag.HybridAquaticItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.block.Blocks
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.tag.ItemTags
import java.util.function.Consumer

class RecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {
    override fun generate(exporter: Consumer<RecipeJsonProvider>) {
        // misc recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.SPONGE)
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .input('S', HybridAquaticItems.SPONGE_CHUNK)
            .criterion("has_sponge_chunk", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.SPONGE_CHUNK))
            .offerTo(exporter)

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, HybridAquaticItems.BUOY)
            .pattern(" L ")
            .pattern(" S ")
            .pattern(" W ")
            .input('S', Items.STICK)
            .input('L', Items.LANTERN)
            .input('W', ItemTags.PLANKS)
            .criterion("has_lantern", InventoryChangedCriterion.Conditions.items(Items.LANTERN))
            .offerTo(exporter)

        // hook recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HybridAquaticItems.BARBED_HOOK)
            .pattern("N  ")
            .pattern("N N")
            .pattern("NNN")
            .input('N', Items.IRON_NUGGET)
            .criterion("has_iron_nugget", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
            .offerTo(exporter)

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HybridAquaticItems.MAGNETIC_HOOK)
            .pattern("NIN")
            .pattern("N N")
            .pattern("I I")
            .input('N', Items.IRON_NUGGET)
            .input('I', Items.IRON_INGOT)
            .criterion("has_iron_nugget", InventoryChangedCriterion.Conditions.items(Items.IRON_NUGGET))
            .offerTo(exporter)

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, HybridAquaticItems.FISHING_NET)
            .pattern("  S")
            .pattern(" IS")
            .pattern("I  ")
            .input('I', Items.STICK)
            .input('S', Items.STRING)
            .criterion("string", InventoryChangedCriterion.Conditions.items(Items.STRING))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, HybridAquaticItems.GLOWING_HOOK)
            .input(HybridAquaticItems.BARBED_HOOK)
            .input(HybridAquaticItems.GLOW_SLIME)
            .criterion("has_barbed_hook", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.BARBED_HOOK))
            .criterion("has_glow_slime", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.GLOW_SLIME))
            .offerTo(exporter)

        // food items
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HybridAquaticItems.RAW_CRAB)
            .input(HybridAquaticItemTags.CRAB_CLAW)
            .criterion("has_crab_claw", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.DUNGENESS_CRAB_CLAW))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HybridAquaticItems.RAW_LOBSTER)
            .input(HybridAquaticItems.LOBSTER_CLAW)
            .criterion("has_lobster_claw", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.LOBSTER_CLAW))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HybridAquaticItems.RAW_FISH_MEAT, 1)
            .input(HybridAquaticItemTags.SMALL_FISH)
            .criterion("has_fish_meat", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.RAW_FISH_MEAT))
            .offerTo(exporter)

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, HybridAquaticItems.RAW_FISH_STEAK, 1)
            .input(HybridAquaticItemTags.MEDIUM_FISH)
            .criterion("has_fish_meat", InventoryChangedCriterion.Conditions.items(HybridAquaticItems.RAW_FISH_STEAK))
            .offerTo(exporter)

        // cooking recipes
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_CRAB, HybridAquaticItems.COOKED_CRAB, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_SHRIMP, HybridAquaticItems.COOKED_SHRIMP, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_CRAYFISH, HybridAquaticItems.COOKED_CRAYFISH, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_LOBSTER, HybridAquaticItems.COOKED_LOBSTER, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_FISH_STEAK, HybridAquaticItems.COOKED_FISH_STEAK, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_FISH_MEAT, HybridAquaticItems.COOKED_FISH_MEAT, 0.15f)
        offerCookingRecipes(exporter, HybridAquaticItems.RAW_TENTACLE, HybridAquaticItems.COOKED_TENTACLE, 0.15f)
    }
    private fun offerCookingRecipes(
        exporter: Consumer<RecipeJsonProvider>,
        input: Item,
        output: Item,
        experience: Float
    ) {
        offerFoodCookingRecipe(exporter, "smelting", RecipeSerializer.SMELTING, 200, input, output, experience)
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 100, input, output, experience)
        offerFoodCookingRecipe(
            exporter,
            "campfire_cooking",
            RecipeSerializer.CAMPFIRE_COOKING,
            600,
            input,
            output,
            experience
        )
    }
}
