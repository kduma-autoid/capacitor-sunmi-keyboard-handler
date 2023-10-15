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

  L2Ks_F1 = "L2KS_F1",
  L2Ks_F2 = "L2KS_F2",
  L2Ks_F3 = "L2KS_F3",
  L2Ks_F4 = "L2KS_F4",
  L2Ks_F5 = "L2KS_F5",
  L2Ks_F6 = "L2KS_F6",
  L2Ks_F7 = "L2KS_F7",
  L2Ks_F8 = "L2KS_F8",
  L2Ks_F9 = "L2KS_F9",
  L2Ks_BACK = "L2KS_BACK",
  L2Ks_ENTER = "L2KS_ENTER",
  L2Ks_STAR = "L2KS_STAR",
  L2Ks_SPACE = "L2KS_SPACE",
  L2Ks_POUND = "L2KS_POUND",
  L2Ks_DEL = "L2KS_DEL",
  L2Ks_UP = "L2KS_UP",
  L2Ks_DOWN = "L2KS_DOWN",
  L2Ks_LEFT = "L2KS_LEFT",
  L2Ks_RIGHT = "L2KS_RIGHT",
  L2Ks_1 = "L2KS_1",
  L2Ks_2 = "L2KS_2",
  L2Ks_3 = "L2KS_3",
  L2Ks_4 = "L2KS_4",
  L2Ks_5 = "L2KS_5",
  L2Ks_6 = "L2KS_6",
  L2Ks_7 = "L2KS_7",
  L2Ks_8 = "L2KS_8",
  L2Ks_9 = "L2KS_9",
  L2Ks_0 = "L2KS_0",
  L2Ks_PERIOD = "L2KS_PERIOD",

  L2K_TAB = "L2K_TAB",
  L2K_ENTER = "L2K_ENTER",
  L2K_P1 = "L2K_P1",
  L2K_1 = "L2K_1",
  L2K_2 = "L2K_2",
  L2K_3 = "L2K_3",
  L2K_4 = "L2K_4",
  L2K_5 = "L2K_5",
  L2K_6 = "L2K_6",
  L2K_7 = "L2K_7",
  L2K_8 = "L2K_8",
  L2K_9 = "L2K_9",
  L2K_0 = "L2K_0",
  L2K_PERIOD = "L2K_PERIOD",
  L2K_SPACE = "L2K_SPACE",
  L2K_MINUS = "L2K_MINUS",
  L2K_DEL = "L2K_DEL",
  L2K_UP = "L2K_UP",
  L2K_DOWN = "L2K_DOWN",
  L2K_LEFT = "L2K_LEFT",
  L2K_RIGHT = "L2K_RIGHT",
  L2K_CENTER = "L2K_CENTER",

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
  CapsLock = "CAPSLOCK",
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