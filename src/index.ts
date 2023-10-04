import { registerPlugin } from '@capacitor/core';

import type { SunmiKeyboardHandlerPlugin } from './definitions';

const SunmiKeyboardHandler = registerPlugin<SunmiKeyboardHandlerPlugin>(
  'SunmiKeyboardHandler',
  {
    web: () => import('./web').then(m => new m.SunmiKeyboardHandlerWeb()),
    ios: () => import('./web').then(m => new m.SunmiKeyboardHandlerWeb()),
  },
);

export * from './definitions';
export { SunmiKeyboardHandler };
