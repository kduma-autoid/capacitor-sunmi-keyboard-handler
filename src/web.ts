import { WebPlugin } from '@capacitor/core';

import type { CallbackID, SunmiKeyboardHandlerPlugin } from './definitions';

export class SunmiKeyboardHandlerWeb
  extends WebPlugin
  implements SunmiKeyboardHandlerPlugin
{
  removeBarcodeHandler(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  removeDebugHandler(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  removeKeyHandler(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBarcodeHandler(): Promise<CallbackID> {
    throw this.unimplemented('Not implemented on web.');
  }

  setDebugHandler(): Promise<CallbackID> {
    throw this.unimplemented('Not implemented on web.');
  }

  setKeyHandler(): Promise<CallbackID> {
    throw this.unimplemented('Not implemented on web.');
  }
}
