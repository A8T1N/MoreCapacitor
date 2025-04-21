package morecapacitor.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class MoreCapacitorConfig {
    public static Configuration config;
    public static boolean legacyRecipeSupport = false; // デフォルトは false

    public static void init(File configFile) {
        config = new Configuration(configFile);
        try {
            config.load();
            legacyRecipeSupport = config.getBoolean(
                    "LegacyRecipeSupport",
                    "recipes",
                    false,
                    "Changed the Singularity Alloy crafting material from DoubleCompressedInfinityDustBlock to ReinforcedObsidian to support legacy recipes."
            );
        } catch (Exception e) {
            System.err.println("Error loading MoreCapacitor config: " + e.getMessage());
        } finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }
}