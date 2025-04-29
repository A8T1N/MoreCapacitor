package morecapacitor.recipe.alloyrecipe;

import com.enderio.core.common.util.NNList;
import crazypants.enderio.base.recipe.IRecipeInput;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.alloysmelter.AlloyRecipeManager;
import morecapacitor.MoreCapacitor;
import morecapacitor.config.MoreCapacitorConfig;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class RecipeSingularityAlloyIngot {
    public static void registerRecipes() {
        ItemStack doubleCompressedInfinityDustBlock = new ItemStack(Item.getByNameOrId("enderio:block_infinity"), 2, 2);
        ItemStack reinforcedObsidianBlock = new ItemStack(Item.getByNameOrId("enderio:block_reinforced_obsidian"), 2);
        ItemStack ingotStellar = new ItemStack(Item.getByNameOrId("enderio:item_alloy_endergy_ingot"), 2, 3);
        ItemStack enderEye = new ItemStack(Items.ENDER_EYE, 2);

        ItemStack thirdInput = MoreCapacitorConfig.legacyRecipeSupport ? reinforcedObsidianBlock : doubleCompressedInfinityDustBlock;

        NNList<IRecipeInput> inputs = new NNList<>(
                new RecipeInput(enderEye, true),
                new RecipeInput(ingotStellar, true),
//                new RecipeInput(doubleCompressedInfinityDustBlock, true)
                new RecipeInput(thirdInput, true)
        );

        ItemStack outputItem = new ItemStack(MoreCapacitor.SINGULARITY_ALLOY_INGOT, 1);

        AlloyRecipeManager.getInstance().addRecipe(
                true,
                inputs,
                outputItem,
                500000,
                0.5f,
                RecipeLevel.IGNORE
        );
    }
}