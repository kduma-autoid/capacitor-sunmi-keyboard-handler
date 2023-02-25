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

  L2s_Shortcut_or_RFID = "L2S_SHORTCUT_OR_RFID",
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
  setKeyHandler(options: { key: HandleableKey }, callback: KeyHandlerCallback): Promise<CallbackID>;
  removeKeyHandler(options: { key: HandleableKey }): Promise<void>;

  setBarcodeHandler(callback: BarcodeHandlerCallback): Promise<CallbackID>;
  removeBarcodeHandler(): Promise<void>;

  setDebugHandler(callback: DebugHandlerCallback): Promise<CallbackID>;
  removeDebugHandler(): Promise<void>;
}
