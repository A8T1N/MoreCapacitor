package morecapacitor;

import com.enderio.core.common.util.NNList;
import crazypants.enderio.base.recipe.*;
import crazypants.enderio.base.recipe.alloysmelter.AlloyRecipeManager;
import net.minecraft.item.ItemStack;

public class ModifiedAlloyRecipes {
    public static void registerModifiedRecipes() {
        // 全レシピを取得
        NNList<IManyToOneRecipe> recipes = AlloyRecipeManager.getInstance().getRecipes();

        for (IManyToOneRecipe recipe : recipes) {
            // レシピデータ取得
            IRecipeInput[] inputsArray = recipe.getInputs();
            NNList<IRecipeInput> inputs = new NNList<>();
            for (IRecipeInput input : inputsArray) {
                inputs.add(input.copy());
            }
            ItemStack outputItem = recipe.getOutputs()[0].getOutput().copy();
            int originalEnergy = recipe.getEnergyRequired();
            float xpChance = recipe.getOutputs()[0].getExperiance();
            RecipeLevel recipeLevel = recipe.getRecipeLevel();
            boolean prohibitDupes = recipe.isDedupeInput();

            // 通常のレシピを登録
            AlloyRecipeManager.getInstance().addRecipe(
                    prohibitDupes,
                    inputs,
                    outputItem,
                    originalEnergy,
                    xpChance,
                    recipeLevel
            );
        }
    }
}