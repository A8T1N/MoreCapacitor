package morecapacitor.recipe.alloyrecipe;

import com.enderio.core.common.util.NNList;
import crazypants.enderio.base.recipe.IRecipeInput;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.alloysmelter.AlloyRecipeManager;
import morecapacitor.MoreCapacitor;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;


public class RecipeSingularityAlloyIngot {
    public static void registerRecipes() {
        ItemStack doubleCompressedInfinityDustBlcok = new ItemStack(Item.getByNameOrId("enderio:block_infinity"), 2, 2);
        ItemStack ingotStellar = new ItemStack(Item.getByNameOrId("enderio:item_alloy_endergy_ingot"), 2, 3);

        ItemStack silicon = OreDictionary.getOres("itemSilicon").isEmpty()
                ? ItemStack.EMPTY
                : OreDictionary.getOres("itemSilicon").get(0);
        silicon.setCount(4);

        ItemStack enderEye = new ItemStack(Items.ENDER_EYE,2);

        NNList<IRecipeInput> inputs = new NNList<>(
                new RecipeInput(enderEye, true),
                new RecipeInput(ingotStellar, true),
                new RecipeInput(doubleCompressedInfinityDustBlcok, true)
        );

        ItemStack outputItem = new ItemStack(MoreCapacitor.SINGULARITY_ALLOY_INGOT,1);

        AlloyRecipeManager.getInstance().addRecipe(
                true,
                inputs,
                outputItem,
                500000,
                0.5f,
                RecipeLevel.ADVANCED
        );
    }
}