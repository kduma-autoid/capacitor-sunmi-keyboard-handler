# @kduma-autoid/capacitor-sunmi-keyboard-handler

Handler for processing input from Sunmi hardware barcode scanners (builtin and external) and external Sunmi programmable keyboard.

## Install

```bash
npm install @kduma-autoid/capacitor-sunmi-keyboard-handler
npx cap sync
```

Modify your `MainActivity.java` file to include the following:

```java
package com.example.plugin;

import android.view.KeyEvent;

import com.getcapacitor.BridgeActivity;

import dev.duma.capacitor.sunmikeyboardhandler.HasKeyHandlersInterface;
import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class MainActivity extends BridgeActivity implements HasKeyHandlersInterface {
    private KeyHandlerInterface keyHandler = null;

    public KeyHandlerInterface getKeyHandler() {
        return keyHandler;
    }

    public void setKeyHandler(KeyHandlerInterface keyHandler) {
        this.keyHandler = keyHandler;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        KeyHandlerInterface handler = getKeyHandler();

        if (handler != null && handler.handle(event)) return true;

        return super.dispatchKeyEvent(event);
    }
}
```

## API

<docgen-index>

* [`enableHandler(...)`](#enablehandler)
* [`disableHandler(...)`](#disablehandler)
* [`addListener('onKeyPressed', ...)`](#addlisteneronkeypressed)
* [`addListener('onBarcodeScanned', ...)`](#addlisteneronbarcodescanned)
* [`addListener('onDebug', ...)`](#addlistenerondebug)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### enableHandler(...)

```typescript
enableHandler(options: { key: HandleableKey; }) => Promise<void>
```

Set a callback to be called when a key specified in `key` parameter is pressed.

| Param         | Type                                                              |
| ------------- | ----------------------------------------------------------------- |
| **`options`** | <code>{ key: <a href="#handleablekey">HandleableKey</a>; }</code> |

--------------------


### disableHandler(...)

```typescript
disableHandler(options: { key: HandleableKey; }) => Promise<void>
```

Remove a callback set by `setKeyHandler` for a key specified in `key` parameter.

| Param         | Type                                                              |
| ------------- | ----------------------------------------------------------------- |
| **`options`** | <code>{ key: <a href="#handleablekey">HandleableKey</a>; }</code> |

--------------------


### addListener('onKeyPressed', ...)

```typescript
addListener(eventName: 'onKeyPressed', listenerFunc: OnKeyPressedCallback) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                                                  |
| ------------------ | --------------------------------------------------------------------- |
| **`eventName`**    | <code>'onKeyPressed'</code>                                           |
| **`listenerFunc`** | <code><a href="#onkeypressedcallback">OnKeyPressedCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onBarcodeScanned', ...)

```typescript
addListener(eventName: 'onBarcodeScanned', listenerFunc: OnBarcodeScannedCallback) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                                                          |
| ------------------ | ----------------------------------------------------------------------------- |
| **`eventName`**    | <code>'onBarcodeScanned'</code>                                               |
| **`listenerFunc`** | <code><a href="#onbarcodescannedcallback">OnBarcodeScannedCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onDebug', ...)

```typescript
addListener(eventName: 'onDebug', listenerFunc: OnDebugCallback) => Promise<PluginListenerHandle> & PluginListenerHandle
```

| Param              | Type                                                        |
| ------------------ | ----------------------------------------------------------- |
| **`eventName`**    | <code>'onDebug'</code>                                      |
| **`listenerFunc`** | <code><a href="#ondebugcallback">OnDebugCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### OnKeyPressedCallback

<code>(data: { key: <a href="#handleablekey">HandleableKey</a>; modifiers: ModifierKey[]; type: <a href="#keyevent">KeyEvent</a>; }): void</code>


#### OnBarcodeScannedCallback

<code>(data: { barcode: string; device: { type: string; id: number; }; }): void</code>


#### OnDebugCallback

<code>(data: any): void</code>


### Enums


#### HandleableKey

| Members                         | Value                           |
| ------------------------------- | ------------------------------- |
| **`Sunmi89KeyKeyboard_Esc`**    | <code>"89_ESC"</code>           |
| **`Sunmi89KeyKeyboard_F1`**     | <code>"89_F1"</code>            |
| **`Sunmi89KeyKeyboard_F2`**     | <code>"89_F2"</code>            |
| **`Sunmi89KeyKeyboard_F3`**     | <code>"89_F3"</code>            |
| **`Sunmi89KeyKeyboard_F4`**     | <code>"89_F4"</code>            |
| **`Sunmi89KeyKeyboard_F5`**     | <code>"89_F5"</code>            |
| **`Sunmi89KeyKeyboard_F6`**     | <code>"89_F6"</code>            |
| **`Sunmi89KeyKeyboard_F7`**     | <code>"89_F7"</code>            |
| **`Sunmi89KeyKeyboard_F8`**     | <code>"89_F8"</code>            |
| **`Sunmi89KeyKeyboard_F9`**     | <code>"89_F9"</code>            |
| **`Sunmi89KeyKeyboard_F10`**    | <code>"89_F10"</code>           |
| **`Sunmi89KeyKeyboard_Delete`** | <code>"89_DELETE"</code>        |
| **`Sunmi89KeyKeyboard_Home`**   | <code>"89_HOME"</code>          |
| **`Sunmi89KeyKeyboard_End`**    | <code>"89_END"</code>           |
| **`Sunmi89KeyKeyboard_PgUp`**   | <code>"89_PGUP"</code>          |
| **`Sunmi89KeyKeyboard_PgDn`**   | <code>"89_PGDN"</code>          |
| **`Sunmi89KeyKeyboard_Cash`**   | <code>"89_CASH"</code>          |
| **`L2Ks_F1`**                   | <code>"L2KS_F1"</code>          |
| **`L2Ks_F2`**                   | <code>"L2KS_F2"</code>          |
| **`L2Ks_F3`**                   | <code>"L2KS_F3"</code>          |
| **`L2Ks_F4`**                   | <code>"L2KS_F4"</code>          |
| **`L2Ks_F5`**                   | <code>"L2KS_F5"</code>          |
| **`L2Ks_F6`**                   | <code>"L2KS_F6"</code>          |
| **`L2Ks_F7`**                   | <code>"L2KS_F7"</code>          |
| **`L2Ks_F8`**                   | <code>"L2KS_F8"</code>          |
| **`L2Ks_F9`**                   | <code>"L2KS_F9"</code>          |
| **`L2Ks_BACK`**                 | <code>"L2KS_BACK"</code>        |
| **`L2Ks_ENTER`**                | <code>"L2KS_ENTER"</code>       |
| **`L2Ks_STAR`**                 | <code>"L2KS_STAR"</code>        |
| **`L2Ks_SPACE`**                | <code>"L2KS_SPACE"</code>       |
| **`L2Ks_POUND`**                | <code>"L2KS_POUND"</code>       |
| **`L2Ks_DEL`**                  | <code>"L2KS_DEL"</code>         |
| **`L2Ks_UP`**                   | <code>"L2KS_UP"</code>          |
| **`L2Ks_DOWN`**                 | <code>"L2KS_DOWN"</code>        |
| **`L2Ks_LEFT`**                 | <code>"L2KS_LEFT"</code>        |
| **`L2Ks_RIGHT`**                | <code>"L2KS_RIGHT"</code>       |
| **`L2Ks_1`**                    | <code>"L2KS_1"</code>           |
| **`L2Ks_2`**                    | <code>"L2KS_2"</code>           |
| **`L2Ks_3`**                    | <code>"L2KS_3"</code>           |
| **`L2Ks_4`**                    | <code>"L2KS_4"</code>           |
| **`L2Ks_5`**                    | <code>"L2KS_5"</code>           |
| **`L2Ks_6`**                    | <code>"L2KS_6"</code>           |
| **`L2Ks_7`**                    | <code>"L2KS_7"</code>           |
| **`L2Ks_8`**                    | <code>"L2KS_8"</code>           |
| **`L2Ks_9`**                    | <code>"L2KS_9"</code>           |
| **`L2Ks_0`**                    | <code>"L2KS_0"</code>           |
| **`L2Ks_PERIOD`**               | <code>"L2KS_PERIOD"</code>      |
| **`L2K_TAB`**                   | <code>"L2K_TAB"</code>          |
| **`L2K_ENTER`**                 | <code>"L2K_ENTER"</code>        |
| **`L2K_P1`**                    | <code>"L2K_P1"</code>           |
| **`L2K_1`**                     | <code>"L2K_1"</code>            |
| **`L2K_2`**                     | <code>"L2K_2"</code>            |
| **`L2K_3`**                     | <code>"L2K_3"</code>            |
| **`L2K_4`**                     | <code>"L2K_4"</code>            |
| **`L2K_5`**                     | <code>"L2K_5"</code>            |
| **`L2K_6`**                     | <code>"L2K_6"</code>            |
| **`L2K_7`**                     | <code>"L2K_7"</code>            |
| **`L2K_8`**                     | <code>"L2K_8"</code>            |
| **`L2K_9`**                     | <code>"L2K_9"</code>            |
| **`L2K_0`**                     | <code>"L2K_0"</code>            |
| **`L2K_PERIOD`**                | <code>"L2K_PERIOD"</code>       |
| **`L2K_SPACE`**                 | <code>"L2K_SPACE"</code>        |
| **`L2K_MINUS`**                 | <code>"L2K_MINUS"</code>        |
| **`L2K_DEL`**                   | <code>"L2K_DEL"</code>          |
| **`L2K_UP`**                    | <code>"L2K_UP"</code>           |
| **`L2K_DOWN`**                  | <code>"L2K_DOWN"</code>         |
| **`L2K_LEFT`**                  | <code>"L2K_LEFT"</code>         |
| **`L2K_RIGHT`**                 | <code>"L2K_RIGHT"</code>        |
| **`L2K_CENTER`**                | <code>"L2K_CENTER"</code>       |
| **`L2s_Shortcut`**              | <code>"L2S_SHORTCUT"</code>     |
| **`L2k_Shortcut`**              | <code>"L2K_SHORTCUT"</code>     |
| **`Sunmi_RFID`**                | <code>"RFID"</code>             |
| **`Barcode_Any`**               | <code>"BARCODE"</code>          |
| **`Barcode_BuiltIn`**           | <code>"BARCODE_BUILTIN"</code>  |
| **`Barcode_Handheld`**          | <code>"BARCODE_HANDHELD"</code> |
| **`Barcode_Blink`**             | <code>"BARCODE_BLINK"</code>    |
| **`Debug`**                     | <code>"DEBUG"</code>            |


#### ModifierKey

| Members        | Value                   |
| -------------- | ----------------------- |
| **`Alt`**      | <code>"ALT"</code>      |
| **`Ctrl`**     | <code>"CTRL"</code>     |
| **`Shift`**    | <code>"SHIFT"</code>    |
| **`CapsLock`** | <code>"CAPSLOCK"</code> |


#### KeyEvent

| Members       | Value                   |
| ------------- | ----------------------- |
| **`KeyDown`** | <code>"KEY_DOWN"</code> |
| **`KeyUp`**   | <code>"KEY_UP"</code>   |

</docgen-api>
