package dev.duma.capacitor.sunmikeyboardhandler;

import android.util.ArrayMap;
import android.util.Pair;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONArray;

import java.util.Map;
import java.util.Objects;

import dev.duma.capacitor.sunmikeyboardhandler.enums.HandleableKeyEnum;
import dev.duma.capacitor.sunmikeyboardhandler.enums.KeyEventEnum;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.DebugKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiBarcodeScannerKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiKeyboardKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2kRfidKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2kShortcutKeyHandler;
import dev.duma.capacitor.sunmikeyboardhandler.handlers.SunmiL2sShortcutKeyHandler;

@CapacitorPlugin(name = "SunmiKeyboardHandler")
public class SunmiKeyboardHandlerPlugin extends Plugin implements KeyHandlerInterface {
    protected Map<HandleableKeyEnum, Pair<String, KeyHandlerInterface>> keyHandlers = new ArrayMap<>();

    @Override
    public void load() {
        super.load();

        HasKeyHandlersInterface activity = (HasKeyHandlersInterface) getActivity();

        activity.setKeyHandler(this);
    }

    @Override
    public boolean handle(KeyEvent event) {

        for (Map.Entry<HandleableKeyEnum, Pair<String, KeyHandlerInterface>> entry : keyHandlers.entrySet()) {
            if(entry.getValue().second.handle(event))
                return true;
        }

        return false;
    }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void setKeyHandler(PluginCall call) {
        HandleableKeyEnum key = HandleableKeyEnum.valueOfLabel(call.getString("key"));

        if(key == null) {
            call.reject("Invalid key");
            return;
        }

        if(keyHandlers.containsKey(key)) {
            call.reject("Key handler is already set");
            return;
        }

        switch (key) {
            case Esc:
            case F1:
            case F2:
            case F3:
            case F4:
            case F5:
            case F6:
            case F7:
            case F8:
            case F9:
            case F10:
            case Delete:
            case Home:
            case End:
            case PgUp:
            case PgDn:
            case Cash:
                call.setKeepAlive(true);
                bridge.saveCall(call);

                String KeyboardCallbackId = call.getCallbackId();
                SunmiKeyboardKeyHandler sunmiKeyboardKeyHandler = new SunmiKeyboardKeyHandler(key, (modifiers, pressed) -> {
                    PluginCall c = bridge.getSavedCall(KeyboardCallbackId);

                    if (c == null)
                        return;

                    JSObject data = new JSObject();

                    data.put("key", key.toString());
                    JSONArray m = new JSONArray();
                    for (int i = 0; i < modifiers.size(); i++) {
                        m.put(modifiers.get(i).toString());
                    }
                    data.put("modifiers", m);
                    data.put("type", pressed ? KeyEventEnum.KeyDown.toString() : KeyEventEnum.KeyUp.toString());

                    c.resolve(data);
                });

                keyHandlers.put(key, new Pair<>(call.getCallbackId(), sunmiKeyboardKeyHandler));
                break;

            case L2s_Shortcut_or_RFID:
                call.setKeepAlive(true);
                bridge.saveCall(call);

                String L2SCallbackId = call.getCallbackId();
                SunmiL2sShortcutKeyHandler sunmiL2sShortcutKeyHandler = new SunmiL2sShortcutKeyHandler((pressed) -> {
                    PluginCall c = bridge.getSavedCall(L2SCallbackId);

                    if (c == null)
                        return;

                    JSObject data = new JSObject();

                    data.put("key", HandleableKeyEnum.L2s_Shortcut_or_RFID.toString());
                    data.put("modifiers", new JSONArray());
                    data.put("type", pressed ? KeyEventEnum.KeyDown.toString() : KeyEventEnum.KeyUp.toString());

                    c.resolve(data);
                });

                keyHandlers.put(HandleableKeyEnum.L2s_Shortcut_or_RFID, new Pair<>(call.getCallbackId(), sunmiL2sShortcutKeyHandler));
                break;

            case L2k_Shortcut:
                call.setKeepAlive(true);
                bridge.saveCall(call);

                String L2kShortcutCallbackId = call.getCallbackId();
                SunmiL2kShortcutKeyHandler sunmiL2kShortcutKeyHandler = new SunmiL2kShortcutKeyHandler((pressed) -> {
                    PluginCall c = bridge.getSavedCall(L2kShortcutCallbackId);

                    if (c == null)
                        return;

                    JSObject data = new JSObject();

                    data.put("key", HandleableKeyEnum.L2k_Shortcut.toString());
                    data.put("modifiers", new JSONArray());
                    data.put("type", pressed ? KeyEventEnum.KeyDown.toString() : KeyEventEnum.KeyUp.toString());

                    c.resolve(data);
                });

                keyHandlers.put(HandleableKeyEnum.L2k_Shortcut, new Pair<>(call.getCallbackId(), sunmiL2kShortcutKeyHandler));
                break;

            case L2k_RFID:
                call.setKeepAlive(true);
                bridge.saveCall(call);

                String L2kRfidCallbackId = call.getCallbackId();
                SunmiL2kRfidKeyHandler sunmiL2kRfidKeyHandler = new SunmiL2kRfidKeyHandler((pressed) -> {
                    PluginCall c = bridge.getSavedCall(L2kRfidCallbackId);

                    if (c == null)
                        return;

                    JSObject data = new JSObject();

                    data.put("key", HandleableKeyEnum.L2k_RFID.toString());
                    data.put("modifiers", new JSONArray());
                    data.put("type", pressed ? KeyEventEnum.KeyDown.toString() : KeyEventEnum.KeyUp.toString());

                    c.resolve(data);
                });

                keyHandlers.put(HandleableKeyEnum.L2k_RFID, new Pair<>(call.getCallbackId(), sunmiL2kRfidKeyHandler));
                break;

            case Barcode:
                call.reject("Barcode handler is not settable using this method");
                break;

            case Debug:
                call.reject("Debug handler is not settable using this method");
                break;
        }

    }

