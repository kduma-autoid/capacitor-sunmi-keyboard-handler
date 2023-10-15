package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.ModifierKeyEnum;

public class SunmiL2KKeyboardKeyHandler extends AbstractMultipleKeysHandler {
    public SunmiL2KKeyboardKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmiL2KFunctionKeysKeyboard(device);
    }

    @Override
    protected Map<HandleableKeyEnum, Integer> getHandleableKeysMap() {
        EnumMap<HandleableKeyEnum, Integer> handleableKeys = new EnumMap<>(HandleableKeyEnum.class);

        handleableKeys.put(HandleableKeyEnum.L2K_TAB, KeyEvent.KEYCODE_TAB);
        handleableKeys.put(HandleableKeyEnum.L2K_ENTER, KeyEvent.KEYCODE_ENTER);
        handleableKeys.put(HandleableKeyEnum.L2K_P1, KeyEvent.KEYCODE_F11);
        handleableKeys.put(HandleableKeyEnum.L2K_1, KeyEvent.KEYCODE_1);
        handleableKeys.put(HandleableKeyEnum.L2K_2, KeyEvent.KEYCODE_2);
        handleableKeys.put(HandleableKeyEnum.L2K_3, KeyEvent.KEYCODE_3);
        handleableKeys.put(HandleableKeyEnum.L2K_4, KeyEvent.KEYCODE_4);
        handleableKeys.put(HandleableKeyEnum.L2K_5, KeyEvent.KEYCODE_5);
        handleableKeys.put(HandleableKeyEnum.L2K_6, KeyEvent.KEYCODE_6);
        handleableKeys.put(HandleableKeyEnum.L2K_7, KeyEvent.KEYCODE_7);
        handleableKeys.put(HandleableKeyEnum.L2K_8, KeyEvent.KEYCODE_8);
        handleableKeys.put(HandleableKeyEnum.L2K_9, KeyEvent.KEYCODE_9);
        handleableKeys.put(HandleableKeyEnum.L2K_0, KeyEvent.KEYCODE_0);
        handleableKeys.put(HandleableKeyEnum.L2K_PERIOD, KeyEvent.KEYCODE_PERIOD);
        handleableKeys.put(HandleableKeyEnum.L2K_SPACE, KeyEvent.KEYCODE_SPACE);
        handleableKeys.put(HandleableKeyEnum.L2K_MINUS, KeyEvent.KEYCODE_NUMPAD_SUBTRACT);
        handleableKeys.put(HandleableKeyEnum.L2K_DEL, KeyEvent.KEYCODE_DEL);
        handleableKeys.put(HandleableKeyEnum.L2K_UP, KeyEvent.KEYCODE_DPAD_UP);
        handleableKeys.put(HandleableKeyEnum.L2K_DOWN, KeyEvent.KEYCODE_DPAD_DOWN);
        handleableKeys.put(HandleableKeyEnum.L2K_LEFT, KeyEvent.KEYCODE_DPAD_LEFT);
        handleableKeys.put(HandleableKeyEnum.L2K_RIGHT, KeyEvent.KEYCODE_DPAD_RIGHT);
        handleableKeys.put(HandleableKeyEnum.L2K_CENTER, KeyEvent.KEYCODE_DPAD_CENTER);

        return Collections.unmodifiableMap(handleableKeys);
    }

    @NonNull
    @Override
    protected ArrayList<ModifierKeyEnum> getModifiers(KeyEvent event) {
        ArrayList<ModifierKeyEnum> modifiers = new ArrayList<>();

        // TODO: How to read F1-F5 keys?

        return modifiers;
    }
}
