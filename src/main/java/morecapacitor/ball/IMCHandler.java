package morecapacitor.ball;

import net.minecraftforge.fml.common.event.FMLInterModComms;
public class IMCHandler {
    public static void sendIMCs(){
        FMLInterModComms.sendMessage("enderio", "recipe:xml",
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?><recipes>"
                        + "<grindingball name=\"Singularity Ball\" grinding=\"3.0\" chance=\"3.0\" power=\"1.30\" durability=\"300000\" >"
                        + "<item name=\"morecapacitor:singularity_alloy_ball\"/>"
                        + "</grindingball></recipes>");
    }
}
