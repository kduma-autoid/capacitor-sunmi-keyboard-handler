package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiRfidKeyHandler extends AbstractSingleKeyHandler {
    public SunmiRfidKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        boolean l2kGun = device.getVendorId() == 1 && device.getProductId() == 1 && device.getName().contains("pogo-keys");
        boolean l2sInternal = device.getVendorId() == 9300 && device.getProductId() == 25856 && device.getName().contains("mtk-kpd");

        return l2kGun || l2sInternal;
    }

    @Override
    protected HandleableKeyEnum getHandleableKey(KeyEvent event) {
        if(event.getKeyCode() != 288)
            return null;

        return HandleableKeyEnum.Sunmi_RFID;
    }
}