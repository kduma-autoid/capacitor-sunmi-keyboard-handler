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

        const debug_handler = (e) => {
            printToOutput('debug_handler', JSON.stringify(e, null, 3));
        }

        const barcode_scan_handler = (e) => {
            printToOutput('barcode_scan_handler', JSON.stringify(e, null, 3));
        }

        const l2s_shortcut_key_handler = (e) => {
            printToOutput('l2s_shortcut_key_handler', JSON.stringify(e, null, 3));
        }

        const l2k_shortcut_key_handler = (e) => {
            printToOutput('l2k_shortcut_key_handler', JSON.stringify(e, null, 3));
        }

        const rfid_key_handler = (e) => {
            printToOutput('rfid_key_handler', JSON.stringify(e, null, 3));
        }

        const keyboard_press_handler = (e) => {
            printToOutput('keyboard_press_handler', JSON.stringify(e, null, 3));
        }

        await Promise.all([
            SunmiKeyboardHandler.setBarcodeHandler(barcode_scan_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.L2s_Shortcut}, l2s_shortcut_key_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.L2k_Shortcut}, l2k_shortcut_key_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.RFID}, rfid_key_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.Esc}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F1}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F2}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F3}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F4}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F5}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F6}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F7}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F8}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F9}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.F10}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.Delete}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.Home}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.End}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.PgUp}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.PgDn}, keyboard_press_handler),
            SunmiKeyboardHandler.setKeyHandler({key: HandleableKey.Cash}, keyboard_press_handler),
            SunmiKeyboardHandler.setDebugHandler(debug_handler),
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
