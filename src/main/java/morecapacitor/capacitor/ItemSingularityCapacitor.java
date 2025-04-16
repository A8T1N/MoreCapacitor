package morecapacitor.capacitor;

import com.enderio.core.client.handlers.SpecialTooltipHandler;
import com.enderio.core.common.CompoundCapabilityProvider;
import crazypants.enderio.api.capacitor.CapabilityCapacitorData;
import crazypants.enderio.base.EnderIOTab;
import crazypants.enderio.base.lang.Lang;
import morecapacitor.Tags;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemSingularityCapacitor extends Item {
    public ItemSingularityCapacitor() {
        this.setRegistryName("capacitor_singularity");
        this.setTranslationKey(Tags.MODID + ".capacitor_singularity");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        ICapabilityProvider capProvider = new ICapabilityProvider() {

            @Override
            public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
                return capability == CapabilityCapacitorData.getCapNN();
            }

            @Nullable
            @Override
            public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
                if (capability == CapabilityCapacitorData.getCapNN()) {
                    return CapabilityCapacitorData.getCapNN().cast(SingularityCapacitorData.instance);
                }
                return null;
            }
        };
        return new CompoundCapabilityProvider(super.initCapabilities(stack, nbt), capProvider);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(Lang.MACHINE_UPGRADE.get());
        if (SpecialTooltipHandler.showAdvancedTooltips()) {
            SpecialTooltipHandler.addDetailedTooltipFromResources(tooltip, Lang.MACHINE_UPGRADE.getKey());
        } else {
            SpecialTooltipHandler.addShowDetailsTooltip(tooltip);
        }
        tooltip.add("Global Level: " + TextFormatting.DARK_PURPLE + TextFormatting.BOLD + SingularityCapacitorData.globalLevel);
    }
}
