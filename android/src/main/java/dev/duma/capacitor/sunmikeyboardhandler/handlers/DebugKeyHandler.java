package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import java.util.EnumSet;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;
import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class DebugKeyHandler implements IHandler {
    private final Callback callback;

    @Override
    public boolean provides(HandleableKeyEnum key) {
        return HandleableKeyEnum.Debug == key;
    }

    public DebugKeyHandler(Callback callback) {
        this.callback = callback;
    }

    @Override
    public boolean canBeHandled(KeyEvent event, EnumSet<HandleableKeyEnum> handledKeys) {
        return true;
    }

    @Override
    public synchronized boolean handle(KeyEvent event) {
        callback.onDebug(event);

        return false;
    }
}