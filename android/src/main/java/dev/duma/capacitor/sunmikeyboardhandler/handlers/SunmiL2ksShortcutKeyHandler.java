package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiL2ksShortcutKeyHandler extends AbstractSingleKeyHandler {
    @Override
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.L2ks_Shortcut;
    }

    public SunmiL2ksShortcutKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return device.getVendorId() == 1 && device.getProductId() == 1 && device.getName().contains("gpio_keys");
    }

    @Override
    protected HandleableKeyEnum getHandleableKey(KeyEvent event) {
        if(event.getKeyCode() != 299)
            return null;

        return provides();
    }
}