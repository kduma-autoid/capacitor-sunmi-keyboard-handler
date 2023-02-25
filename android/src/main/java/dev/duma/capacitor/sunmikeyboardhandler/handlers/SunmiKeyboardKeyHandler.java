package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_ESCAPE;
import static android.view.KeyEvent.KEYCODE_F1;
import static android.view.KeyEvent.KEYCODE_F10;
import static android.view.KeyEvent.KEYCODE_F2;
import static android.view.KeyEvent.KEYCODE_F3;
import static android.view.KeyEvent.KEYCODE_F4;
import static android.view.KeyEvent.KEYCODE_F5;
import static android.view.KeyEvent.KEYCODE_F6;
import static android.view.KeyEvent.KEYCODE_F7;
import static android.view.KeyEvent.KEYCODE_F8;
import static android.view.KeyEvent.KEYCODE_F9;
import static android.view.KeyEvent.KEYCODE_FORWARD_DEL;
import static android.view.KeyEvent.KEYCODE_HENKAN;
import static android.view.KeyEvent.KEYCODE_MOVE_END;
import static android.view.KeyEvent.KEYCODE_MOVE_HOME;
import static android.view.KeyEvent.KEYCODE_PAGE_DOWN;
import static android.view.KeyEvent.KEYCODE_PAGE_UP;

import android.view.InputDevice;
import android.view.KeyEvent;

import com.getcapacitor.Bridge;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;
import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.ModifierKeyEnum;

public class SunmiKeyboardKeyHandler implements KeyHandlerInterface {
    public interface SunmiKeyboardKeyHandlerCallback {
        void onKeyPressed(ArrayList<ModifierKeyEnum> modifiers, boolean pressed);
    }

    private HandleableKeyEnum watchedKey;
    protected SunmiKeyboardKeyHandlerCallback callback;

    public SunmiKeyboardKeyHandler(HandleableKeyEnum watchedKey, SunmiKeyboardKeyHandlerCallback callback) {
        this.watchedKey = watchedKey;
        this.callback = callback;
    }

    private boolean isButtonPressed = false;

    @Override
    public boolean handle(KeyEvent event) {
        InputDevice device = event.getDevice();

        if((device.getVendorId() != 7847 || device.getProductId() != 2322) && !device.getName().contains("PayKeyboard")) // USB-HID PayKeyboard; VID: 7847; PID: 2322
            return false;

        if(event.getKeyCode() != watchedKey.getKeyCode())
            return false;

        if(event.getAction() != ACTION_UP && event.getAction() != ACTION_DOWN)
            return true;

        ArrayList<ModifierKeyEnum> modifiers = new ArrayList<>();

        if(event.isShiftPressed())
            modifiers.add(ModifierKeyEnum.Shift);

        if(event.isCtrlPressed())
            modifiers.add(ModifierKeyEnum.Ctrl);

        if(event.isAltPressed())
            modifiers.add(ModifierKeyEnum.Alt);

        if (event.getAction() == ACTION_DOWN && !isButtonPressed) {
            isButtonPressed = true;

            callback.onKeyPressed(modifiers, true);
        } else if (event.getAction() == ACTION_UP && isButtonPressed) {
            isButtonPressed = false;

            callback.onKeyPressed(modifiers, false);
        }

        return true;
    }
}
