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

public class Sunmi89KeyKeyboardKeyHandler extends AbstractMultipleKeysHandler {
    public Sunmi89KeyKeyboardKeyHandler(Callback callback) {
        super(callback);
    }

    @Override
    protected boolean isCompatibleDevice(InputDevice device, KeyEvent event) {
        return DeviceIdentificationHelper.isSunmi89KeyKeyboard(device);
    }

    @Override
    protected Map<HandleableKeyEnum, Integer> getHandleableKeysMap() {
        EnumMap<HandleableKeyEnum, Integer> handleableKeys = new EnumMap<>(HandleableKeyEnum.class);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Esc, KeyEvent.KEYCODE_ESCAPE);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F1, KeyEvent.KEYCODE_F1);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F2, KeyEvent.KEYCODE_F2);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F3, KeyEvent.KEYCODE_F3);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F4, KeyEvent.KEYCODE_F4);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F5, KeyEvent.KEYCODE_F5);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F6, KeyEvent.KEYCODE_F6);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F7, KeyEvent.KEYCODE_F7);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F8, KeyEvent.KEYCODE_F8);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F9, KeyEvent.KEYCODE_F9);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F10, KeyEvent.KEYCODE_F10);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Delete, KeyEvent.KEYCODE_FORWARD_DEL);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Home, KeyEvent.KEYCODE_MOVE_HOME);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_End, KeyEvent.KEYCODE_MOVE_END);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_PgUp, KeyEvent.KEYCODE_PAGE_UP);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_PgDn, KeyEvent.KEYCODE_PAGE_DOWN);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Cash, KeyEvent.KEYCODE_HENKAN);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Grave, KeyEvent.KEYCODE_GRAVE);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Tab, KeyEvent.KEYCODE_TAB);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Slash, KeyEvent.KEYCODE_SLASH);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Space, KeyEvent.KEYCODE_SPACE);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Apostrophe, KeyEvent.KEYCODE_APOSTROPHE);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Left, KeyEvent.KEYCODE_DPAD_LEFT);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Down, KeyEvent.KEYCODE_DPAD_DOWN);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Right, KeyEvent.KEYCODE_DPAD_RIGHT);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Up, KeyEvent.KEYCODE_DPAD_UP);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Period, KeyEvent.KEYCODE_PERIOD);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Comma, KeyEvent.KEYCODE_COMMA);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_BackSlash, KeyEvent.KEYCODE_BACKSLASH);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Enter, KeyEvent.KEYCODE_ENTER);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Del, KeyEvent.KEYCODE_DEL);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Minus, KeyEvent.KEYCODE_MINUS);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Equals, KeyEvent.KEYCODE_EQUALS);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_RightBracket, KeyEvent.KEYCODE_RIGHT_BRACKET);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_LeftBracket, KeyEvent.KEYCODE_LEFT_BRACKET);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Semicolon, KeyEvent.KEYCODE_SEMICOLON);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_1, KeyEvent.KEYCODE_1);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_2, KeyEvent.KEYCODE_2);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_3, KeyEvent.KEYCODE_3);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_4, KeyEvent.KEYCODE_4);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_5, KeyEvent.KEYCODE_5);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_6, KeyEvent.KEYCODE_6);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_7, KeyEvent.KEYCODE_7);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_8, KeyEvent.KEYCODE_8);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_9, KeyEvent.KEYCODE_9);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_0, KeyEvent.KEYCODE_0);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Q, KeyEvent.KEYCODE_Q);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_W, KeyEvent.KEYCODE_W);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_E, KeyEvent.KEYCODE_E);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_R, KeyEvent.KEYCODE_R);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_T, KeyEvent.KEYCODE_T);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Y, KeyEvent.KEYCODE_Y);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_U, KeyEvent.KEYCODE_U);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_I, KeyEvent.KEYCODE_I);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_O, KeyEvent.KEYCODE_O);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_P, KeyEvent.KEYCODE_P);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_A, KeyEvent.KEYCODE_A);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_S, KeyEvent.KEYCODE_S);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_D, KeyEvent.KEYCODE_D);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_F, KeyEvent.KEYCODE_F);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_G, KeyEvent.KEYCODE_G);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_H, KeyEvent.KEYCODE_H);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_J, KeyEvent.KEYCODE_J);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_K, KeyEvent.KEYCODE_K);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_L, KeyEvent.KEYCODE_L);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_Z, KeyEvent.KEYCODE_Z);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_X, KeyEvent.KEYCODE_X);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_C, KeyEvent.KEYCODE_C);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_V, KeyEvent.KEYCODE_V);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_B, KeyEvent.KEYCODE_B);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_N, KeyEvent.KEYCODE_N);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_M, KeyEvent.KEYCODE_M);

        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad0, KeyEvent.KEYCODE_NUMPAD_0);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad1, KeyEvent.KEYCODE_NUMPAD_1);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad2, KeyEvent.KEYCODE_NUMPAD_2);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad3, KeyEvent.KEYCODE_NUMPAD_3);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad4, KeyEvent.KEYCODE_NUMPAD_4);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad5, KeyEvent.KEYCODE_NUMPAD_5);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad6, KeyEvent.KEYCODE_NUMPAD_6);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad7, KeyEvent.KEYCODE_NUMPAD_7);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad8, KeyEvent.KEYCODE_NUMPAD_8);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPad9, KeyEvent.KEYCODE_NUMPAD_9);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadDot, KeyEvent.KEYCODE_NUMPAD_DOT);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadDivide, KeyEvent.KEYCODE_NUMPAD_DIVIDE);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadMultiply, KeyEvent.KEYCODE_NUMPAD_MULTIPLY);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadSubtract, KeyEvent.KEYCODE_NUMPAD_SUBTRACT);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadAdd, KeyEvent.KEYCODE_NUMPAD_ADD);
        handleableKeys.put(HandleableKeyEnum.Sunmi89KeyKeyboard_NumPadEnter, KeyEvent.KEYCODE_NUMPAD_ENTER);

        return Collections.unmodifiableMap(handleableKeys);
    }

    @NonNull
    @Override
    protected ArrayList<ModifierKeyEnum> getModifiers(KeyEvent event) {
        ArrayList<ModifierKeyEnum> modifiers = new ArrayList<>();

        if(event.isShiftPressed())
            modifiers.add(ModifierKeyEnum.Shift);

        if(event.isCtrlPressed())
            modifiers.add(ModifierKeyEnum.Ctrl);

        if(event.isAltPressed())
            modifiers.add(ModifierKeyEnum.Alt);

        if(event.isCapsLockOn())
            modifiers.add(ModifierKeyEnum.CapsLock);

        return modifiers;
    }
}
