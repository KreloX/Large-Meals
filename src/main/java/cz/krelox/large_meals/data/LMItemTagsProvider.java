package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.item.LMItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LMItemTagsProvider extends ItemTagsProvider {
    public LMItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LargeMeals.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED).add(LMItems.OMURICE_BLOCK.get(), LMItems.MUSHROOM_POT_PIE_BLOCK.get(), LMItems.ROASTED_MUTTON_RACK_BLOCK.get());
    }
}
