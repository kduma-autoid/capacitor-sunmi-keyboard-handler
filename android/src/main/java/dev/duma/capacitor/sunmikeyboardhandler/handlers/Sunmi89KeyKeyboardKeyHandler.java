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
