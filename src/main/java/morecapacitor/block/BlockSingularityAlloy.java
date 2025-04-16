package morecapacitor.block;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BlockSingularityAlloy extends Block {
    public BlockSingularityAlloy(){
        super(Material.IRON);
        this.setHardness(50.0f);
        this.setResistance(6000);
        this.setSoundType(SoundType.METAL);

        this.setRegistryName("singularity_alloy_block");
        this.setTranslationKey(Tags.MODID + ".singularity_alloy_block");
        this.setCreativeTab(EnderIOTab.tabEnderIOMaterials);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beaconPos) {
        return true; // ビーコンの基盤として有効
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, @Nullable World worldIn, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag flagIn) {
        tooltip.add(I18n.format("tile.morecapacitor.singularity_alloy_block.tooltip"));
    }
}
