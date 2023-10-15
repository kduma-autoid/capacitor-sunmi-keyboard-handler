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

public class SunmiL2KsKeyboardKeyHandler extends AbstractMultipleKeysHandler {
    public SunmiL2KsKeyboardKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmiL2KsFunctionKeysKeyboard(device);
    }

    @Override
    protected Map<HandleableKeyEnum, Integer> getHandleableKeysMap() {
        EnumMap<HandleableKeyEnum, Integer> handleableKeys = new EnumMap<>(HandleableKeyEnum.class);

        handleableKeys.put(HandleableKeyEnum.L2Ks_F1, KeyEvent.KEYCODE_F1);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F2, KeyEvent.KEYCODE_F2);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F3, KeyEvent.KEYCODE_F3);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F4, KeyEvent.KEYCODE_F4);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F5, KeyEvent.KEYCODE_F5);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F6, KeyEvent.KEYCODE_F6);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F7, KeyEvent.KEYCODE_F7);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F8, KeyEvent.KEYCODE_F8);
        handleableKeys.put(HandleableKeyEnum.L2Ks_F9, KeyEvent.KEYCODE_F9);
        handleableKeys.put(HandleableKeyEnum.L2Ks_BACK, KeyEvent.KEYCODE_BACK);
        handleableKeys.put(HandleableKeyEnum.L2Ks_ENTER, KeyEvent.KEYCODE_ENTER);
        handleableKeys.put(HandleableKeyEnum.L2Ks_STAR, KeyEvent.KEYCODE_STAR);
        handleableKeys.put(HandleableKeyEnum.L2Ks_SPACE, KeyEvent.KEYCODE_SPACE);
        handleableKeys.put(HandleableKeyEnum.L2Ks_POUND, KeyEvent.KEYCODE_POUND);
        handleableKeys.put(HandleableKeyEnum.L2Ks_DEL, KeyEvent.KEYCODE_DEL);
        handleableKeys.put(HandleableKeyEnum.L2Ks_UP, KeyEvent.KEYCODE_DPAD_UP);
        handleableKeys.put(HandleableKeyEnum.L2Ks_DOWN, KeyEvent.KEYCODE_DPAD_DOWN);
        handleableKeys.put(HandleableKeyEnum.L2Ks_LEFT, KeyEvent.KEYCODE_DPAD_LEFT);
        handleableKeys.put(HandleableKeyEnum.L2Ks_RIGHT, KeyEvent.KEYCODE_DPAD_RIGHT);
        handleableKeys.put(HandleableKeyEnum.L2Ks_1, KeyEvent.KEYCODE_1);
        handleableKeys.put(HandleableKeyEnum.L2Ks_2, KeyEvent.KEYCODE_2);
        handleableKeys.put(HandleableKeyEnum.L2Ks_3, KeyEvent.KEYCODE_3);
        handleableKeys.put(HandleableKeyEnum.L2Ks_4, KeyEvent.KEYCODE_4);
        handleableKeys.put(HandleableKeyEnum.L2Ks_5, KeyEvent.KEYCODE_5);
        handleableKeys.put(HandleableKeyEnum.L2Ks_6, KeyEvent.KEYCODE_6);
        handleableKeys.put(HandleableKeyEnum.L2Ks_7, KeyEvent.KEYCODE_7);
        handleableKeys.put(HandleableKeyEnum.L2Ks_8, KeyEvent.KEYCODE_8);
        handleableKeys.put(HandleableKeyEnum.L2Ks_9, KeyEvent.KEYCODE_9);
        handleableKeys.put(HandleableKeyEnum.L2Ks_0, KeyEvent.KEYCODE_0);
        handleableKeys.put(HandleableKeyEnum.L2Ks_PERIOD, KeyEvent.KEYCODE_PERIOD);

        return Collections.unmodifiableMap(handleableKeys);
    }
}
