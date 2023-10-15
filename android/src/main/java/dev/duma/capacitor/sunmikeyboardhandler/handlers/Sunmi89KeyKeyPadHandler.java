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

public class Sunmi89KeyKeyPadHandler extends AbstractKeyboardHandler {
    public Sunmi89KeyKeyPadHandler(Callback callback) {
        super(callback);
    }

    @Override
    @NonNull
    protected HandleableKeyEnum provides() {
        return HandleableKeyEnum.Sunmi89KeyKeyboard_KeyPad;
    }

    @Override
    protected Map<Integer, HandleableKeyEnum> getHandleableKeys() {
        Map<Integer, HandleableKeyEnum> handleableKeys = new HashMap<>();

        handleableKeys.put(KeyEvent.KEYCODE_GRAVE, HandleableKeyEnum.Sunmi89KeyKeyboard_Grave);
        handleableKeys.put(KeyEvent.KEYCODE_TAB, HandleableKeyEnum.Sunmi89KeyKeyboard_Tab);
        handleableKeys.put(KeyEvent.KEYCODE_SLASH, HandleableKeyEnum.Sunmi89KeyKeyboard_Slash);
        handleableKeys.put(KeyEvent.KEYCODE_SPACE, HandleableKeyEnum.Sunmi89KeyKeyboard_Space);
        handleableKeys.put(KeyEvent.KEYCODE_APOSTROPHE, HandleableKeyEnum.Sunmi89KeyKeyboard_Apostrophe);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_LEFT, HandleableKeyEnum.Sunmi89KeyKeyboard_Left);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_DOWN, HandleableKeyEnum.Sunmi89KeyKeyboard_Down);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_RIGHT, HandleableKeyEnum.Sunmi89KeyKeyboard_Right);
        handleableKeys.put(KeyEvent.KEYCODE_DPAD_UP, HandleableKeyEnum.Sunmi89KeyKeyboard_Up);
        handleableKeys.put(KeyEvent.KEYCODE_PERIOD, HandleableKeyEnum.Sunmi89KeyKeyboard_Period);
        handleableKeys.put(KeyEvent.KEYCODE_COMMA, HandleableKeyEnum.Sunmi89KeyKeyboard_Comma);
        handleableKeys.put(KeyEvent.KEYCODE_BACKSLASH, HandleableKeyEnum.Sunmi89KeyKeyboard_BackSlash);
        handleableKeys.put(KeyEvent.KEYCODE_ENTER, HandleableKeyEnum.Sunmi89KeyKeyboard_Enter);
        handleableKeys.put(KeyEvent.KEYCODE_DEL, HandleableKeyEnum.Sunmi89KeyKeyboard_Del);

        handleableKeys.put(KeyEvent.KEYCODE_MINUS, HandleableKeyEnum.Sunmi89KeyKeyboard_Minus);
        handleableKeys.put(KeyEvent.KEYCODE_EQUALS, HandleableKeyEnum.Sunmi89KeyKeyboard_Equals);
        handleableKeys.put(KeyEvent.KEYCODE_RIGHT_BRACKET, HandleableKeyEnum.Sunmi89KeyKeyboard_RightBracket);
        handleableKeys.put(KeyEvent.KEYCODE_LEFT_BRACKET, HandleableKeyEnum.Sunmi89KeyKeyboard_LeftBracket);
        handleableKeys.put(KeyEvent.KEYCODE_SEMICOLON, HandleableKeyEnum.Sunmi89KeyKeyboard_Semicolon);

        handleableKeys.put(KeyEvent.KEYCODE_1, HandleableKeyEnum.Sunmi89KeyKeyboard_1);
        handleableKeys.put(KeyEvent.KEYCODE_2, HandleableKeyEnum.Sunmi89KeyKeyboard_2);
        handleableKeys.put(KeyEvent.KEYCODE_3, HandleableKeyEnum.Sunmi89KeyKeyboard_3);
        handleableKeys.put(KeyEvent.KEYCODE_4, HandleableKeyEnum.Sunmi89KeyKeyboard_4);
        handleableKeys.put(KeyEvent.KEYCODE_5, HandleableKeyEnum.Sunmi89KeyKeyboard_5);
        handleableKeys.put(KeyEvent.KEYCODE_6, HandleableKeyEnum.Sunmi89KeyKeyboard_6);
        handleableKeys.put(KeyEvent.KEYCODE_7, HandleableKeyEnum.Sunmi89KeyKeyboard_7);
        handleableKeys.put(KeyEvent.KEYCODE_8, HandleableKeyEnum.Sunmi89KeyKeyboard_8);
        handleableKeys.put(KeyEvent.KEYCODE_9, HandleableKeyEnum.Sunmi89KeyKeyboard_9);
        handleableKeys.put(KeyEvent.KEYCODE_0, HandleableKeyEnum.Sunmi89KeyKeyboard_0);

        handleableKeys.put(KeyEvent.KEYCODE_Q, HandleableKeyEnum.Sunmi89KeyKeyboard_Q);
        handleableKeys.put(KeyEvent.KEYCODE_W, HandleableKeyEnum.Sunmi89KeyKeyboard_W);
        handleableKeys.put(KeyEvent.KEYCODE_E, HandleableKeyEnum.Sunmi89KeyKeyboard_E);
        handleableKeys.put(KeyEvent.KEYCODE_R, HandleableKeyEnum.Sunmi89KeyKeyboard_R);
        handleableKeys.put(KeyEvent.KEYCODE_T, HandleableKeyEnum.Sunmi89KeyKeyboard_T);
        handleableKeys.put(KeyEvent.KEYCODE_Y, HandleableKeyEnum.Sunmi89KeyKeyboard_Y);
        handleableKeys.put(KeyEvent.KEYCODE_U, HandleableKeyEnum.Sunmi89KeyKeyboard_U);
        handleableKeys.put(KeyEvent.KEYCODE_I, HandleableKeyEnum.Sunmi89KeyKeyboard_I);
        handleableKeys.put(KeyEvent.KEYCODE_O, HandleableKeyEnum.Sunmi89KeyKeyboard_O);
        handleableKeys.put(KeyEvent.KEYCODE_P, HandleableKeyEnum.Sunmi89KeyKeyboard_P);
        handleableKeys.put(KeyEvent.KEYCODE_A, HandleableKeyEnum.Sunmi89KeyKeyboard_A);
        handleableKeys.put(KeyEvent.KEYCODE_S, HandleableKeyEnum.Sunmi89KeyKeyboard_S);
        handleableKeys.put(KeyEvent.KEYCODE_D, HandleableKeyEnum.Sunmi89KeyKeyboard_D);
        handleableKeys.put(KeyEvent.KEYCODE_F, HandleableKeyEnum.Sunmi89KeyKeyboard_F);
        handleableKeys.put(KeyEvent.KEYCODE_G, HandleableKeyEnum.Sunmi89KeyKeyboard_G);
        handleableKeys.put(KeyEvent.KEYCODE_H, HandleableKeyEnum.Sunmi89KeyKeyboard_H);
        handleableKeys.put(KeyEvent.KEYCODE_J, HandleableKeyEnum.Sunmi89KeyKeyboard_J);
        handleableKeys.put(KeyEvent.KEYCODE_K, HandleableKeyEnum.Sunmi89KeyKeyboard_K);
        handleableKeys.put(KeyEvent.KEYCODE_L, HandleableKeyEnum.Sunmi89KeyKeyboard_L);
        handleableKeys.put(KeyEvent.KEYCODE_Z, HandleableKeyEnum.Sunmi89KeyKeyboard_Z);
        handleableKeys.put(KeyEvent.KEYCODE_X, HandleableKeyEnum.Sunmi89KeyKeyboard_X);
        handleableKeys.put(KeyEvent.KEYCODE_C, HandleableKeyEnum.Sunmi89KeyKeyboard_C);
        handleableKeys.put(KeyEvent.KEYCODE_V, HandleableKeyEnum.Sunmi89KeyKeyboard_V);
        handleableKeys.put(KeyEvent.KEYCODE_B, HandleableKeyEnum.Sunmi89KeyKeyboard_B);
        handleableKeys.put(KeyEvent.KEYCODE_N, HandleableKeyEnum.Sunmi89KeyKeyboard_N);
        handleableKeys.put(KeyEvent.KEYCODE_M, HandleableKeyEnum.Sunmi89KeyKeyboard_M);

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
        return DeviceIdentificationHelper.isSunmi89KeyKeyboard(device);
    }
}
