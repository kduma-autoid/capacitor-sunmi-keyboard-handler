package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class SunmiRfidKeyHandler implements KeyHandlerInterface {
    public interface SunmiRfidKeyHandlerCallback {
        void onKeyPressed(boolean pressed);
    }

    protected SunmiRfidKeyHandlerCallback callback;

    public SunmiRfidKeyHandler(SunmiRfidKeyHandlerCallback callback) {
        this.callback = callback;
    }

    private boolean isButtonPressed = false;

    @Override
    public synchronized boolean handle(KeyEvent event) {

        InputDevice device = event.getDevice();

        boolean l2kGun = device.getVendorId() == 1 && device.getProductId() == 1 && device.getName().contains("pogo-keys");
        boolean l2sInternal = device.getVendorId() == 9300 && device.getProductId() == 25856 && device.getName().contains("mtk-kpd");

        if (!l2kGun && !l2sInternal)
            return false;

        if (event.getKeyCode() != 288) // Sunmi RFID Key
            return false;

        if (event.getAction() == ACTION_DOWN && !isButtonPressed) {
            isButtonPressed = true;
            callback.onKeyPressed(true);
        } else if (event.getAction() == ACTION_UP && isButtonPressed) {
            isButtonPressed = false;
            callback.onKeyPressed(false);
        }

        return true;
    }
}