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
    Esc("ESC"),
    F1("F1"),
    F2("F2"),
    F3("F3"),
    F4("F4"),
    F5("F5"),
    F6("F6"),
    F7("F7"),
    F8("F8"),
    F9("F9"),
    F10("F10"),
    Delete("DELETE"),
    Home("HOME"),
    End("END"),
    PgUp("PGUP"),
    PgDn("PGDN"),
    Cash("CASH"),

    L2s_Shortcut("L2S_SHORTCUT"),
    L2k_Shortcut("L2K_SHORTCUT"),
    RFID("RFID"),

    Barcode("BARCODE"),

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
        switch (from) {
            case Esc:
                return KEYCODE_ESCAPE;
            case F1:
                return KEYCODE_F1;
            case F2:
                return KEYCODE_F2;
            case F3:
                return KEYCODE_F3;
            case F4:
                return KEYCODE_F4;
            case F5:
                return KEYCODE_F5;
            case F6:
                return KEYCODE_F6;
            case F7:
                return KEYCODE_F7;
            case F8:
                return KEYCODE_F8;
            case F9:
                return KEYCODE_F9;
            case F10:
                return KEYCODE_F10;
            case Delete:
                return KEYCODE_FORWARD_DEL;
            case Home:
                return KEYCODE_MOVE_HOME;
            case End:
                return KEYCODE_MOVE_END;
            case PgUp:
                return KEYCODE_PAGE_UP;
            case PgDn:
                return KEYCODE_PAGE_DOWN;
            case Cash:
                return KEYCODE_HENKAN;

            default:
                throw new RuntimeException("Invalid key");
        }
    }

    public static HandleableKeyEnum getHandleableKeyEnum(int from) throws RuntimeException {
        switch (from) {
            case KEYCODE_PAGE_DOWN:
                return HandleableKeyEnum.PgDn;
            case KEYCODE_PAGE_UP:
                return HandleableKeyEnum.PgUp;
            case KEYCODE_MOVE_END:
                return HandleableKeyEnum.End;
            case KEYCODE_MOVE_HOME:
                return HandleableKeyEnum.Home;
            case KEYCODE_FORWARD_DEL:
                return HandleableKeyEnum.Delete;
            case KEYCODE_F1:
                return HandleableKeyEnum.F1;
            case KEYCODE_F2:
                return HandleableKeyEnum.F2;
            case KEYCODE_F3:
                return HandleableKeyEnum.F3;
            case KEYCODE_F4:
                return HandleableKeyEnum.F4;
            case KEYCODE_F5:
                return HandleableKeyEnum.F5;
            case KEYCODE_F6:
                return HandleableKeyEnum.F6;
            case KEYCODE_F7:
                return HandleableKeyEnum.F7;
            case KEYCODE_F8:
                return HandleableKeyEnum.F8;
            case KEYCODE_F9:
                return HandleableKeyEnum.F9;
            case KEYCODE_F10:
                return HandleableKeyEnum.F10;
            case KEYCODE_ESCAPE:
                return HandleableKeyEnum.Esc;
            case KEYCODE_HENKAN:
                return HandleableKeyEnum.Cash;

            default:
                throw new RuntimeException("Invalid key");
        }
    }
}
