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
                    "To support legacy recipes, setting this to true changes the Singularity Alloy crafting material from Double Compressed Infinity Dust Block to Reinforced Obsidian."
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