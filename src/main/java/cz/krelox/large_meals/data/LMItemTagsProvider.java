package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

import static cz.krelox.large_meals.item.LMItems.*;

public class LMItemTagsProvider extends ItemTagsProvider {
    public LMItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LargeMeals.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.MEALS).add(COD_DELUXE.get(), HEARTY_LUNCH.get(), CHICKEN_CURRY.get(), PASTA_WITH_MUSHROOM_SAUCE.get());
        tag(ModTags.SWEETS).add(SWEET_BERRY_CUSTARD.get(), RICE_PUDDING.get());
        tag(ModTags.FEASTS).add(OMURICE_BLOCK.get(), MUSHROOM_POT_PIE_BLOCK.get(), ROASTED_MUTTON_RACK_BLOCK.get());

        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED).add(OMURICE_BLOCK.get(), MUSHROOM_POT_PIE_BLOCK.get(), ROASTED_MUTTON_RACK_BLOCK.get());
        tag(Tags.Items.FOODS_SOUP).add(PUFFERFISH_BROTH.get(), POTATO_SOUP.get(), RED_SOUP.get(), TOMATO_EGG_SOUP.get());
        tag(Tags.Items.FOODS_PIE).add(MUSHROOM_POT_PIE.get());
    }
}
