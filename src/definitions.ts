import {PluginListenerHandle} from "@capacitor/core";

export enum HandleableKey {
  Sunmi89KeyKeyboard_Esc = "89_ESC",
  Sunmi89KeyKeyboard_F1 = "89_F1",
  Sunmi89KeyKeyboard_F2 = "89_F2",
  Sunmi89KeyKeyboard_F3 = "89_F3",
  Sunmi89KeyKeyboard_F4 = "89_F4",
  Sunmi89KeyKeyboard_F5 = "89_F5",
  Sunmi89KeyKeyboard_F6 = "89_F6",
  Sunmi89KeyKeyboard_F7 = "89_F7",
  Sunmi89KeyKeyboard_F8 = "89_F8",
  Sunmi89KeyKeyboard_F9 = "89_F9",
  Sunmi89KeyKeyboard_F10 = "89_F10",
  Sunmi89KeyKeyboard_Delete = "89_DELETE",
  Sunmi89KeyKeyboard_Home = "89_HOME",
  Sunmi89KeyKeyboard_End = "89_END",
  Sunmi89KeyKeyboard_PgUp = "89_PGUP",
  Sunmi89KeyKeyboard_PgDn = "89_PGDN",
  Sunmi89KeyKeyboard_Cash = "89_CASH",

  L2s_Shortcut = "L2S_SHORTCUT",
  L2k_Shortcut = "L2K_SHORTCUT",
  Sunmi_RFID = "RFID",

  Barcode_Any = "BARCODE",
  Barcode_BuiltIn = "BARCODE_BUILTIN",
  Barcode_Handheld = "BARCODE_HANDHELD",
  Barcode_Blink = "BARCODE_BLINK",

  Debug = "DEBUG",
}

export enum ModifierKey {
  Alt = "ALT",
  Ctrl = "CTRL",
  Shift = "SHIFT",
}

export enum KeyEvent {
  KeyDown = "KEY_DOWN",
  KeyUp = "KEY_UP",
}

export type OnKeyPressedCallback = (data: { key: HandleableKey, modifiers: ModifierKey[], type: KeyEvent }) => void;
export type OnBarcodeScannedCallback = (data: { barcode: string, device: { type: string, id: number } }) => void;
export type OnDebugCallback = (data: any ) => void;

export interface SunmiKeyboardHandlerPlugin {
  /**
   * Set a callback to be called when a key specified in `key` parameter is pressed.
   */
  enableHandler(options: { key: HandleableKey }): Promise<void>;

  /**
   * Remove a callback set by `setKeyHandler` for a key specified in `key` parameter.
   */
  disableHandler(options: { key: HandleableKey }): Promise<void>;

  /**
   *
   */
  addListener(
      eventName: 'onKeyPressed',
      listenerFunc: OnKeyPressedCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   *
   */
  addListener(
      eventName: 'onBarcodeScanned',
      listenerFunc: OnBarcodeScannedCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   *
   */
  addListener(
      eventName: 'onDebug',
      listenerFunc: OnDebugCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;
}