export type CallbackID = string;

export enum HandleableKey {
  Esc = "ESC",
  F1 = "F1",
  F2 = "F2",
  F3 = "F3",
  F4 = "F4",
  F5 = "F5",
  F6 = "F6",
  F7 = "F7",
  F8 = "F8",
  F9 = "F9",
  F10 = "F10",
  Delete = "DELETE",
  Home = "HOME",
  End = "END",
  PgUp = "PGUP",
  PgDn = "PGDN",
  Cash = "CASH",

  L2s_Shortcut = "L2S_SHORTCUT",
  L2k_Shortcut = "L2K_SHORTCUT",
  RFID = "RFID",
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

export type KeyHandlerCallback = (data: { key: HandleableKey, modifiers: ModifierKey[], type: KeyEvent }) => void;
export type BarcodeHandlerCallback = (data: { barcode: string, device: { type: string, id: number } }) => void;
export type DebugHandlerCallback = (data: any ) => void;

export interface SunmiKeyboardHandlerPlugin {
  /**
   * Set a callback to be called when a key specified in `key` parameter is pressed.
   */
  setKeyHandler(options: { key: HandleableKey }, callback: KeyHandlerCallback): Promise<CallbackID>;

  /**
   * Remove a callback set by `setKeyHandler` for a key specified in `key` parameter.
   */
  removeKeyHandler(options: { key: HandleableKey }): Promise<void>;

  /**
   * Set a callback to be called when a barcode is scanned.
   */
  setBarcodeHandler(callback: BarcodeHandlerCallback): Promise<CallbackID>;

  /**
   * Remove a callback set by `setBarcodeHandler`.
   */
  removeBarcodeHandler(): Promise<void>;

  /**
   * Set a callback to be called when any unhandled key is pressed.
   */
  setDebugHandler(callback: DebugHandlerCallback): Promise<CallbackID>;

  /**
   * Remove a callback set by `setDebugHandler`.
   */
  removeDebugHandler(): Promise<void>;
}
