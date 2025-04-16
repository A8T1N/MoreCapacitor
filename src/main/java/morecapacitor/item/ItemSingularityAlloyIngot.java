package morecapacitor.item;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.Tags;
import net.minecraft.item.Item;

public class ItemSingularityAlloyIngot extends Item {
    public ItemSingularityAlloyIngot() {
        this.setRegistryName("singularity_alloy_ingot");
        this.setTranslationKey(Tags.MODID + ".singularity_alloy_ingot");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }
}
