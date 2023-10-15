package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import androidx.annotation.NonNull;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

abstract public class AbstractKeyboardHandler extends AbstractHandler {
    public AbstractKeyboardHandler(Callback callback) {
        super(callback);
    }

    @Override
    public boolean provides(HandleableKeyEnum key) {
        return provides() == key;
    }

    @NonNull
    protected abstract HandleableKeyEnum provides();

    protected abstract Map<Integer, HandleableKeyEnum> getHandleableKeys();

    protected abstract Set<Integer> getNonPrintableKeys();

    protected void handleCallback(KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_DOWN) return;
        if (event.getRepeatCount() != 0) return;

        int keyCode = event.getKeyCode();
        HandleableKeyEnum handleableKey = getHandleableKeys().get(keyCode);

        callback.onKeyboardInput(provides(), (char) event.getUnicodeChar(), handleableKey, getNonPrintableKeys().contains(keyCode));
    }

    @Override
    public boolean canBeHandled(KeyEvent event, EnumSet<HandleableKeyEnum> handledKeys) {
        InputDevice device = event.getDevice();

        if (!isCompatibleDevice(device, event))
            return false;

        if(!handledKeys.contains(provides()))
            return false;

        return getHandleableKeys().containsKey(event.getKeyCode());
    }

    @Override
    public synchronized boolean handle(KeyEvent event) {
        handleCallback(event);

        return true;
    }
}
