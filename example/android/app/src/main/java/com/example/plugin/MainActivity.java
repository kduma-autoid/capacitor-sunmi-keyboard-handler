package com.example.plugin;

import android.view.KeyEvent;

import com.getcapacitor.BridgeActivity;

import java.util.ArrayList;

import dev.duma.capacitor.sunmikeyboardhandler.HasKeyHandlersInterface;
import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class MainActivity extends BridgeActivity implements HasKeyHandlersInterface {
    public ArrayList<KeyHandlerInterface> keyHandlers = new ArrayList<KeyHandlerInterface>();

    @Override
    public void registerKeyHandler(KeyHandlerInterface handler) {
        keyHandlers.add(handler);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        for (KeyHandlerInterface handler : this.keyHandlers) {
            if(handler.handle(event))
                return true;
        }

        return super.dispatchKeyEvent(event);
    }
}
