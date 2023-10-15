package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;

import android.view.KeyEvent;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Map;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.ModifierKeyEnum;

abstract public class AbstractMultipleKeysHandler extends AbstractSingleKeyHandler {
    private final EnumSet<HandleableKeyEnum> buttonsPressed = EnumSet.noneOf(HandleableKeyEnum.class);

    public AbstractMultipleKeysHandler(Callback callback) {
        super(callback);
    }

    protected abstract Map<HandleableKeyEnum, Integer> getHandleableKeysMap();

    @Override
    protected HandleableKeyEnum getHandleableKey(KeyEvent event) {
        Map<HandleableKeyEnum, Integer> handleableKeys = getHandleableKeysMap();

        for (Map.Entry<HandleableKeyEnum, Integer> entry : handleableKeys.entrySet()) {
            if (entry.getValue() == event.getKeyCode()) {
                return entry.getKey();
            }
        }

        return null;
    }

    @Override
    protected void handleCallback(KeyEvent event, HandleableKeyEnum handleableKey) {
        if (event.getAction() == ACTION_DOWN && !buttonsPressed.contains(handleableKey)) {
            buttonsPressed.add(handleableKey);
            callback.onKeyPressed(handleableKey, true, getModifiers(event));
        } else if (event.getAction() == ACTION_UP && buttonsPressed.contains(handleableKey)) {
            buttonsPressed.remove(handleableKey);
            callback.onKeyPressed(handleableKey, false, getModifiers(event));
        }
    }

    @NonNull
    protected ArrayList<ModifierKeyEnum> getModifiers(KeyEvent event) {
        return new ArrayList<>();
    }
}
