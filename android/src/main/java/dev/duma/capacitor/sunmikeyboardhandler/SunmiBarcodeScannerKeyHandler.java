package dev.duma.capacitor.sunmikeyboardhandler;

import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_ENTER;

import android.util.ArrayMap;
import android.view.InputDevice;
import android.view.KeyEvent;

import com.getcapacitor.Bridge;

import org.json.JSONException;
import org.json.JSONObject;

public class SunmiBarcodeScannerKeyHandler implements KeyHandlerInterface {
    protected Bridge bridge;

    public SunmiBarcodeScannerKeyHandler(Bridge bridge) {
        this.bridge = bridge;
    }

    private static class ScanBuffer {
        private String buffer = "";
        private long timestamp = 0;

        public ScanBuffer(String buffer) {
            this.buffer = buffer;

            timestamp = System.nanoTime();
        }

        public String getBuffer() {
            return buffer;
        }

        public void appendBuffer(String buffer) {
            this.buffer += buffer;
            timestamp = System.nanoTime();
        }

        public boolean isExpired() {
            return (System.nanoTime() - timestamp) > 1000000000;
        }
    }

    private ArrayMap<Integer, ScanBuffer> buffers = new ArrayMap<Integer, ScanBuffer>();

    @Override
    public synchronized boolean handle(KeyEvent event) {
        InputDevice device = event.getDevice();
        int device_id = device.getId();

        String device_name;

        // TODO: Add sunmi_blink
        if((device.getVendorId() == 7851 && device.getProductId() == 6659) || device.getName().contains("NS021")) {
            // Newland Auto-ID NS021 USB HID Keyboard; VID: 7851; PID: 6659
            device_name = "sunmi_scanner";
        } else if((device.getVendorId() == 0 && device.getProductId() == 0) || device.getName().contains("Virtual")) {
            // Built In Scanner
            device_name = "sunmi_builtin";
        } else {
            return false;
        }

        if(event.getAction() != ACTION_UP)
            return true;

        if(KeyEvent.isModifierKey(event.getKeyCode()))
            return true;

        if(event.getKeyCode() == KEYCODE_ENTER) {
            if(!buffers.containsKey(device_id))
                return true;

            try {
                JSONObject json = new JSONObject();
                json.put("barcode", buffers.get(device_id).getBuffer());
                json.put("device", device_name);
                json.put("id", device_id);

                bridge.triggerWindowJSEvent("sunmi_barcode_scan", json.toString(3));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            buffers.remove(device_id);

            return true;
        }

        if(buffers.containsKey(device_id) && buffers.get(device_id).isExpired()) {
            buffers.remove(device_id);
        }

        String pressed_value = Character.toString((char) event.getUnicodeChar());

        if (buffers.containsKey(device_id)){
            buffers.get(device_id).appendBuffer(pressed_value);
        } else {
            buffers.put(device_id, new ScanBuffer(pressed_value));
        }

        return true;
    }
}
