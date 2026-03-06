package cz.krelox.large_meals.data;

import cz.krelox.large_meals.LargeMeals;
import cz.krelox.large_meals.block.LMBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class LMBlockStateProvider extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public LMBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LargeMeals.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        feastBlock(LMBlocks.OMURICE_BLOCK);
        feastBlock(LMBlocks.MUSHROOM_POT_PIE_BLOCK);
        feastBlock(LMBlocks.ROASTED_MUTTON_RACK_BLOCK);
    }

    public void feastBlock(DeferredBlock<? extends FeastBlock> deferredBlock) {
        var block = deferredBlock.get();
        getVariantBuilder(block).forAllStates(state -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = state.getValue(servingsProperty);

            String suffix = "_stage" + (block.getMaxServings() - servings);

            if (servings == 0) {
                suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
            }

            return ConfiguredModel.builder()
                    .modelFile(models().getExistingFile(deferredBlock.getId().withSuffix(suffix)))
                    .rotationY(((int) state.getValue(FeastBlock.FACING).toYRot() + DEFAULT_ANGLE_OFFSET) % 360)
                    .build();
        });
    }
}
