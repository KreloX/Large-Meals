package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static cz.krelox.large_meals.item.LMItems.*;

public class LMLanguageProvider extends LanguageProvider {
    public LMLanguageProvider(PackOutput output) {
        super(output, LargeMeals.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(RAW_MUTTON_RACK, "Raw Rack of Mutton");
        addItem(COOKED_MUTTON_RACK, "Cooked Rack of Mutton");

        addItem(PUFFERFISH_BROTH, "Pufferfish Broth");
        addItem(POTATO_SOUP, "Potato Soup");
        addItem(RED_SOUP, "Red Soup");
        addItem(TOMATO_EGG_SOUP, "Tomato Egg Soup");

        addItem(COD_DELUXE, "Cod Deluxe");
        addItem(HEARTY_LUNCH, "Hearty Lunch");
        addItem(CHICKEN_CURRY, "Chicken Curry");
        addItem(PASTA_WITH_MUSHROOM_SAUCE, "Pasta with Mushroom Sauce");

        addItem(OMURICE_BLOCK, "Omurice");
        addItem(OMURICE, "Bowl of Omurice");
        addItem(MUSHROOM_POT_PIE_BLOCK, "Mushroom Pot Pie");
        addItem(MUSHROOM_POT_PIE, "Plate of Mushroom Pot Pie");
        addItem(ROASTED_MUTTON_RACK_BLOCK, "Roasted Rack of Mutton");
        addItem(ROASTED_MUTTON_RACK, "Plate of Roasted Rack of Mutton");

        addItem(SWEET_BERRY_CUSTARD, "Sweet Berry Custard");
        addItem(RICE_PUDDING, "Rice Pudding");

        add("large_meals.advancement.get_mutton_rack", "Sheep Butcher");
        add("large_meals.advancement.get_mutton_rack.desc", "Use a Knife to extract Rack from Sheep");

        add("pack.large_meals.mod.description", "Large Meals resources");
    }
}
