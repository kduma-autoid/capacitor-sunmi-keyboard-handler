package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class DebugKeyHandler implements KeyHandlerInterface {
    public interface DebugKeyHandlerCallback {
        void onKeyPressed(KeyEvent event);
    }

    protected DebugKeyHandlerCallback callback;

    public DebugKeyHandler(DebugKeyHandlerCallback callback) {
        this.callback = callback;
    }

    @Override
    public synchronized boolean handle(KeyEvent event) {
        callback.onKeyPressed(event);
        return false;
    }
}