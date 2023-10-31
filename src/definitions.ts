import {PluginListenerHandle} from "@capacitor/core";

export enum HandleableKey {
  Sunmi89KeyKeyboard_KeyPad = "89_KEYPAD",
  Sunmi89KeyKeyboard_NumPad = "89_NUMPAD",
  L2Ks_KeyPad = "L2KS_KEYPAD",
  L2K_KeyPad = "L2K_KEYPAD",

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
  L2K_Shortcut = "L2K_SHORTCUT",
  /**
   * Defaultly is assigned to turning on/off the screen. To use it as a shortcut key, you need to remap it to "system action" in "custom keys" settings panel.
   */
  L2Ks_Shortcut = "L2KS_SHORTCUT",
  RFID = "RFID",

  Barcode_Any = "BARCODE",
  Barcode_BuiltIn = "BARCODE_BUILTIN",
  Barcode_Handheld = "BARCODE_HANDHELD",
  Barcode_Blink = "BARCODE_BLINK",

  Debug = "DEBUG",

  Sunmi89KeyKeyboard_Grave = "89_GRAVE",
  Sunmi89KeyKeyboard_Tab = "89_TAB",
  Sunmi89KeyKeyboard_Slash = "89_SLASH",
  Sunmi89KeyKeyboard_Space = "89_SPACE",
  Sunmi89KeyKeyboard_Apostrophe = "89_APOSTROPHE",
  Sunmi89KeyKeyboard_Left = "89_LEFT",
  Sunmi89KeyKeyboard_Down = "89_DOWN",
  Sunmi89KeyKeyboard_Right = "89_RIGHT",
  Sunmi89KeyKeyboard_Up = "89_UP",
  Sunmi89KeyKeyboard_Period = "89_PERIOD",
  Sunmi89KeyKeyboard_Comma = "89_COMMA",
  Sunmi89KeyKeyboard_BackSlash = "89_BACKSLASH",
  Sunmi89KeyKeyboard_Enter = "89_ENTER",
  Sunmi89KeyKeyboard_Del = "89_DEL",
  Sunmi89KeyKeyboard_Minus = "89_MINUS",
  Sunmi89KeyKeyboard_Equals = "89_EQUALS",
  Sunmi89KeyKeyboard_RightBracket = "89_RIGHT_BRACKET",
  Sunmi89KeyKeyboard_LeftBracket = "89_LEFT_BRACKET",
  Sunmi89KeyKeyboard_Semicolon = "89_SEMICOLON",
  Sunmi89KeyKeyboard_1 = "89_1",
  Sunmi89KeyKeyboard_2 = "89_2",
  Sunmi89KeyKeyboard_3 = "89_3",
  Sunmi89KeyKeyboard_4 = "89_4",
  Sunmi89KeyKeyboard_5 = "89_5",
  Sunmi89KeyKeyboard_6 = "89_6",
  Sunmi89KeyKeyboard_7 = "89_7",
  Sunmi89KeyKeyboard_8 = "89_8",
  Sunmi89KeyKeyboard_9 = "89_9",
  Sunmi89KeyKeyboard_0 = "89_0",
  Sunmi89KeyKeyboard_Q = "89_Q",
  Sunmi89KeyKeyboard_W = "89_W",
  Sunmi89KeyKeyboard_E = "89_E",
  Sunmi89KeyKeyboard_R = "89_R",
  Sunmi89KeyKeyboard_T = "89_T",
  Sunmi89KeyKeyboard_Y = "89_Y",
  Sunmi89KeyKeyboard_U = "89_U",
  Sunmi89KeyKeyboard_I = "89_I",
  Sunmi89KeyKeyboard_O = "89_O",
  Sunmi89KeyKeyboard_P = "89_P",
  Sunmi89KeyKeyboard_A = "89_A",
  Sunmi89KeyKeyboard_S = "89_S",
  Sunmi89KeyKeyboard_D = "89_D",
  Sunmi89KeyKeyboard_F = "89_F",
  Sunmi89KeyKeyboard_G = "89_G",
  Sunmi89KeyKeyboard_H = "89_H",
  Sunmi89KeyKeyboard_J = "89_J",
  Sunmi89KeyKeyboard_K = "89_K",
  Sunmi89KeyKeyboard_L = "89_L",
  Sunmi89KeyKeyboard_Z = "89_Z",
  Sunmi89KeyKeyboard_X = "89_X",
  Sunmi89KeyKeyboard_C = "89_C",
  Sunmi89KeyKeyboard_V = "89_V",
  Sunmi89KeyKeyboard_B = "89_B",
  Sunmi89KeyKeyboard_N = "89_N",
  Sunmi89KeyKeyboard_M = "89_M",

  Sunmi89KeyKeyboard_NumPad0 = "89_NUMPAD0",
  Sunmi89KeyKeyboard_NumPad1 = "89_NUMPAD1",
  Sunmi89KeyKeyboard_NumPad2 = "89_NUMPAD2",
  Sunmi89KeyKeyboard_NumPad3 = "89_NUMPAD3",
  Sunmi89KeyKeyboard_NumPad4 = "89_NUMPAD4",
  Sunmi89KeyKeyboard_NumPad5 = "89_NUMPAD5",
  Sunmi89KeyKeyboard_NumPad6 = "89_NUMPAD6",
  Sunmi89KeyKeyboard_NumPad7 = "89_NUMPAD7",
  Sunmi89KeyKeyboard_NumPad8 = "89_NUMPAD8",
  Sunmi89KeyKeyboard_NumPad9 = "89_NUMPAD9",
  Sunmi89KeyKeyboard_NumPadDot = "89_NUMPADDOT",
  Sunmi89KeyKeyboard_NumPadDivide = "89_NUMPADDIVIDE",
  Sunmi89KeyKeyboard_NumPadMultiply = "89_NUMPADMULTIPLY",
  Sunmi89KeyKeyboard_NumPadSubtract = "89_NUMPADSUBTRACT",
  Sunmi89KeyKeyboard_NumPadAdd = "89_NUMPADADD",
  Sunmi89KeyKeyboard_NumPadEnter = "89_NUMPADENTER",
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

export type OnKeyboardInputCallback = (data: { groupKey: HandleableKey, key: HandleableKey, value: string, isWhiteChar: boolean }) => void;
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

  /**
   *
   */
  addListener(
      eventName: 'onKeyboardInput',
      listenerFunc: OnKeyboardInputCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;
}