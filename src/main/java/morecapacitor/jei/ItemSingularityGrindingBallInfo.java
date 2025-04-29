package morecapacitor.jei;

import crazypants.enderio.base.lang.Lang;
import crazypants.enderio.base.recipe.sagmill.GrindingBall;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import morecapacitor.MoreCapacitor;
import morecapacitor.ball.ItemSingularityGrindingBall;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class ItemSingularityGrindingBallInfo  implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        // Singularity Alloy Blockにビーコン基盤の情報を追加
        registry.addIngredientInfo(
                new ItemStack(MoreCapacitor.SINGULARITY_ALLOY_BALL),
                ItemStack.class,
                "jei.morecapacitor.singularity_alloy_ball.info",
                "jei.morecapacitor.singularity_alloy_ball.info1",
                "jei.morecapacitor.singularity_alloy_ball.info2",
                "jei.morecapacitor.singularity_alloy_ball.info3",
                "jei.morecapacitor.singularity_alloy_ball.info4"
        );
    }
}
