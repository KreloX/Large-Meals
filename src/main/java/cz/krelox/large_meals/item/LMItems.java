package cz.krelox.large_meals.item;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.block.LMBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.function.Supplier;

import static vectorwing.farmersdelight.common.FoodValues.*;
import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class LMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LargeMeals.MOD_ID);

    public static <I extends Item> DeferredItem<I> registerWithTab(String name, Supplier<I> supplier) {
        var item = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(item::get);
        return item;
    }

    // Foodstuffs
    public static final DeferredItem<Item> RAW_MUTTON_RACK = registerWithTab("raw_mutton_rack",
            () -> new Item(foodItem(FoodValues.RAW_MUTTON_RACK)));
    public static final DeferredItem<Item> COOKED_MUTTON_RACK = registerWithTab("cooked_mutton_rack",
            () -> new Item(foodItem(FoodValues.COOKED_MUTTON_RACK)));

    // Soups and Stews
    public static final DeferredItem<ConsumableItem> PUFFERFISH_BROTH = registerWithTab("pufferfish_broth",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.PUFFERFISH_BROTH), true));
    public static final DeferredItem<ConsumableItem> POTATO_SOUP = registerWithTab("potato_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.POTATO_SOUP), true));
    public static final DeferredItem<ConsumableItem> RED_SOUP = registerWithTab("red_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.RED_SOUP), true));
    public static final DeferredItem<ConsumableItem> TOMATO_EGG_SOUP = registerWithTab("tomato_egg_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.TOMATO_EGG_SOUP), true));

    // Plated Meals
    public static final DeferredItem<ConsumableItem> COD_DELUXE = registerWithTab("cod_deluxe",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.COD_DELUXE), true));
    public static final DeferredItem<ConsumableItem> HEARTY_LUNCH = registerWithTab("hearty_lunch",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.HEARTY_LUNCH), true));
    public static final DeferredItem<ConsumableItem> CHICKEN_CURRY = registerWithTab("chicken_curry",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.CHICKEN_CURRY), true));
    public static final DeferredItem<ConsumableItem> PASTA_WITH_MUSHROOM_SAUCE = registerWithTab("pasta_with_mushroom_sauce",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.PASTA_WITH_MUSHROOM_SAUCE), true));

    // Feasts
    public static final DeferredItem<BlockItem> OMURICE_BLOCK = registerWithTab("omurice_block",
            () -> new BlockItem(LMBlocks.OMURICE_BLOCK.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<ConsumableItem> OMURICE = registerWithTab("omurice",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.OMURICE), true));
    public static final DeferredItem<BlockItem> MUSHROOM_POT_PIE_BLOCK = registerWithTab("mushroom_pot_pie_block",
            () -> new BlockItem(LMBlocks.MUSHROOM_POT_PIE_BLOCK.get(), basicItem().stacksTo(1)));
    public static final DeferredItem<ConsumableItem> MUSHROOM_POT_PIE = registerWithTab("mushroom_pot_pie",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.MUSHROOM_POT_PIE), true));
    public static final DeferredItem<BlockItem> ROASTED_MUTTON_RACK_BLOCK = registerWithTab("roasted_mutton_rack_block",
            () -> new BlockItem(LMBlocks.ROASTED_MUTTON_RACK_BLOCK.getDelegate().value(), basicItem().stacksTo(1)));
    public static final DeferredItem<ConsumableItem> ROASTED_MUTTON_RACK = registerWithTab("roasted_mutton_rack",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.ROASTED_MUTTON_RACK), true));

    // Sweets
    public static final DeferredItem<ConsumableItem> SWEET_BERRY_CUSTARD = registerWithTab("sweet_berry_custard",
            () -> new ConsumableItem(foodItem(FoodValues.SWEET_BERRY_CUSTARD).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final DeferredItem<ConsumableItem> RICE_PUDDING = registerWithTab("rice_pudding",
            () -> new ConsumableItem(bowlFoodItem(FoodValues.RICE_PUDDING), true));

    public static class FoodValues {
        // Basic Foods
        public static final FoodProperties RAW_MUTTON_RACK = new FoodProperties.Builder()
                .nutrition(5).saturationModifier(0.3f).build();
        public static final FoodProperties COOKED_MUTTON_RACK = new FoodProperties.Builder()
                .nutrition(10).saturationModifier(0.8f).build();

        // Bowl Foods
        public static final FoodProperties PUFFERFISH_BROTH = new FoodProperties.Builder()
                .nutrition(8).saturationModifier(0.7f)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT, SHORT_DURATION, 0), 1.0F).build();
        public static final FoodProperties POTATO_SOUP = new FoodProperties.Builder()
                .nutrition(10).saturationModifier(0.6f)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F).build();
        public static final FoodProperties RED_SOUP = new FoodProperties.Builder()
                .nutrition(10).saturationModifier(0.6f)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F).build();
        public static final FoodProperties TOMATO_EGG_SOUP = new FoodProperties.Builder()
                .nutrition(10).saturationModifier(0.6f)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION, 0), 1.0F).build();

        // Plated Foods
        public static final FoodProperties COD_DELUXE = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 1.0F).build();
        public static final FoodProperties HEARTY_LUNCH = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 1.0F).build();
        public static final FoodProperties CHICKEN_CURRY = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 1.0F).build();
        public static final FoodProperties PASTA_WITH_MUSHROOM_SAUCE = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION, 0), 1.0F).build();

        // Feasts
        public static final FoodProperties OMURICE = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, LONG_DURATION, 0), 1.0F).build();
        public static final FoodProperties MUSHROOM_POT_PIE = new FoodProperties.Builder()
                .nutrition(12).saturationModifier(0.8f)
                .effect(() -> new MobEffectInstance(ModEffects.COMFORT, LONG_DURATION, 0), 1.0F).build();
        public static final FoodProperties ROASTED_MUTTON_RACK = new FoodProperties.Builder()
                .nutrition(14).saturationModifier(0.75f)
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, LONG_DURATION, 0), 1.0F).build();

        // Sweets
        public static final FoodProperties SWEET_BERRY_CUSTARD = new FoodProperties.Builder()
                .nutrition(7).saturationModifier(0.6f).alwaysEdible()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
        public static final FoodProperties RICE_PUDDING = new FoodProperties.Builder()
                .nutrition(7).saturationModifier(0.6f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();

        private FoodValues() {
        }
    }

    private LMItems() {
    }
}
