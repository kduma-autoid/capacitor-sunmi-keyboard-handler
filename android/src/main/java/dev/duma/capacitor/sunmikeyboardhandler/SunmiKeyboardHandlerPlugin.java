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
import dev.duma.capacitor.sunmikeyboardhandler.handlers.Sunmi89KeyKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiBarcodeScannerKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2KsKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2kShortcutKeyHandler;
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
            JSObject ret = new JSObject();
            ret.put("event", event.toString());
            ret.put("source", event.getSource());
            ret.put("eventKeyCode", event.getKeyCode());
            ret.put("device", event.getDevice().toString());
            ret.put("deviceVendorId", event.getDevice().getVendorId());
            ret.put("deviceProductId", event.getDevice().getProductId());
            ret.put("deviceName", event.getDevice().getName());

            notifyListeners("onDebug", ret);
        }
    };

    protected List<IHandler> keyHandlers = new ArrayList<>(Arrays.asList(
            new SunmiL2sShortcutKeyHandler(callback),
            new SunmiL2kShortcutKeyHandler(callback),
            new SunmiRfidKeyHandler(callback),

            new SunmiL2KKeyboardKeyHandler(callback),
            new SunmiL2KsKeyboardKeyHandler(callback),
            new Sunmi89KeyKeyboardKeyHandler(callback),

            new SunmiBarcodeScannerKeyHandler(callback),

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
        for (IHandler handler : keyHandlers) {
            if(!handler.canBeHandled(event, handledKeys))
                continue;

            handler.handle(event);
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

        call.resolve();
    }
}