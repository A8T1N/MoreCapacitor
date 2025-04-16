package morecapacitor.capacitor;


import crazypants.enderio.api.capacitor.ICapacitorData;
import crazypants.enderio.api.capacitor.ICapacitorKey;

import javax.annotation.Nonnull;

public class CreativeCapacitorData implements ICapacitorData {

    public static final CreativeCapacitorData instance = new CreativeCapacitorData();
    public static float globalLevel = Float.MAX_VALUE;

    private CreativeCapacitorData() {
    }

    @Override
    public float getUnscaledValue(@Nonnull ICapacitorKey key) {
        return globalLevel;
    }

    @Nonnull
    @Override
    public String getUnlocalizedName() {
        return "none";
    }

    @Nonnull
    @Override
    public String getLocalizedName() {
        return "none";
    }


}
