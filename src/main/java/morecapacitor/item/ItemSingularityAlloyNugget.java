package morecapacitor.item;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.Tags;
import net.minecraft.item.Item;

public class ItemSingularityAlloyNugget extends Item {
    public ItemSingularityAlloyNugget() {
        this.setRegistryName("singularity_alloy_nugget");
        this.setTranslationKey(Tags.MODID + ".singularity_alloy_nugget");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }
}
