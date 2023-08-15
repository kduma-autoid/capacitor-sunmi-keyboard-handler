package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class SunmiL2kShortcutKeyHandler implements KeyHandlerInterface {
    public interface SunmiL2kShortcutKeyHandlerCallback {
        void onKeyPressed(boolean pressed);
    }

    protected SunmiL2kShortcutKeyHandlerCallback callback;

    public SunmiL2kShortcutKeyHandler(SunmiL2kShortcutKeyHandlerCallback callback) {
        this.callback = callback;
    }

    private boolean isButtonPressed = false;

    @Override
    public synchronized boolean handle(KeyEvent event) {

        InputDevice device = event.getDevice();

        if ((device.getVendorId() != 1 || device.getProductId() != 1) && !device.getName().contains("gpio-keys"))
            return false;

        if (event.getKeyCode() != 285) // Sunmi L2k Side Shortcut Key
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