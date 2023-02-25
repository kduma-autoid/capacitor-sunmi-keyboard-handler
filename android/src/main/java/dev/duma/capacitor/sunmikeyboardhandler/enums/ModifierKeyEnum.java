package dev.duma.capacitor.sunmikeyboardhandler.enums;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum ModifierKeyEnum implements Labeled {
    Alt("ALT"),
    Ctrl("CTRL"),
    Shift("SHIFT");

    private static final Map<String, ModifierKeyEnum> BY_LABEL = new HashMap<>();

    static {
        for (ModifierKeyEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public final String label;

    private ModifierKeyEnum(String label) {
        this.label = label;
    }

    @NonNull
    @Override
    public String label() {
        return label;
    }

    public static ModifierKeyEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    @NonNull
    @Override
    public String toString() {
        return this.label;
    }
}
