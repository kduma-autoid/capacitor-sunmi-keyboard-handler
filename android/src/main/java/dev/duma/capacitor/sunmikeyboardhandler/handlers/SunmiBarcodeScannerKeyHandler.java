package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.ACTION_UP;
import static android.view.KeyEvent.KEYCODE_DPAD_DOWN;
import static android.view.KeyEvent.KEYCODE_ENTER;

import android.util.ArrayMap;
import android.view.InputDevice;
import android.view.KeyEvent;

import com.getcapacitor.Bridge;

import org.json.JSONException;
import org.json.JSONObject;

import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class SunmiBarcodeScannerKeyHandler implements KeyHandlerInterface {
    public interface SunmiBarcodeScannerKeyHandlerCallback {
        void onBarcodeScanned(String barcode, String device, int id);
    }

    protected SunmiBarcodeScannerKeyHandlerCallback callback;

    public SunmiBarcodeScannerKeyHandler(SunmiBarcodeScannerKeyHandlerCallback callback) {
        this.callback = callback;
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

        if((device.getVendorId() == 7851 && device.getProductId() == 6659) || device.getName().contains("NS021")) {
            // Newland Auto-ID NS021 USB HID Keyboard; VID: 7851; PID: 6659
            device_name = "sunmi_scanner";
        } else if((device.getVendorId() == 8401 && device.getProductId() == 28682) || device.getName().contains("SM-2D")) {
            // Newland Auto-ID NS021 USB HID Keyboard; VID: 8401; PID: 28682
            device_name = "sunmi_blink";
        } else if(((device.getVendorId() == 0 && device.getProductId() == 0) || device.getName().contains("Virtual"))) {
            if(device.getName().contains("soc:matrix-keypad")) // Sunmi L2k built-in keyboard
                return false;

            if(device.getName().contains("mtk-kpd") || device.getName().contains("mtk-pmic-keys") || device.getName().contains("aw9523-key") || device.getName().contains("Virtual") && event.getSource() == 0x101) // Sunmi L2ks built-in keyboard
                return false;

            // Built In Scanner
            device_name = "sunmi_builtin";
        } else {
            return false;
        }

        if(event.getAction() != ACTION_DOWN)
            return true;

        if(KeyEvent.isModifierKey(event.getKeyCode()))
            return true;

        if(event.getKeyCode() == KEYCODE_ENTER || event.getKeyCode() == KEYCODE_DPAD_DOWN) {
            if(!buffers.containsKey(device_id))
                return true;

            callback.onBarcodeScanned(buffers.get(device_id).getBuffer(), device_name, device_id);

            buffers.remove(device_id);

            return true;
        }

        if(buffers.containsKey(device_id) && buffers.get(device_id).isExpired()) {
            buffers.remove(device_id);
        }

        char c = (char) event.getUnicodeChar();

        if (c == 0)
            return true;

        String pressed_value = Character.toString(c);

        if (buffers.containsKey(device_id)){
            buffers.get(device_id).appendBuffer(pressed_value);
        } else {
            buffers.put(device_id, new ScanBuffer(pressed_value));
        }

        return true;
    }
}
