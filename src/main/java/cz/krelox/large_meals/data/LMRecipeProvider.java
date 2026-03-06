package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.item.LMItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class LMRecipeProvider extends RecipeProvider {
    public LMRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(LMItems.RAW_MUTTON_RACK), RecipeCategory.FOOD,
                        LMItems.COOKED_MUTTON_RACK, 0.35F, 200)
                .unlockedBy(getHasName(LMItems.RAW_MUTTON_RACK), has(LMItems.RAW_MUTTON_RACK))
                .save(recipeOutput);
        simpleCookingRecipe(recipeOutput, "smoking", RecipeSerializer.SMOKING_RECIPE,
                SmokingRecipe::new, 100, LMItems.RAW_MUTTON_RACK, LMItems.COOKED_MUTTON_RACK, 0.35F);
        simpleCookingRecipe(recipeOutput, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE,
                CampfireCookingRecipe::new, 600, LMItems.RAW_MUTTON_RACK, LMItems.COOKED_MUTTON_RACK, 0.35F);

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(LMItems.RAW_MUTTON_RACK),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.MUTTON_CHOPS.get(), 4)
                .save(recipeOutput);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(LMItems.COOKED_MUTTON_RACK),
                        Ingredient.of(CommonTags.TOOLS_KNIFE), ModItems.COOKED_MUTTON_CHOPS.get(), 4)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.PUFFERFISH_BROTH, 1, 200, 1.0F)
                .addIngredient(Items.PUFFERFISH)
                .addIngredient(Items.POTATO)
                .addIngredient(Items.BEETROOT)
                .addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .unlockedByAnyIngredient(Items.PUFFERFISH, Items.POTATO, Items.BEETROOT, ModItems.ONION.get(),
                        ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.POTATO_SOUP, 1, 200, 1.0F)
                .addIngredient(Items.POTATO, 2)
                .addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .unlockedByAnyIngredient(Items.POTATO, ModItems.ONION.get(), ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.RED_SOUP, 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_TOMATO)
                .addIngredient(Items.BEETROOT)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(ModItems.TOMATO.get(), Items.BEETROOT, ModItems.ONION.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.TOMATO_EGG_SOUP, 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_TOMATO)
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(ModItems.TOMATO.get(), Items.EGG, ModItems.ONION.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.COD_DELUXE, 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_RAW_COD)
                .addIngredient(Items.BEETROOT)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(CommonTags.FOODS_TOMATO)
                .unlockedByAnyIngredient(Items.COD, Items.BEETROOT, ModItems.RICE.get(), ModItems.TOMATO.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.HEARTY_LUNCH, 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_RAW_BACON)
                .addIngredient(CommonTags.FOODS_RAW_BACON)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(CommonTags.FOODS_CABBAGE)
                .addIngredient(Items.CARROT)
                .addIngredient(CommonTags.FOODS_ONION)
                .unlockedByAnyIngredient(ModItems.BACON.get(), ModItems.RICE.get(), ModItems.CABBAGE.get(),
                        ModItems.CABBAGE_LEAF.get(), Items.CARROT, ModItems.ONION.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.CHICKEN_CURRY, 1, 200, 1.0F)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .unlockedByAnyIngredient(Items.CHICKEN, ModItems.CHICKEN_CUTS.get(), ModItems.ONION.get(),
                        ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET, ModItems.TOMATO_SAUCE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.PASTA_WITH_MUSHROOM_SAUCE, 1, 200, 1.0F)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(Items.BROWN_MUSHROOM)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(CommonTags.FOODS_ONION)
                .addIngredient(CommonTags.FOODS_PASTA)
                .unlockedByAnyIngredient(Items.BROWN_MUSHROOM, ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET,
                        ModItems.ONION.get(), ModItems.RAW_PASTA.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.OMURICE_BLOCK, 1, 250, 1.5F)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(Items.CARROT)
                .addIngredient(CommonTags.FOODS_CABBAGE)
                .unlockedByAnyIngredient(ModItems.RICE.get(), Items.CHICKEN, ModItems.CHICKEN_CUTS.get(), Items.EGG,
                        ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET, Items.CARROT, ModItems.CABBAGE.get(), ModItems.CABBAGE_LEAF.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.MUSHROOM_POT_PIE_BLOCK, 1, 250, 1.5F)
                .addIngredient(ModItems.BROWN_MUSHROOM_COLONY.get())
                .addIngredient(CommonTags.FOODS_RAW_CHICKEN)
                .addIngredient(Items.CARROT)
                .addIngredient(CommonTags.FOODS_CABBAGE)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(ModItems.PIE_CRUST.get())
                .unlockedByAnyIngredient(ModItems.BROWN_MUSHROOM_COLONY.get(), Items.CHICKEN, ModItems.CHICKEN_CUTS.get(), Items.CARROT,
                        ModItems.CABBAGE.get(), ModItems.CABBAGE_LEAF.get(), ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET, ModItems.PIE_CRUST.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LMItems.ROASTED_MUTTON_RACK_BLOCK)
                .requires(ModItems.COOKED_RICE.get(), 3)
                .requires(Items.CARROT, 2)
                .requires(LMItems.COOKED_MUTTON_RACK)
                .requires(Items.BAKED_POTATO, 2)
                .requires(Items.BOWL)
                .unlockedBy("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item()
                        .of(ModItems.COOKED_RICE.get(), Items.CARROT, LMItems.COOKED_MUTTON_RACK, Items.BOWL).build()))
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.SWEET_BERRY_CUSTARD, 1, 200, 1.0F)
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(Items.SWEET_BERRIES, ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);

        CookingPotRecipeBuilder.cookingPotRecipe(LMItems.RICE_PUDDING, 1, 200, 1.0F)
                .addIngredient(CommonTags.CROPS_RICE)
                .addIngredient(Tags.Items.DRINKS_MILK)
                .addIngredient(Items.SUGAR)
                .unlockedByAnyIngredient(ModItems.RICE.get(), ModItems.MILK_BOTTLE.get(), Items.MILK_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput);
    }

    protected static <T extends AbstractCookingRecipe> void simpleCookingRecipe(
            RecipeOutput recipeOutput, String cookingMethod, RecipeSerializer<T> cookingSerializer,
            AbstractCookingRecipe.Factory<T> recipeFactory, int cookingTime, ItemLike material, ItemLike result, float experience) {
        var builder = SimpleCookingRecipeBuilder.generic(Ingredient.of(material), RecipeCategory.FOOD, result, experience, cookingTime, cookingSerializer, recipeFactory)
                .unlockedBy(getHasName(material), has(material));
        builder.save(recipeOutput, LargeMeals.MOD_ID + ":" + getItemName(result) + "_from_" + cookingMethod);
    }
}
