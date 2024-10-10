import { SplashScreen } from '@capacitor/splash-screen';
import { SunmiKeyboardHandler } from '@kduma-autoid/capacitor-sunmi-keyboard-handler';
import {HandleableKey} from "../../../src";
import {WebViewWatchDog} from "@kduma-autoid/capacitor-webview-watchdog";

window.customElements.define(
  'capacitor-welcome',
  class extends HTMLElement {
    constructor() {
      super();

      SplashScreen.hide();
      WebViewWatchDog.ping();

      const root = this.attachShadow({ mode: 'open' });

      root.innerHTML = `
    <style>
      :host {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        display: block;
        width: 100%;
        height: 100%;
      }
      h1, h2, h3, h4, h5 {
        text-transform: uppercase;
      }
      .button {
        display: inline-block;
        padding: 10px;
        background-color: #73B5F6;
        color: #fff;
        font-size: 0.9em;
        border: 0;
        border-radius: 3px;
        text-decoration: none;
        cursor: pointer;
      }
      main {
        padding: 15px;
      }
      main hr { height: 1px; background-color: #eee; border: 0; }
      main h1 {
        font-size: 1.4em;
        text-transform: uppercase;
        letter-spacing: 1px;
      }
      main h2 {
        font-size: 1.1em;
      }
      main h3 {
        font-size: 0.9em;
      }
      main p {
        color: #333;
      }
      main pre {
        white-space: pre-line;
      }
    </style>
    <div>
      <capacitor-welcome-titlebar>
        <h1>@kduma-autoid/capacitor-sunmi-keyboard-handler</h1>
      </capacitor-welcome-titlebar>
      <main>
        <input name="test"/>
        <h2>Demo Events</h2>
        <p id="output"></p>
      </main>
    </div>
    `;
    }

    async connectedCallback() {
        const self = this;

        function printToOutput(key, content) {
            const output = self.shadowRoot.querySelector('#output');
            output.innerHTML = "<b>" + key + ":</b><br><pre>" + content + "</pre><hr>" + output.innerHTML;
        }

        SunmiKeyboardHandler.addListener('onKeyPressed', (e) => {
            printToOutput('onKeyPressed', JSON.stringify(e, null, 3));
        });

        SunmiKeyboardHandler.addListener('onBarcodeScanned', (e) => {
            printToOutput('onBarcodeScanned', JSON.stringify(e, null, 3));
        });

        SunmiKeyboardHandler.addListener('onDebug', (e) => {
            printToOutput('onDebug', JSON.stringify(e, null, 3));
        });

        SunmiKeyboardHandler.addListener('onKeyboardInput', (e) => {
            printToOutput('onKeyboardInput', JSON.stringify(e, null, 3));
        });

        await Promise.all([
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_KeyPad}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_NumPad}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_KeyPad}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2K_KeyPad}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Barcode_Any}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Barcode_BuiltIn}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Barcode_Blink}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Barcode_Handheld}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Barcode_ProGlove}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Debug}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2s_Shortcut}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2H_Shortcut}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2K_Shortcut}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_Shortcut}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.RFID}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_Esc}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F1}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F2}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F3}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F4}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F5}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F6}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F7}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F8}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F9}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_F10}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_Delete}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_Home}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_End}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_PgUp}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_PgDn}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.Sunmi89KeyKeyboard_Cash}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F1}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F2}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F3}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F4}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F5}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F6}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F7}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F8}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_F9}),
            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2Ks_BACK}),

            SunmiKeyboardHandler.enableHandler({key: HandleableKey.L2K_P1}),
        ]);
    }
  }
);

window.customElements.define(
  'capacitor-welcome-titlebar',
  class extends HTMLElement {
    constructor() {
      super();
      const root = this.attachShadow({ mode: 'open' });
      root.innerHTML = `
    <style>
      :host {
        position: relative;
        display: block;
        padding: 15px 15px 15px 15px;
        text-align: center;
        background-color: #73B5F6;
      }
      ::slotted(h1) {
        margin: 0;
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        font-size: 0.9em;
        font-weight: 600;
        color: #fff;
      }
    </style>
    <slot></slot>
    `;
    }
  }
);
