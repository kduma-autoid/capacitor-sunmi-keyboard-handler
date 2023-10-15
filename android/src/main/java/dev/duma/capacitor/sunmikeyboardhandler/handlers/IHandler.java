package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.EnumSet;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.ModifierKeyEnum;

public interface IHandler {
    boolean canBeHandled(KeyEvent event, EnumSet<HandleableKeyEnum> handledKeys);
    boolean handle(KeyEvent event);

    interface Callback {
        default void onKeyPressed(HandleableKeyEnum key, boolean pressed) {
            onKeyPressed(key, pressed, new ArrayList<>());
        }

        void onKeyPressed(HandleableKeyEnum key, boolean pressed, ArrayList<ModifierKeyEnum> modifiers);
        void onBarcodeScanned(String barcode, String device, int id);
        void onDebug(KeyEvent event);
    }
}
