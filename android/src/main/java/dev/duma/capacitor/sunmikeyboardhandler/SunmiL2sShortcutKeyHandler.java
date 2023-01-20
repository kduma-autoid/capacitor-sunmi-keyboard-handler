package dev.duma.capacitor.sunmikeyboardhandler;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_F11;

import android.view.InputDevice;
import android.view.KeyEvent;

import com.getcapacitor.Bridge;

import org.json.JSONException;
import org.json.JSONObject;

public class SunmiL2sShortcutKeyHandler implements KeyHandlerInterface {
    protected Bridge bridge;

    public SunmiL2sShortcutKeyHandler(Bridge bridge) {
        this.bridge = bridge;
    }

    private boolean isButtonPressed = false;

    @Override
    public synchronized boolean handle(KeyEvent event) {

        InputDevice device = event.getDevice();

        if ((device.getVendorId() != 9300 || device.getProductId() != 25856) && !device.getName().contains("mtk-kpd")) // Sunmi built-in buttons
            return false;

        if (event.getKeyCode() != 288 && event.getKeyCode() != KEYCODE_F11) // Sunmi L2s Shortcut / Scan UHF button
            return false;

        if (event.getAction() == ACTION_DOWN && isButtonPressed == false) {
            isButtonPressed = true;

            try {
                JSONObject json = new JSONObject();
                json.put("pressed", true);

                bridge.triggerWindowJSEvent("sunmi_shortcut_key", json.toString(3));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } else if (event.getAction() == ACTION_UP && isButtonPressed == true) {
            isButtonPressed = false;

            try {
                JSONObject json = new JSONObject();
                json.put("pressed", false);

                bridge.triggerWindowJSEvent("sunmi_shortcut_key", json.toString(3));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }
}