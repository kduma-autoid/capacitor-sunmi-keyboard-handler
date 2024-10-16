package dev.duma.capacitor.sunmikeyboardhandler;

import android.view.KeyEvent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.KeyEventEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.ModifierKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.DebugKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.IHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.Sunmi89KeyKeyPadHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.Sunmi89KeyKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.Sunmi89KeyNumPadHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiBarcodeScannerKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2HShortcutKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KNumPadHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KsKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KsNumPadHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2kShortcutKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2ksShortcutKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2sShortcutKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiRfidKeyHandler;

@CapacitorPlugin(name = "SunmiKeyboardHandler")
public class SunmiKeyboardHandlerPlugin extends Plugin implements KeyHandlerInterface {
    protected IHandler.Callback callback = new IHandler.Callback() {
        @Override
        public void onKeyPressed(HandleableKeyEnum key, boolean pressed, ArrayList<ModifierKeyEnum> modifiers) {
            JSONArray mod = new JSONArray();
            for (int i = 0; i < modifiers.size(); i++) {
                mod.put(modifiers.get(i).toString());
            }

            JSObject ret = new JSObject();
            ret.put("key", key.toString());
            ret.put("modifiers", mod);
            ret.put("type", pressed ? KeyEventEnum.KeyDown.toString() : KeyEventEnum.KeyUp.toString());

            notifyListeners("onKeyPressed", ret);
        }

        @Override
        public void onBarcodeScanned(String barcode, String device, int id) {
            JSObject dev = new JSObject();
            dev.put("type", device);
            dev.put("id", id);

            JSObject ret = new JSObject();
            ret.put("barcode", barcode);
            ret.put("device", dev);

            notifyListeners("onBarcodeScanned", ret);
        }

        @Override
        public void onDebug(KeyEvent event) {
            if(event.getRepeatCount() != 0)
                return;

            JSObject device = new JSObject();
            device.put("vendor-id", event.getDevice().getVendorId());
            device.put("product-id", event.getDevice().getProductId());
            device.put("name", event.getDevice().getName());
            device.put("other", event.getDevice().toString());

            JSObject ret = new JSObject();
            ret.put("char", Character.toString((char) event.getUnicodeChar()));
            ret.put("number", Character.toString((char) event.getNumber()));
            ret.put("label", Character.toString((char) event.getDisplayLabel()));
            ret.put("key-code", KeyEvent.keyCodeToString(event.getKeyCode()));
            ret.put("action", switch(event.getAction()) {
                case KeyEvent.ACTION_DOWN -> "ACTION_DOWN";
                case KeyEvent.ACTION_UP -> "ACTION_UP";
                case KeyEvent.ACTION_MULTIPLE -> "ACTION_MULTIPLE";
                default -> "UNKNOWN";
            });
            ret.put("device", device);
            ret.put("event", event.toString());

            notifyListeners("onDebug", ret);
        }

        @Override
        public void onKeyboardInput(HandleableKeyEnum groupKey, char value, HandleableKeyEnum key, boolean isWhiteChar) {
            JSObject ret = new JSObject();
            ret.put("groupKey", groupKey.toString());
            ret.put("key", key.toString());
            ret.put("value", value != 0 ? Character.toString(value) : null);
            ret.put("isWhiteChar", isWhiteChar);

            notifyListeners("onKeyboardInput", ret);
        }
    };

    protected List<IHandler> keyHandlers = null;
    protected List<IHandler> allKeyHandlers = new ArrayList<>(Arrays.asList(
            new SunmiL2sShortcutKeyHandler(callback),
            new SunmiL2HShortcutKeyHandler(callback),
            new SunmiL2kShortcutKeyHandler(callback),
            new SunmiL2ksShortcutKeyHandler(callback),
            new SunmiRfidKeyHandler(callback),

            new SunmiL2KKeyboardKeyHandler(callback),
            new SunmiL2KsKeyboardKeyHandler(callback),
            new Sunmi89KeyKeyboardKeyHandler(callback),

            new SunmiBarcodeScannerKeyHandler(callback),

            new Sunmi89KeyKeyPadHandler(callback),
            new Sunmi89KeyNumPadHandler(callback),
            new SunmiL2KsNumPadHandler(callback),
            new SunmiL2KNumPadHandler(callback),

            new DebugKeyHandler(callback)
    ));

    protected EnumSet<HandleableKeyEnum> handledKeys = EnumSet.noneOf(HandleableKeyEnum.class);

    @Override
    public void load() {
        super.load();

        HasKeyHandlersInterface activity = (HasKeyHandlersInterface) getActivity();

        activity.setKeyHandler(this);
    }

    @Override
    public boolean handle(KeyEvent event) {
        if(keyHandlers == null) {
            keyHandlers = new ArrayList<>();

            for (IHandler handler : allKeyHandlers) {
                for (HandleableKeyEnum key : handledKeys) {
                    if(handler.provides(key)) {
                        keyHandlers.add(handler);
                        break;
                    }
                }
            }
        }

        for (IHandler handler : keyHandlers) {
            if(handler.canBeHandled(event, handledKeys) && handler.handle(event))
                return true;
        }

        return false;
    }

    @PluginMethod
    public void enableHandler(PluginCall call) {
        HandleableKeyEnum key = HandleableKeyEnum.valueOfLabel(call.getString("key"));

        if(key == null) {
            call.reject("Invalid key");
            return;
        }

        handledKeys.add(key);
        keyHandlers = null;

        call.resolve();
    }

    @PluginMethod
    public void disableHandler(PluginCall call) {
        HandleableKeyEnum key = HandleableKeyEnum.valueOfLabel(call.getString("key"));

        if(key == null) {
            call.reject("Invalid key");
            return;
        }

        handledKeys.remove(key);
        keyHandlers = null;

        call.resolve();
    }
}