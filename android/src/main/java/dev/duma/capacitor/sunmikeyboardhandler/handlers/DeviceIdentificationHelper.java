package dev.duma.capacitor.sunmikeyboardhandler.handlers;

import android.view.InputDevice;
import android.view.KeyEvent;

public class DeviceIdentificationHelper {
    /**
     * USB-HID PayKeyboard; VID: 7847; PID: 2322
     */
    public static boolean isSunmi89KeyKeyboard(InputDevice device) {
        return (device.getVendorId() == 7847 && device.getProductId() == 2322) || device.getName().contains("USB-HID PayKeyboard");
    }

    /**
     * Sunmi L2Ks
     */
    public static boolean isSunmiL2KsFunctionKeysKeyboard(InputDevice device) {
        boolean keypad = device.getVendorId() == 0 && device.getProductId() == 0 && device.getName().contains("aw9523-key");
        boolean r_dpad = device.getVendorId() == 1 && device.getProductId() == 1 && device.getName().contains("mtk-pmic-keys");
        boolean l_dpad = device.getVendorId() == 0 && device.getProductId() == 0 && device.getName().contains("mtk-kpd");

        return keypad || r_dpad || l_dpad;
    }

    /**
     * Newland Auto-ID NS021 USB HID Keyboard; VID: 7851; PID: 6659
     */
    public static boolean isSunmiHandheldScanner(InputDevice device) {
        return (device.getVendorId() == 7851 && device.getProductId() == 6659) || device.getName().contains("NS021");
    }

    /**
     * ??; VID: 8401; PID: 28682
     */
    public static boolean isSunmiBlinkScanner(InputDevice device) {
        return (device.getVendorId() == 8401 && device.getProductId() == 28682) || device.getName().contains("SM-2D");
    }

    /**
     * Sunmi L2K built-in keyboard
     */
    private static boolean isSunmiL2KKeyboard(InputDevice device) {
        return device.getVendorId() == 0 && device.getProductId() == 0 && device.getName().contains("soc:matrix-keypad");
    }

    /**
     * Sunmi L2Ks built-in keyboard
     */
    private static boolean isSunmiL2KsKeyboard(InputDevice device, KeyEvent event) {
        boolean isVirtualDevice = (device.getVendorId() == 0 && device.getProductId() == 0);

        if(!isVirtualDevice) return false;

        if (device.getName().contains("mtk-kpd")) return true;
        if (device.getName().contains("mtk-pmic-keys")) return true;
        if (device.getName().contains("aw9523-key")) return true;
        if (device.getName().contains("Virtual") && event.getSource() == 0x101) return true;

        return false;
    }

    /**
     *
     */
    public static boolean isSunmiBuiltInScanner(InputDevice device, KeyEvent event) {
        boolean isVirtualDevice = (device.getVendorId() == 0 && device.getProductId() == 0) || device.getName().contains("Virtual");

        if (!isVirtualDevice) return false;
        if (isSunmiL2KKeyboard(device)) return false;
        if (isSunmiL2KsKeyboard(device, event)) return false;

        return true;
    }
}