package dev.duma.capacitor.sunmikeyboardhandler;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SunmiKeyboardHandler")
public class SunmiKeyboardHandlerPlugin extends Plugin {
    private SunmiKeyboardHandler implementation = new SunmiKeyboardHandler();

    @Override
    public void load() {
        super.load();

        HasKeyHandlersInterface activity = (HasKeyHandlersInterface) getActivity();

        activity.registerKeyHandler(new SunmiKeyboardKeyHandler(getBridge()));
        activity.registerKeyHandler(new SunmiBarcodeScannerKeyHandler(getBridge()));
        activity.registerKeyHandler(new SunmiL2sShortcutKeyHandler(getBridge()));
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }
}
