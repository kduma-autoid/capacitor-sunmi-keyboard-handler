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
* [`addListener('onKeyboardInput', ...)`](#addlisteneronkeyboardinput)
* [`removeAllListeners()`](#removealllisteners)
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
addListener(eventName: 'onKeyPressed', listenerFunc: OnKeyPressedCallback) => Promise<PluginListenerHandle>
```

| Param              | Type                                                                  |
| ------------------ | --------------------------------------------------------------------- |
| **`eventName`**    | <code>'onKeyPressed'</code>                                           |
| **`listenerFunc`** | <code><a href="#onkeypressedcallback">OnKeyPressedCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('onBarcodeScanned', ...)

```typescript
addListener(eventName: 'onBarcodeScanned', listenerFunc: OnBarcodeScannedCallback) => Promise<PluginListenerHandle>
```

| Param              | Type                                                                          |
| ------------------ | ----------------------------------------------------------------------------- |
| **`eventName`**    | <code>'onBarcodeScanned'</code>                                               |
| **`listenerFunc`** | <code><a href="#onbarcodescannedcallback">OnBarcodeScannedCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('onDebug', ...)

```typescript
addListener(eventName: 'onDebug', listenerFunc: OnDebugCallback) => Promise<PluginListenerHandle>
```

| Param              | Type                                                        |
| ------------------ | ----------------------------------------------------------- |
| **`eventName`**    | <code>'onDebug'</code>                                      |
| **`listenerFunc`** | <code><a href="#ondebugcallback">OnDebugCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('onKeyboardInput', ...)

```typescript
addListener(eventName: 'onKeyboardInput', listenerFunc: OnKeyboardInputCallback) => Promise<PluginListenerHandle>
```

| Param              | Type                                                                        |
| ------------------ | --------------------------------------------------------------------------- |
| **`eventName`**    | <code>'onKeyboardInput'</code>                                              |
| **`listenerFunc`** | <code><a href="#onkeyboardinputcallback">OnKeyboardInputCallback</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Removes all listeners

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


#### OnKeyboardInputCallback

<code>(data: { groupKey: <a href="#handleablekey">HandleableKey</a>; key: <a href="#handleablekey">HandleableKey</a>; value: string; isWhiteChar: boolean; }): void</code>


### Enums


#### HandleableKey

| Members                                 | Value                            | Description                                                                                                                                               |
| --------------------------------------- | -------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`Sunmi89KeyKeyboard_KeyPad`**         | <code>"89_KEYPAD"</code>         |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad`**         | <code>"89_NUMPAD"</code>         |                                                                                                                                                           |
| **`L2Ks_KeyPad`**                       | <code>"L2KS_KEYPAD"</code>       |                                                                                                                                                           |
| **`L2K_KeyPad`**                        | <code>"L2K_KEYPAD"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Esc`**            | <code>"89_ESC"</code>            |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F1`**             | <code>"89_F1"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F2`**             | <code>"89_F2"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F3`**             | <code>"89_F3"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F4`**             | <code>"89_F4"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F5`**             | <code>"89_F5"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F6`**             | <code>"89_F6"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F7`**             | <code>"89_F7"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F8`**             | <code>"89_F8"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F9`**             | <code>"89_F9"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F10`**            | <code>"89_F10"</code>            |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Delete`**         | <code>"89_DELETE"</code>         |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Home`**           | <code>"89_HOME"</code>           |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_End`**            | <code>"89_END"</code>            |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_PgUp`**           | <code>"89_PGUP"</code>           |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_PgDn`**           | <code>"89_PGDN"</code>           |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Cash`**           | <code>"89_CASH"</code>           |                                                                                                                                                           |
| **`L2Ks_F1`**                           | <code>"L2KS_F1"</code>           |                                                                                                                                                           |
| **`L2Ks_F2`**                           | <code>"L2KS_F2"</code>           |                                                                                                                                                           |
| **`L2Ks_F3`**                           | <code>"L2KS_F3"</code>           |                                                                                                                                                           |
| **`L2Ks_F4`**                           | <code>"L2KS_F4"</code>           |                                                                                                                                                           |
| **`L2Ks_F5`**                           | <code>"L2KS_F5"</code>           |                                                                                                                                                           |
| **`L2Ks_F6`**                           | <code>"L2KS_F6"</code>           |                                                                                                                                                           |
| **`L2Ks_F7`**                           | <code>"L2KS_F7"</code>           |                                                                                                                                                           |
| **`L2Ks_F8`**                           | <code>"L2KS_F8"</code>           |                                                                                                                                                           |
| **`L2Ks_F9`**                           | <code>"L2KS_F9"</code>           |                                                                                                                                                           |
| **`L2Ks_BACK`**                         | <code>"L2KS_BACK"</code>         |                                                                                                                                                           |
| **`L2Ks_ENTER`**                        | <code>"L2KS_ENTER"</code>        |                                                                                                                                                           |
| **`L2Ks_STAR`**                         | <code>"L2KS_STAR"</code>         |                                                                                                                                                           |
| **`L2Ks_SPACE`**                        | <code>"L2KS_SPACE"</code>        |                                                                                                                                                           |
| **`L2Ks_POUND`**                        | <code>"L2KS_POUND"</code>        |                                                                                                                                                           |
| **`L2Ks_DEL`**                          | <code>"L2KS_DEL"</code>          |                                                                                                                                                           |
| **`L2Ks_UP`**                           | <code>"L2KS_UP"</code>           |                                                                                                                                                           |
| **`L2Ks_DOWN`**                         | <code>"L2KS_DOWN"</code>         |                                                                                                                                                           |
| **`L2Ks_LEFT`**                         | <code>"L2KS_LEFT"</code>         |                                                                                                                                                           |
| **`L2Ks_RIGHT`**                        | <code>"L2KS_RIGHT"</code>        |                                                                                                                                                           |
| **`L2Ks_1`**                            | <code>"L2KS_1"</code>            |                                                                                                                                                           |
| **`L2Ks_2`**                            | <code>"L2KS_2"</code>            |                                                                                                                                                           |
| **`L2Ks_3`**                            | <code>"L2KS_3"</code>            |                                                                                                                                                           |
| **`L2Ks_4`**                            | <code>"L2KS_4"</code>            |                                                                                                                                                           |
| **`L2Ks_5`**                            | <code>"L2KS_5"</code>            |                                                                                                                                                           |
| **`L2Ks_6`**                            | <code>"L2KS_6"</code>            |                                                                                                                                                           |
| **`L2Ks_7`**                            | <code>"L2KS_7"</code>            |                                                                                                                                                           |
| **`L2Ks_8`**                            | <code>"L2KS_8"</code>            |                                                                                                                                                           |
| **`L2Ks_9`**                            | <code>"L2KS_9"</code>            |                                                                                                                                                           |
| **`L2Ks_0`**                            | <code>"L2KS_0"</code>            |                                                                                                                                                           |
| **`L2Ks_PERIOD`**                       | <code>"L2KS_PERIOD"</code>       |                                                                                                                                                           |
| **`L2K_TAB`**                           | <code>"L2K_TAB"</code>           |                                                                                                                                                           |
| **`L2K_ENTER`**                         | <code>"L2K_ENTER"</code>         |                                                                                                                                                           |
| **`L2K_P1`**                            | <code>"L2K_P1"</code>            |                                                                                                                                                           |
| **`L2K_1`**                             | <code>"L2K_1"</code>             |                                                                                                                                                           |
| **`L2K_2`**                             | <code>"L2K_2"</code>             |                                                                                                                                                           |
| **`L2K_3`**                             | <code>"L2K_3"</code>             |                                                                                                                                                           |
| **`L2K_4`**                             | <code>"L2K_4"</code>             |                                                                                                                                                           |
| **`L2K_5`**                             | <code>"L2K_5"</code>             |                                                                                                                                                           |
| **`L2K_6`**                             | <code>"L2K_6"</code>             |                                                                                                                                                           |
| **`L2K_7`**                             | <code>"L2K_7"</code>             |                                                                                                                                                           |
| **`L2K_8`**                             | <code>"L2K_8"</code>             |                                                                                                                                                           |
| **`L2K_9`**                             | <code>"L2K_9"</code>             |                                                                                                                                                           |
| **`L2K_0`**                             | <code>"L2K_0"</code>             |                                                                                                                                                           |
| **`L2K_PERIOD`**                        | <code>"L2K_PERIOD"</code>        |                                                                                                                                                           |
| **`L2K_SPACE`**                         | <code>"L2K_SPACE"</code>         |                                                                                                                                                           |
| **`L2K_MINUS`**                         | <code>"L2K_MINUS"</code>         |                                                                                                                                                           |
| **`L2K_DEL`**                           | <code>"L2K_DEL"</code>           |                                                                                                                                                           |
| **`L2K_UP`**                            | <code>"L2K_UP"</code>            |                                                                                                                                                           |
| **`L2K_DOWN`**                          | <code>"L2K_DOWN"</code>          |                                                                                                                                                           |
| **`L2K_LEFT`**                          | <code>"L2K_LEFT"</code>          |                                                                                                                                                           |
| **`L2K_RIGHT`**                         | <code>"L2K_RIGHT"</code>         |                                                                                                                                                           |
| **`L2K_CENTER`**                        | <code>"L2K_CENTER"</code>        |                                                                                                                                                           |
| **`L2s_Shortcut`**                      | <code>"L2S_SHORTCUT"</code>      |                                                                                                                                                           |
| **`L2H_Shortcut`**                      | <code>"L2H_SHORTCUT"</code>      |                                                                                                                                                           |
| **`L2K_Shortcut`**                      | <code>"L2K_SHORTCUT"</code>      |                                                                                                                                                           |
| **`L2Ks_Shortcut`**                     | <code>"L2KS_SHORTCUT"</code>     | Defaultly is assigned to turning on/off the screen. To use it as a shortcut key, you need to remap it to "system action" in "custom keys" settings panel. |
| **`RFID`**                              | <code>"RFID"</code>              |                                                                                                                                                           |
| **`Barcode_Any`**                       | <code>"BARCODE"</code>           |                                                                                                                                                           |
| **`Barcode_BuiltIn`**                   | <code>"BARCODE_BUILTIN"</code>   |                                                                                                                                                           |
| **`Barcode_Handheld`**                  | <code>"BARCODE_HANDHELD"</code>  |                                                                                                                                                           |
| **`Barcode_Blink`**                     | <code>"BARCODE_BLINK"</code>     |                                                                                                                                                           |
| **`Barcode_ProGlove`**                  | <code>"BARCODE_PROGLOVE"</code>  |                                                                                                                                                           |
| **`Debug`**                             | <code>"DEBUG"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Grave`**          | <code>"89_GRAVE"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Tab`**            | <code>"89_TAB"</code>            |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Slash`**          | <code>"89_SLASH"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Space`**          | <code>"89_SPACE"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Apostrophe`**     | <code>"89_APOSTROPHE"</code>     |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Left`**           | <code>"89_LEFT"</code>           |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Down`**           | <code>"89_DOWN"</code>           |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Right`**          | <code>"89_RIGHT"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Up`**             | <code>"89_UP"</code>             |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Period`**         | <code>"89_PERIOD"</code>         |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Comma`**          | <code>"89_COMMA"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_BackSlash`**      | <code>"89_BACKSLASH"</code>      |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Enter`**          | <code>"89_ENTER"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Del`**            | <code>"89_DEL"</code>            |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Minus`**          | <code>"89_MINUS"</code>          |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Equals`**         | <code>"89_EQUALS"</code>         |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_RightBracket`**   | <code>"89_RIGHT_BRACKET"</code>  |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_LeftBracket`**    | <code>"89_LEFT_BRACKET"</code>   |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Semicolon`**      | <code>"89_SEMICOLON"</code>      |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_1`**              | <code>"89_1"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_2`**              | <code>"89_2"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_3`**              | <code>"89_3"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_4`**              | <code>"89_4"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_5`**              | <code>"89_5"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_6`**              | <code>"89_6"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_7`**              | <code>"89_7"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_8`**              | <code>"89_8"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_9`**              | <code>"89_9"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_0`**              | <code>"89_0"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Q`**              | <code>"89_Q"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_W`**              | <code>"89_W"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_E`**              | <code>"89_E"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_R`**              | <code>"89_R"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_T`**              | <code>"89_T"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Y`**              | <code>"89_Y"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_U`**              | <code>"89_U"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_I`**              | <code>"89_I"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_O`**              | <code>"89_O"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_P`**              | <code>"89_P"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_A`**              | <code>"89_A"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_S`**              | <code>"89_S"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_D`**              | <code>"89_D"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_F`**              | <code>"89_F"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_G`**              | <code>"89_G"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_H`**              | <code>"89_H"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_J`**              | <code>"89_J"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_K`**              | <code>"89_K"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_L`**              | <code>"89_L"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_Z`**              | <code>"89_Z"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_X`**              | <code>"89_X"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_C`**              | <code>"89_C"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_V`**              | <code>"89_V"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_B`**              | <code>"89_B"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_N`**              | <code>"89_N"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_M`**              | <code>"89_M"</code>              |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad0`**        | <code>"89_NUMPAD0"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad1`**        | <code>"89_NUMPAD1"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad2`**        | <code>"89_NUMPAD2"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad3`**        | <code>"89_NUMPAD3"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad4`**        | <code>"89_NUMPAD4"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad5`**        | <code>"89_NUMPAD5"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad6`**        | <code>"89_NUMPAD6"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad7`**        | <code>"89_NUMPAD7"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad8`**        | <code>"89_NUMPAD8"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPad9`**        | <code>"89_NUMPAD9"</code>        |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadDot`**      | <code>"89_NUMPADDOT"</code>      |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadDivide`**   | <code>"89_NUMPADDIVIDE"</code>   |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadMultiply`** | <code>"89_NUMPADMULTIPLY"</code> |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadSubtract`** | <code>"89_NUMPADSUBTRACT"</code> |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadAdd`**      | <code>"89_NUMPADADD"</code>      |                                                                                                                                                           |
| **`Sunmi89KeyKeyboard_NumPadEnter`**    | <code>"89_NUMPADENTER"</code>    |                                                                                                                                                           |


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
