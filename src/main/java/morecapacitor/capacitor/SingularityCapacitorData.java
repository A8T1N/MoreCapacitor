package morecapacitor.capacitor;


import crazypants.enderio.api.capacitor.CapacitorKeyType;
import crazypants.enderio.api.capacitor.ICapacitorData;
import crazypants.enderio.api.capacitor.ICapacitorKey;

import javax.annotation.Nonnull;

public class SingularityCapacitorData implements ICapacitorData {

    public static final SingularityCapacitorData instance = new SingularityCapacitorData();
//        public static float globalLevel = Float.MAX_VALUE;
    public static float globalLevel = 10;
    private SingularityCapacitorData() {
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