    @PluginMethod()
    public void removeKeyHandler(PluginCall call) {
        HandleableKeyEnum key = HandleableKeyEnum.valueOfLabel(call.getString("key"));

        if(key == null) {
            call.reject("Invalid key");
            return;
        }

        if(!keyHandlers.containsKey(key)) {
            call.reject("Key handler not set");
            return;
        }

        String callbackId = Objects.requireNonNull(keyHandlers.get(key)).first;

        bridge.releaseCall(callbackId);

        keyHandlers.remove(key);

        call.resolve();
    }

    private String BarcodeHandlerCallbackId = null;

    @Nullable
    protected PluginCall getBarcodeHandlerCall() {
        if (BarcodeHandlerCallbackId == null)
            return null;

        return bridge.getSavedCall(BarcodeHandlerCallbackId);
    }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void setBarcodeHandler(PluginCall call) {
        if (BarcodeHandlerCallbackId != null) {
            call.reject("Barcode handler already set");
            return;
        }

        BarcodeHandlerCallbackId = call.getCallbackId();
        call.setKeepAlive(true);
        bridge.saveCall(call);

        SunmiBarcodeScannerKeyHandler handler = new SunmiBarcodeScannerKeyHandler((barcode, device, id) -> {
            PluginCall c = getBarcodeHandlerCall();

            if (c == null)
                return;

            JSObject data = new JSObject();

            data.put("barcode", barcode);
            JSObject d = new JSObject();
            d.put("type", device);
            d.put("id", id);
            data.put("device", d);

            c.resolve(data);
        });

        keyHandlers.put(HandleableKeyEnum.Barcode, new Pair<>(BarcodeHandlerCallbackId, handler));
    }

    @PluginMethod()
    public void removeBarcodeHandler(PluginCall call) {
        if (BarcodeHandlerCallbackId != null) {
            bridge.releaseCall(BarcodeHandlerCallbackId);
            BarcodeHandlerCallbackId = null;
        }

        keyHandlers.remove(HandleableKeyEnum.Barcode);

        call.resolve();
    }

    private String DebugHandlerCallbackId = null;

    @Nullable
    protected PluginCall getDebugHandlerCall() {
        if (DebugHandlerCallbackId == null)
            return null;

        return bridge.getSavedCall(DebugHandlerCallbackId);
    }

    @PluginMethod(returnType = PluginMethod.RETURN_CALLBACK)
    public void setDebugHandler(PluginCall call) {
        if (DebugHandlerCallbackId != null) {
            call.reject("Debug handler already set");
            return;
        }

        DebugHandlerCallbackId = call.getCallbackId();
        call.setKeepAlive(true);
        bridge.saveCall(call);

        DebugKeyHandler handler = new DebugKeyHandler((event) -> {
            PluginCall c = getDebugHandlerCall();

            if (c == null)
                return;

            JSObject data = new JSObject();

            data.put("event", event.toString());
            data.put("eventKeyCode", event.getKeyCode());
            data.put("device", event.getDevice().toString());
            data.put("deviceVendorId", event.getDevice().getVendorId());
            data.put("deviceProductId", event.getDevice().getProductId());
            data.put("deviceName", event.getDevice().getName());

            c.resolve(data);
        });

        keyHandlers.put(HandleableKeyEnum.Debug, new Pair<>(DebugHandlerCallbackId, handler));
    }

    @PluginMethod()
    public void removeDebugHandler(PluginCall call) {
        if (DebugHandlerCallbackId != null) {
            bridge.releaseCall(DebugHandlerCallbackId);
            DebugHandlerCallbackId = null;
        }

        keyHandlers.remove(HandleableKeyEnum.Debug);

        call.resolve();
    }
}