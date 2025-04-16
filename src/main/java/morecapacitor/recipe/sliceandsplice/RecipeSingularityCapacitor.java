package morecapacitor.recipe.sliceandsplice;

import crazypants.enderio.base.recipe.*;
import crazypants.enderio.base.recipe.slicensplice.SliceAndSpliceRecipeManager;
import morecapacitor.MoreCapacitor;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeSingularityCapacitor {
    public static void registerRecipes() {

        ItemStack singularityIngot = new ItemStack(Item.getByNameOrId("morecapacitor:singularity_alloy_ingot"), 1);
        ItemStack capacitorStellar = new ItemStack(Item.getByNameOrId("enderio:item_capacitor_stellar"), 1);
        ItemStack dragonBreath = new ItemStack(Items.DRAGON_BREATH, 1);
        ItemStack enderCrystalPowder = new ItemStack(Item.getByNameOrId("enderio:item_material"), 1, 37);
        ItemStack precientPowder = new ItemStack(Item.getByNameOrId("enderio:item_material"), 1, 34);


        IRecipeInput[] inputs = new IRecipeInput[]{
                new RecipeInput(singularityIngot, true),
                new RecipeInput(dragonBreath, true),
                new RecipeInput(singularityIngot, true),
                new RecipeInput(enderCrystalPowder, true),
                new RecipeInput(capacitorStellar, true),
                new RecipeInput(precientPowder, true),
        };

        ItemStack outputItem = new ItemStack(MoreCapacitor.CAPACITOR_SINGULARITY);
        RecipeOutput[] outputs = new RecipeOutput[]{new RecipeOutput(outputItem, 1.0f, 0.5f)};

        Recipe recipe = new Recipe(
                inputs,
                outputs,
                500000,
                RecipeBonusType.NONE,
                RecipeLevel.ADVANCED
        );

        SliceAndSpliceRecipeManager.getInstance().addRecipe(recipe);
    }
}