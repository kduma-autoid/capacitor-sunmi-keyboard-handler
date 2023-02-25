package dev.duma.capacitor.sunmikeyboardhandler;

import androidx.annotation.Nullable;

public interface HasKeyHandlersInterface {
    @Nullable
    KeyHandlerInterface getKeyHandler();

    void setKeyHandler(KeyHandlerInterface keyHandler);
}
