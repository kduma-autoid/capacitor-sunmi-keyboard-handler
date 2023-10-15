package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;

import android.view.KeyEvent;


import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

abstract public class AbstractSingleKeyHandler extends AbstractKeyHandler {
    private boolean isButtonPressed = false;

    @Override
    public boolean provides(HandleableKeyEnum key) {
        return key == provides();
    }

    abstract protected HandleableKeyEnum provides();

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
