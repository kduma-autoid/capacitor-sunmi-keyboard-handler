package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.KEYCODE_DPAD_DOWN;
import static android.view.KeyEvent.KEYCODE_ENTER;

import android.util.ArrayMap;
import android.view.InputDevice;
import android.view.KeyEvent;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;

public class SunmiBarcodeScannerKeyHandler implements IHandler {
    protected Callback callback;

    public SunmiBarcodeScannerKeyHandler(Callback callback) {
        this.callback = callback;
    }

    @Override
    public boolean provides(HandleableKeyEnum key) {
        return EnumSet.of(
                HandleableKeyEnum.Barcode_Any,
                HandleableKeyEnum.Barcode_BuiltIn,
                HandleableKeyEnum.Barcode_Handheld,
                HandleableKeyEnum.Barcode_Blink
        ).contains(key);
    }

    @Override
    public boolean canBeHandled(KeyEvent event, EnumSet<HandleableKeyEnum> handledKeys) {
        InputDevice device = event.getDevice();

        HandleableKeyEnum pressedKey = null;
        if(DeviceIdentificationHelper.isSunmiHandheldScanner(device)) {
            pressedKey = HandleableKeyEnum.Barcode_Handheld;
        } else if(DeviceIdentificationHelper.isSunmiBlinkScanner(device)) {
            pressedKey = HandleableKeyEnum.Barcode_Blink;
        } else if(DeviceIdentificationHelper.isSunmiBuiltInScanner(device, event)) {
            pressedKey = HandleableKeyEnum.Barcode_BuiltIn;
        } else {
            return false;
        }

        return handledKeys.contains(pressedKey) || handledKeys.contains(HandleableKeyEnum.Barcode_Any);
    }

    @Override
    public synchronized boolean handle(KeyEvent event) {
        InputDevice device = event.getDevice();
        int device_id = device.getId();

        String device_name;

        if(DeviceIdentificationHelper.isSunmiHandheldScanner(device)) {
            device_name = "sunmi_scanner";
        } else if(DeviceIdentificationHelper.isSunmiBlinkScanner(device)) {
            device_name = "sunmi_blink";
        } else if(DeviceIdentificationHelper.isSunmiBuiltInScanner(device, event)) {
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

            callback.onBarcodeScanned(Objects.requireNonNull(buffers.get(device_id)).getBuffer(), device_name, device_id);

            buffers.remove(device_id);

            return true;
        }

        if(buffers.containsKey(device_id) && Objects.requireNonNull(buffers.get(device_id)).isExpired()) {
            buffers.remove(device_id);
        }

        char c = (char) event.getUnicodeChar();

        if (c == 0)
            return true;

        String pressed_value = Character.toString(c);

        if (buffers.containsKey(device_id)){
            Objects.requireNonNull(buffers.get(device_id)).appendBuffer(pressed_value);
        } else {
            buffers.put(device_id, new ScanBuffer(pressed_value));
        }

        return true;
    }

    private final ArrayMap<Integer, ScanBuffer> buffers = new ArrayMap<>();

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
}
