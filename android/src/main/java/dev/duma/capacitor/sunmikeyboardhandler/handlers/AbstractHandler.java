package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

public abstract class AbstractHandler implements IHandler {
    protected final Callback callback;

    public AbstractHandler(Callback callback) {
        this.callback = callback;
    }


    abstract protected boolean isCompatibleDevice(InputDevice device, KeyEvent event);
}
