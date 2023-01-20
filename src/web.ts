import { WebPlugin } from '@capacitor/core';

import type { SunmiKeyboardHandlerPlugin } from './definitions';

export class SunmiKeyboardHandlerWeb
  extends WebPlugin
  implements SunmiKeyboardHandlerPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
