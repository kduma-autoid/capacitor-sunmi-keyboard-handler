import { WebPlugin } from '@capacitor/core';

import type {
  SunmiKeyboardHandlerPlugin
} from './definitions';

export class SunmiKeyboardHandlerWeb
  extends WebPlugin
  implements SunmiKeyboardHandlerPlugin
{
  disableHandler(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  enableHandler(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }
}
