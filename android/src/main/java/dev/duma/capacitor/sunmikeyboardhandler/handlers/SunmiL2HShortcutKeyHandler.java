package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.KEYCODE_F10;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiL2HShortcutKeyHandler extends AbstractSingleKeyHandler {
    @Override
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.L2H_Shortcut;
    }

    public SunmiL2HShortcutKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return device.getVendorId() == 1 && device.getProductId() == 1 && device.getName().contains("gpio-keys");
    }

    @Override
    protected HandleableKeyEnum getHandleableKey(KeyEvent event) {
        if(event.getKeyCode() != KEYCODE_F10)
            return null;

        return provides();
    }
}