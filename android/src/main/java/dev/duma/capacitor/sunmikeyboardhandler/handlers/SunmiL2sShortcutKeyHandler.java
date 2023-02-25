package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class SunmiL2sShortcutKeyHandler implements KeyHandlerInterface {
    public interface SunmiL2sShortcutKeyHandlerCallback {
        void onKeyPressed(boolean pressed);
    }

    protected SunmiL2sShortcutKeyHandlerCallback callback;

    public SunmiL2sShortcutKeyHandler(SunmiL2sShortcutKeyHandlerCallback callback) {
        this.callback = callback;
    }

    private boolean isButtonPressed = false;

    @Override
    public synchronized boolean handle(KeyEvent event) {

        InputDevice device = event.getDevice();

        if ((device.getVendorId() != 9300 || device.getProductId() != 25856) && !device.getName().contains("mtk-kpd")) // Sunmi built-in buttons
            return false;

        if (event.getKeyCode() != 288 && event.getKeyCode() != KEYCODE_F11) // Sunmi L2s Shortcut / Scan UHF button
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