package cz.krelox.large_meals;

import cz.krelox.large_meals.block.LMBlocks;
import cz.krelox.large_meals.data.*;
import cz.krelox.large_meals.data.loot.LMBlockLoot;
import cz.krelox.large_meals.item.LMItems;
import net.minecraft.DetectedVersion;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Mod(LargeMeals.MOD_ID)
public class LargeMeals {
    public static final String MOD_ID = "large_meals";

    public LargeMeals(IEventBus modEventBus) {
        modEventBus.addListener(this::dataSetup);

        LMItems.ITEMS.register(modEventBus);
        LMBlocks.BLOCKS.register(modEventBus);
    }

    public void dataSetup(GatherDataEvent event) {
        var generator = event.getGenerator();
        var fileHelper = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();
        var packOutput = generator.getPackOutput();

        Consumer<DataProvider> client = provider -> generator.addProvider(event.includeClient(), provider);
        Consumer<DataProvider> server = provider -> generator.addProvider(event.includeServer(), provider);

        // Client Data
        client.accept(new LMBlockStateProvider(packOutput, fileHelper));
        client.accept(new LMItemModelProvider(packOutput, fileHelper));
        client.accept(new LMLanguageProvider(packOutput));

        // Server Data
        server.accept(new LMRecipeProvider(packOutput, lookupProvider));
        server.accept(new LootTableProvider(packOutput, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(LMBlockLoot::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
        server.accept(new LMLootModifierProvider(packOutput, lookupProvider));
        var blockTags = new LMBlockTagsProvider(packOutput, lookupProvider, fileHelper);
        server.accept(blockTags);
        server.accept(new LMItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));

        // pack.mcmeta
        generator.addProvider(true, new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.translatable("pack.large_meals.mod.description"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
                Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE)))));
    }
}
