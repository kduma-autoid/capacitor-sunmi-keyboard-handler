package dev.duma.capacitor.sunmikeyboardhandler.example;

import android.view.KeyEvent;

import com.getcapacitor.BridgeActivity;

import dev.duma.capacitor.sunmikeyboardhandler.HasKeyHandlersInterface;
import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class MainActivity extends BridgeActivity implements HasKeyHandlersInterface {
    private KeyHandlerInterface keyHandler = null;

    public KeyHandlerInterface getKeyHandler() {
        return keyHandler;
    }

    public void setKeyHandler(KeyHandlerInterface keyHandler) {
        this.keyHandler = keyHandler;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyHandlerInterface handler = getKeyHandler();

        if (handler != null && handler.handle(event)) return true;

        return super.dispatchKeyEvent(event);
    }
}