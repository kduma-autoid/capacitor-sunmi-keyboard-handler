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

public class Sunmi89KeyNumPadHandler extends AbstractKeyboardHandler {
    public Sunmi89KeyNumPadHandler(Callback callback) {
        super(callback);
    }

    @Override
    @NonNull
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad;
    }

    @Override
    protected Map<Integer, HandleableKeyEnum> getHandleableKeys() {
        Map<Integer, HandleableKeyEnum> handleableKeys = new HashMap<>();

        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_0, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad0);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_1, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad1);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_2, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad2);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_3, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad3);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_4, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad4);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_5, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad5);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_6, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad6);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_7, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad7);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_8, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad8);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_9, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad9);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_DOT, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadDot);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_DIVIDE, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadDivide);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_MULTIPLY, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadMultiply);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_SUBTRACT, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadSubtract);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_ADD, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadAdd);
        handleableKeys.put(KeyEvent.KEYCODE_NUMPAD_ENTER, HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadEnter);

        return Collections.unmodifiableMap(handleableKeys);
    }
    @Override
    protected Set<Integer> getNonPrintableKeys() {
        return new HashSet<>();
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmi89KeyKeyboard(device);
    }
}
