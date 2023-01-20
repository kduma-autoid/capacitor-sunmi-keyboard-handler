# @kduma-sunmi/capacitor-sunmi-keyboard-handler

Handler for processing input from Sunmi hardware barcode scanners (builtin and external) and external Sunmi programmable keyboard.

## Install

```bash
npm install @kduma-sunmi/capacitor-sunmi-keyboard-handler
npx cap sync
```

Modify your `MainActivity.java` file to include the following:

```java
import android.view.KeyEvent;

import com.getcapacitor.BridgeActivity;

import java.util.ArrayList;

import dev.duma.capacitor.sunmikeyboardhandler.HasKeyHandlersInterface;
import dev.duma.capacitor.sunmikeyboardhandler.KeyHandlerInterface;

public class MainActivity extends BridgeActivity implements HasKeyHandlersInterface {
    public ArrayList<KeyHandlerInterface> keyHandlers = new ArrayList<KeyHandlerInterface>();

    @Override
    public void registerKeyHandler(KeyHandlerInterface handler) {
        keyHandlers.add(handler);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        for (KeyHandlerInterface handler : this.keyHandlers) {
            if(handler.handle(event))
                return true;
        }

        return super.dispatchKeyEvent(event);
    }
}
```

## API

<docgen-index>

* [`echo(...)`](#echo)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
