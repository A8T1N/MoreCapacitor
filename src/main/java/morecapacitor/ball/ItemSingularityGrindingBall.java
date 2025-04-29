package morecapacitor.ball;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.Tags;
import net.minecraft.item.Item;

public class ItemSingularityGrindingBall extends Item {
    public ItemSingularityGrindingBall() {
        this.setRegistryName("singularity_alloy_ball");
        this.setTranslationKey(Tags.MODID + ".singularity_alloy_ball");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }
}
