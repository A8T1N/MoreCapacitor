package morecapacitor.ball;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.Tags;
import net.minecraft.item.Item;

public class ItemGrindingBallSingularity  extends Item {
    public ItemGrindingBallSingularity() {
        this.setRegistryName("singularity_alloy_ball");
        this.setTranslationKey(Tags.MODID + ".singularity_alloy_ball");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }
}
