package cz.krelox.large_meals.block;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.item.LMItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LMBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LargeMeals.MOD_ID);

    // Feasts
    public static final DeferredBlock<OmuriceBlock> OMURICE_BLOCK = BLOCKS.register("omurice_block",
            () -> new OmuriceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), LMItems.OMURICE::get, true));
    public static final DeferredBlock<MushroomPotPieBlock> MUSHROOM_POT_PIE_BLOCK = BLOCKS.register("mushroom_pot_pie_block",
            () -> new MushroomPotPieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), LMItems.MUSHROOM_POT_PIE::get, true));
    public static final DeferredBlock<RoastedMuttonRackBlock> ROASTED_MUTTON_RACK_BLOCK = BLOCKS.register("roasted_mutton_rack_block",
            () -> new RoastedMuttonRackBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), LMItems.ROASTED_MUTTON_RACK::get, true));

    private LMBlocks() {
    }
}
