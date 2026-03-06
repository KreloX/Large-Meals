package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.item.LMItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class LMItemModelProvider extends ItemModelProvider {
    public LMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LargeMeals.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        LMItems.ITEMS.getEntries().forEach(itemDeferredHolder -> basicItem(itemDeferredHolder.get()));
    }
}
