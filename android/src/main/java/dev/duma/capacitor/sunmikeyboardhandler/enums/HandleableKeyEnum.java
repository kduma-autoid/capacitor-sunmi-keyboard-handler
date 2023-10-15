package dev.duma.capacitor.sunmikeyboardhandler.enums;

import static android.view.KeyEvent.KEYCODE_ESCAPE;
import static android.view.KeyEvent.KEYCODE_F1;
import static android.view.KeyEvent.KEYCODE_F10;
import static android.view.KeyEvent.KEYCODE_F2;
import static android.view.KeyEvent.KEYCODE_F3;
import static android.view.KeyEvent.KEYCODE_F4;
import static android.view.KeyEvent.KEYCODE_F5;
import static android.view.KeyEvent.KEYCODE_F6;
import static android.view.KeyEvent.KEYCODE_F7;
import static android.view.KeyEvent.KEYCODE_F8;
import static android.view.KeyEvent.KEYCODE_F9;
import static android.view.KeyEvent.KEYCODE_FORWARD_DEL;
import static android.view.KeyEvent.KEYCODE_HENKAN;
import static android.view.KeyEvent.KEYCODE_MOVE_END;
import static android.view.KeyEvent.KEYCODE_MOVE_HOME;
import static android.view.KeyEvent.KEYCODE_PAGE_DOWN;
import static android.view.KeyEvent.KEYCODE_PAGE_UP;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public enum HandleableKeyEnum implements Labeled {
    Sunmi89KeyKeyboard_Esc("89_ESC"),
    Sunmi89KeyKeyboard_F1("89_F1"),
    Sunmi89KeyKeyboard_F2("89_F2"),
    Sunmi89KeyKeyboard_F3("89_F3"),
    Sunmi89KeyKeyboard_F4("89_F4"),
    Sunmi89KeyKeyboard_F5("89_F5"),
    Sunmi89KeyKeyboard_F6("89_F6"),
    Sunmi89KeyKeyboard_F7("89_F7"),
    Sunmi89KeyKeyboard_F8("89_F8"),
    Sunmi89KeyKeyboard_F9("89_F9"),
    Sunmi89KeyKeyboard_F10("89_F10"),
    Sunmi89KeyKeyboard_Delete("89_DELETE"),
    Sunmi89KeyKeyboard_Home("89_HOME"),
    Sunmi89KeyKeyboard_End("89_END"),
    Sunmi89KeyKeyboard_PgUp("89_PGUP"),
    Sunmi89KeyKeyboard_PgDn("89_PGDN"),
    Sunmi89KeyKeyboard_Cash("89_CASH"),

    L2s_Shortcut("L2S_SHORTCUT"),
    L2k_Shortcut("L2K_SHORTCUT"),
    Sunmi_RFID("RFID"),

    Barcode_Any("BARCODE"),
    Barcode_BuiltIn("BARCODE_BUILTIN"),
    Barcode_Handheld("BARCODE_HANDHELD"),
    Barcode_Blink("BARCODE_BLINK"),

    Debug("DEBUG");

    private static final Map<String, HandleableKeyEnum> BY_LABEL = new HashMap<>();

    static {
        for (HandleableKeyEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    public final String label;

    private HandleableKeyEnum(String label) {
        this.label = label;
    }

    @NonNull
    @Override
    public String label() {
        return label;
    }

    public static HandleableKeyEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    @NonNull
    @Override
    public String toString() {
        return this.label;
    }

    public int getKeyCode() {
        return HandleableKeyEnum.getKeyCode(this);
    }

    public static int getKeyCode(HandleableKeyEnum from) throws RuntimeException {
        return switch (from) {
            case Sunmi89KeyKeyboard_Esc -> KEYCODE_ESCAPE;
            case Sunmi89KeyKeyboard_F1 -> KEYCODE_F1;
            case Sunmi89KeyKeyboard_F2 -> KEYCODE_F2;
            case Sunmi89KeyKeyboard_F3 -> KEYCODE_F3;
            case Sunmi89KeyKeyboard_F4 -> KEYCODE_F4;
            case Sunmi89KeyKeyboard_F5 -> KEYCODE_F5;
            case Sunmi89KeyKeyboard_F6 -> KEYCODE_F6;
            case Sunmi89KeyKeyboard_F7 -> KEYCODE_F7;
            case Sunmi89KeyKeyboard_F8 -> KEYCODE_F8;
            case Sunmi89KeyKeyboard_F9 -> KEYCODE_F9;
            case Sunmi89KeyKeyboard_F10 -> KEYCODE_F10;
            case Sunmi89KeyKeyboard_Delete -> KEYCODE_FORWARD_DEL;
            case Sunmi89KeyKeyboard_Home -> KEYCODE_MOVE_HOME;
            case Sunmi89KeyKeyboard_End -> KEYCODE_MOVE_END;
            case Sunmi89KeyKeyboard_PgUp -> KEYCODE_PAGE_UP;
            case Sunmi89KeyKeyboard_PgDn -> KEYCODE_PAGE_DOWN;
            case Sunmi89KeyKeyboard_Cash -> KEYCODE_HENKAN;
            default -> throw new RuntimeException("Invalid key");
        };
    }

    public static HandleableKeyEnum getHandleableKeyEnum(int from) throws RuntimeException {
        return switch (from) {
            case KEYCODE_PAGE_DOWN -> HandleableKeyEnum.Sunmi89KeyKeyboard_PgDn;
            case KEYCODE_PAGE_UP -> HandleableKeyEnum.Sunmi89KeyKeyboard_PgUp;
            case KEYCODE_MOVE_END -> HandleableKeyEnum.Sunmi89KeyKeyboard_End;
            case KEYCODE_MOVE_HOME -> HandleableKeyEnum.Sunmi89KeyKeyboard_Home;
            case KEYCODE_FORWARD_DEL -> HandleableKeyEnum.Sunmi89KeyKeyboard_Delete;
            case KEYCODE_F1 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F1;
            case KEYCODE_F2 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F2;
            case KEYCODE_F3 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F3;
            case KEYCODE_F4 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F4;
            case KEYCODE_F5 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F5;
            case KEYCODE_F6 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F6;
            case KEYCODE_F7 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F7;
            case KEYCODE_F8 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F8;
            case KEYCODE_F9 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F9;
            case KEYCODE_F10 -> HandleableKeyEnum.Sunmi89KeyKeyboard_F10;
            case KEYCODE_ESCAPE -> HandleableKeyEnum.Sunmi89KeyKeyboard_Esc;
            case KEYCODE_HENKAN -> HandleableKeyEnum.Sunmi89KeyKeyboard_Cash;
            default -> throw new RuntimeException("Invalid key");
        };
    }
}
