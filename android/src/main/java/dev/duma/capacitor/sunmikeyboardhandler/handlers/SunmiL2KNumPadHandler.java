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

public class SunmiL2KNumPadHandler extends AbstractKeyboardHandler {
    public SunmiL2KNumPadHandler(Callback callback) {
        super(callback);
    }

    @Override
    @NonNull
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.L2K_KeyPad;
    }

    @Override
    protected Map<Integer, HandleableKeyEnum> getHandleableKeys() {
        Map<Integer, HandleableKeyEnum> handleableKeys = new HashMap<>();

        handleableKeys.put(KeyEvent.KEYCODE_1, HandleableKeyEnum.L2K_1);
        handleableKeys.put(KeyEvent.KEYCODE_2, HandleableKeyEnum.L2K_2);
        handleableKeys.put(KeyEvent.KEYCODE_3, HandleableKeyEnum.L2K_3);
        handleableKeys.put(KeyEvent.KEYCODE_4, HandleableKeyEnum.L2K_4);
        handleableKeys.put(KeyEvent.KEYCODE_5, HandleableKeyEnum.L2K_5);
        handleableKeys.put(KeyEvent.KEYCODE_6, HandleableKeyEnum.L2K_6);
        handleableKeys.put(KeyEvent.KEYCODE_7, HandleableKeyEnum.L2K_7);
        handleableKeys.put(KeyEvent.KEYCODE_8, HandleableKeyEnum.L2K_8);
        handleableKeys.put(KeyEvent.KEYCODE_9, HandleableKeyEnum.L2K_9);
        handleableKeys.put(KeyEvent.KEYCODE_0, HandleableKeyEnum.L2K_0);
        handleableKeys.put(KeyEvent.KEYCODE_TAB, HandleableKeyEnum.L2K_TAB);
        handleableKeys.put(KeyEvent.KEYCODE_ENTER, HandleableKeyEnum.L2K_ENTER);
        handleableKeys.put(KeyEvent.KEYCODE_PERIOD, HandleableKeyEnum.L2K_PERIOD);
        handleableKeys.put(KeyEvent.KEYCODE_SPACE, HandleableKeyEnum.L2K_SPACE);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_SUBTRACT, HandleableKeyEnum.L2K_MINUS);
        handleableKeys.put(KeyEvent.KEYCODE_DEL, HandleableKeyEnum.L2K_DEL);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_UP, HandleableKeyEnum.L2K_UP);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_DOWN, HandleableKeyEnum.L2K_DOWN);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_LEFT, HandleableKeyEnum.L2K_LEFT);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_RIGHT, HandleableKeyEnum.L2K_RIGHT);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_CENTER, HandleableKeyEnum.L2K_CENTER);

        return Collections.unmodifiableMap(handleableKeys);
    }
    @Override
    protected Set<Integer> getNonPrintableKeys() {
        Set<Integer> nonPrintableKeys = new HashSet<>();

        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_LEFT);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_DOWN);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_RIGHT);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_UP);
        nonPrintableKeys.add(KeyEvent.KEYCODE_DPAD_CENTER);

        nonPrintableKeys.add(KeyEvent.KEYCODE_DEL);

        return Collections.unmodifiableSet(nonPrintableKeys);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmiL2KFunctionKeysKeyboard(device);
    }
}
