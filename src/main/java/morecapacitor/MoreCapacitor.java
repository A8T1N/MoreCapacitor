package morecapacitor;

import crazypants.enderio.base.EnderIOTab;
import morecapacitor.block.BlockSingularityAlloy;
import morecapacitor.capacitor.ItemCreativeCapacitor;
import morecapacitor.capacitor.ItemSingularityCapacitor;
import morecapacitor.item.ItemSingularityAlloyIngot;
import morecapacitor.item.ItemSingularityAlloyNugget;
import morecapacitor.recipe.alloyrecipe.RecipeSingularityAlloyIngot;
import morecapacitor.recipe.sliceandsplice.RecipeSingularityCapacitor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.12.2]",dependencies = "required-after:enderioendergy;required-after:enderio")
public class MoreCapacitor {
    public static final Logger LOGGER = LogManager.getLogger(Tags.MODID);
    public static CreativeTabs materialsTab;
    public static final Item CAPACITOR_SINGULARITY = new ItemSingularityCapacitor();
    public static final Item SINGULARITY_ALLOY_INGOT = new ItemSingularityAlloyIngot();
    public static final Item SINGULARITY_ALLOY_NUGGET = new ItemSingularityAlloyNugget();

    public static final Block SINGULARITY_ALLOY_BLOCK = new BlockSingularityAlloy();
    public static final Item ITEM_SINGULARITY_ALLOY_BLOCK = new ItemBlock(SINGULARITY_ALLOY_BLOCK).setRegistryName(SINGULARITY_ALLOY_BLOCK.getRegistryName());

    public static final Item CREATIVE_CAPACITOR = new ItemCreativeCapacitor();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // register to the event bus so that we can listen to events
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);
    }

    @SubscribeEvent
    // Register recipes here (Remove if not needed)
    public void registerRecipes(RegistryEvent.Register<IRecipe> event) {

    }

    @SubscribeEvent
    // Register items here (Remove if not needed)
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                ITEM_SINGULARITY_ALLOY_BLOCK,
                SINGULARITY_ALLOY_INGOT,
                SINGULARITY_ALLOY_NUGGET,
                CAPACITOR_SINGULARITY,
                CREATIVE_CAPACITOR
        );
    }

    public static void registerItem(Item item, String name, IForgeRegistry<Item> registry) {
        // Ender IOのクリエイティブタブを適用
        registry.register(item.setRegistryName(name).setTranslationKey(Objects.requireNonNull(item.getRegistryName()).toString()));
//                .setCreativeTab(EnderIOTab.tabEnderIOMaterials));
    }


    @SubscribeEvent
    // Register blocks here (Remove if not needed)
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                SINGULARITY_ALLOY_BLOCK
        );
    }

    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        RecipeSingularityCapacitor.registerRecipes();
        RecipeSingularityAlloyIngot.registerRecipes();

        OreDictionary.registerOre("ingotSingularityAlloy", new ItemStack(SINGULARITY_ALLOY_INGOT));
        OreDictionary.registerOre("nuggetSingularityAlloy", new ItemStack(SINGULARITY_ALLOY_NUGGET));
        OreDictionary.registerOre("blockSingularityAlloy", new ItemStack(SINGULARITY_ALLOY_BLOCK));
    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
    }

    @EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ITEM_SINGULARITY_ALLOY_BLOCK, 0, new ModelResourceLocation(new ResourceLocation(Tags.MODID, "singularity_alloy_block"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(SINGULARITY_ALLOY_INGOT, 0, new ModelResourceLocation(new ResourceLocation(Tags.MODID, "singularity_alloy_ingot"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(SINGULARITY_ALLOY_NUGGET, 0, new ModelResourceLocation(new ResourceLocation(Tags.MODID, "singularity_alloy_nugget"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(CAPACITOR_SINGULARITY, 0, new ModelResourceLocation(new ResourceLocation(Tags.MODID, "capacitor_singularity"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(CREATIVE_CAPACITOR, 0, new ModelResourceLocation(new ResourceLocation(Tags.MODID, "capacitor_creative"), "inventory"));
    }
}
