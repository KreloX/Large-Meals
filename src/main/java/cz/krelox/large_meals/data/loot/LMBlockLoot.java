package cz.krelox.large_meals.data.loot;

import cz.krelox.large_meals.block.LMBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LMBlockLoot extends BlockLootSubProvider {
    public LMBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(LMBlocks.OMURICE_BLOCK.get(), this::createFeastDrops);
        add(LMBlocks.MUSHROOM_POT_PIE_BLOCK.get(), this::createFeastDrops);
        add(LMBlocks.ROASTED_MUTTON_RACK_BLOCK.get(), this::createFeastDrops);
    }

    public LootTable.Builder createFeastDrops(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name("pool1").setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FeastBlock.SERVINGS, 4))))
                .withPool(LootPool.lootPool().name("pool2").setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(Items.BOWL))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FeastBlock.SERVINGS, 4))
                                .invert()));
    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return LMBlocks.BLOCKS.getEntries().stream().map(Supplier::get).collect(Collectors.toList());
    }
}
