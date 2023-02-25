package dev.duma.capacitor.sunmikeyboardhandler.enums;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum KeyEventEnum implements Labeled {
    KeyDown("KEY_DOWN"),
    KeyUp("KEY_UP");

    private static final Map<String, KeyEventEnum> BY_LABEL = new HashMap<>();

    static {
        for (KeyEventEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public final String label;

    private KeyEventEnum(String label) {
        this.label = label;
    }

    @NonNull
    @Override
    public String label() {
        return label;
    }

    public static KeyEventEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    @NonNull
    @Override
    public String toString() {
        return this.label;
    }
}
