package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiL2KsNumPadHandler extends AbstractKeyboardHandler {
    public SunmiL2KsNumPadHandler(Callback callback) {
        super(callback);
    }

    @Override
    @NonNull
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.L2Ks_KeyPad;
    }

    @Override
    protected Map<Integer, HandleableKeyEnum> getHandleableKeys() {
        Map<Integer, HandleableKeyEnum> handleableKeys = new HashMap<>();

        handleableKeys.put(KeyEvent.KEYCODE_ENTER, HandleableKeyEnum.L2Ks_ENTER);
        handleableKeys.put(KeyEvent.KEYCODE_STAR, HandleableKeyEnum.L2Ks_STAR);
        handleableKeys.put(KeyEvent.KEYCODE_SPACE, HandleableKeyEnum.L2Ks_SPACE);
        handleableKeys.put(KeyEvent.KEYCODE_POUND, HandleableKeyEnum.L2Ks_POUND);
        handleableKeys.put(KeyEvent.KEYCODE_DEL, HandleableKeyEnum.L2Ks_DEL);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_UP, HandleableKeyEnum.L2Ks_UP);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_DOWN, HandleableKeyEnum.L2Ks_DOWN);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_LEFT, HandleableKeyEnum.L2Ks_LEFT);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_RIGHT, HandleableKeyEnum.L2Ks_RIGHT);
        handleableKeys.put(KeyEvent.KEYCODE_1, HandleableKeyEnum.L2Ks_1);
        handleableKeys.put(KeyEvent.KEYCODE_2, HandleableKeyEnum.L2Ks_2);
        handleableKeys.put(KeyEvent.KEYCODE_3, HandleableKeyEnum.L2Ks_3);
        handleableKeys.put(KeyEvent.KEYCODE_4, HandleableKeyEnum.L2Ks_4);
        handleableKeys.put(KeyEvent.KEYCODE_5, HandleableKeyEnum.L2Ks_5);
        handleableKeys.put(KeyEvent.KEYCODE_6, HandleableKeyEnum.L2Ks_6);
        handleableKeys.put(KeyEvent.KEYCODE_7, HandleableKeyEnum.L2Ks_7);
        handleableKeys.put(KeyEvent.KEYCODE_8, HandleableKeyEnum.L2Ks_8);
        handleableKeys.put(KeyEvent.KEYCODE_9, HandleableKeyEnum.L2Ks_9);
        handleableKeys.put(KeyEvent.KEYCODE_0, HandleableKeyEnum.L2Ks_0);
        handleableKeys.put(KeyEvent.KEYCODE_PERIOD, HandleableKeyEnum.L2Ks_PERIOD);

        return Collections.unmodifiableMap(handleableKeys);
    }
    @Override
    protected Set<Integer> getNonPrintableKeys() {
        Set<Integer> nonPrintableKeys = new HashSet<>();

        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_LEFT);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_DOWN);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_RIGHT);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_UP);

        nonPrintableKeys.add(KeyEvent.KEYCODE_DEL);

        return Collections.unmodifiableSet(nonPrintableKeys);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmiL2KsFunctionKeysKeyboard(device);
    }
}
