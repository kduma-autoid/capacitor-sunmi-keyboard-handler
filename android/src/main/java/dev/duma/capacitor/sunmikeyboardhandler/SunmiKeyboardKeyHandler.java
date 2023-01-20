package dev.duma.capacitor.sunmikeyboardhandler;

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

public class SunmiKeyboardKeyHandler implements KeyHandlerInterface {
    protected Bridge bridge;

    public SunmiKeyboardKeyHandler(Bridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public boolean handle(KeyEvent event) {
        InputDevice device = event.getDevice();

        if((device.getVendorId() != 7847 || device.getProductId() != 2322) && !device.getName().contains("PayKeyboard")) // USB-HID PayKeyboard; VID: 7847; PID: 2322
            return false;

        int keyCode = event.getKeyCode();
        if(
                keyCode != KEYCODE_PAGE_DOWN
                        && keyCode != KEYCODE_PAGE_UP
                        && keyCode != KEYCODE_MOVE_END
                        && keyCode != KEYCODE_MOVE_HOME
                        && keyCode != KEYCODE_FORWARD_DEL
                        && keyCode != KEYCODE_F1
                        && keyCode != KEYCODE_F2
                        && keyCode != KEYCODE_F3
                        && keyCode != KEYCODE_F4
                        && keyCode != KEYCODE_F5
                        && keyCode != KEYCODE_F6
                        && keyCode != KEYCODE_F7
                        && keyCode != KEYCODE_F8
                        && keyCode != KEYCODE_F9
                        && keyCode != KEYCODE_F10
                        && keyCode != KEYCODE_ESCAPE
                        && keyCode != KEYCODE_HENKAN
        ) {
            return false;
        }

        if(event.getAction() != ACTION_UP)
            return true;

        try {
            JSONObject json = new JSONObject();

            switch (keyCode) {
                case KEYCODE_PAGE_DOWN: json.put("key", "PGDOWN"); break;
                case KEYCODE_PAGE_UP: json.put("key", "PGUP"); break;
                case KEYCODE_MOVE_END: json.put("key", "END"); break;
                case KEYCODE_MOVE_HOME: json.put("key", "HOME"); break;
                case KEYCODE_FORWARD_DEL: json.put("key", "DEL"); break;
                case KEYCODE_F1: json.put("key", "F1"); break;
                case KEYCODE_F2: json.put("key", "F2"); break;
                case KEYCODE_F3: json.put("key", "F3"); break;
                case KEYCODE_F4: json.put("key", "F4"); break;
                case KEYCODE_F5: json.put("key", "F5"); break;
                case KEYCODE_F6: json.put("key", "F6"); break;
                case KEYCODE_F7: json.put("key", "F7"); break;
                case KEYCODE_F8: json.put("key", "F8"); break;
                case KEYCODE_F9: json.put("key", "F9"); break;
                case KEYCODE_F10: json.put("key", "F10"); break;
                case KEYCODE_ESCAPE: json.put("key", "ESCAPE"); break;
                case KEYCODE_HENKAN: json.put("key", "CASH"); break;
                default: json.put("key", null);
            }

            json.put("shift", event.isShiftPressed());
            json.put("ctrl", event.isCtrlPressed());
            json.put("alt", event.isAltPressed());

            bridge.triggerWindowJSEvent("sunmi_keyboard_press", json.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
