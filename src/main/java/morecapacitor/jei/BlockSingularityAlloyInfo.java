package morecapacitor.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import morecapacitor.MoreCapacitor;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class BlockSingularityAlloyInfo implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        // Singularity Alloy Blockにビーコン基盤の情報を追加
        registry.addIngredientInfo(
                new ItemStack(MoreCapacitor.SINGULARITY_ALLOY_BLOCK),
                ItemStack.class,
                "jei.morecapacitor.singularity_alloy_block.info"
        );
    }
}