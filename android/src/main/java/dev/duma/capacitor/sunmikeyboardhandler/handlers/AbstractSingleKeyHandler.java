package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;

import android.view.InputDevice;
import android.view.KeyEvent;

import java.util.EnumSet;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

abstract public class AbstractSingleKeyHandler extends AbstractKeyHandler {
    private boolean isButtonPressed = false;

    public AbstractSingleKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected void handleCallback(KeyEvent event, HandleableKeyEnum handleableKey) {
        if (event.getAction() == ACTION_DOWN && !isButtonPressed) {
            isButtonPressed = true;
            callback.onKeyPressed(handleableKey, true);
        } else if (event.getAction() == ACTION_UP && isButtonPressed) {
            isButtonPressed = false;
            callback.onKeyPressed(handleableKey, false);
        }
    }
}
