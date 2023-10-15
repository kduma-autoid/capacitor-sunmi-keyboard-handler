package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;
import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiL2sShortcutKeyHandler  extends AbstractSingleKeyHandler {
    public SunmiL2sShortcutKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return device.getVendorId() == 9300 && device.getProductId() == 25856 && device.getName().contains("mtk-kpd");
    }

    @Override
    protected HandleableKeyEnum getHandleableKey(KeyEvent event) {
        if(event.getKeyCode() != KEYCODE_F11)
            return null;

        return HandleableKeyEnum.L2s_Shortcut;
    }
}