package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import java.util.EnumSet;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

abstract public class AbstractKeyHandler implements IHandler {
    protected final Callback callback;

    public AbstractKeyHandler(Callback callback) {
        this.callback = callback;
    }

    abstract protected boolean isCompatibleDevice(InputDevice device, KeyEvent event);
    abstract protected HandleableKeyEnum getHandleableKey(KeyEvent event);
    abstract protected void handleCallback(KeyEvent event, HandleableKeyEnum handleableKey);

    @Override
    public boolean canBeHandled(KeyEvent event, EnumSet<HandleableKeyEnum> handledKeys) {
        InputDevice device = event.getDevice();

        if (!isCompatibleDevice(device, event))
            return false;

        HandleableKeyEnum handleableKey;
        try {
            handleableKey = getHandleableKey(event);
        } catch (RuntimeException e) {
            return false;
        }

        if (handleableKey == null) return false;

        return handledKeys.contains(handleableKey);
    }

    @Override
    public synchronized boolean handle(KeyEvent event) {
        HandleableKeyEnum handleableKey;
        try {
            handleableKey = getHandleableKey(event);
        } catch (RuntimeException e) {
            return false;
        }

        if (handleableKey == null) return false;

        handleCallback(event, handleableKey);

        return true;
    }
}
