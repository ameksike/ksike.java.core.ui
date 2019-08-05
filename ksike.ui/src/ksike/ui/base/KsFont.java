/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksike.ui.base;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.HashMap;

/**
 *
 * @author jose.rod
 */
public class KsFont {

    //... Singleton ...........................................
    private static KsFont _obj = null;
    private final static Object _lock = new Object();

    public static KsFont self() {
        synchronized (_lock) {
            if (_obj == null) {
                _obj = new KsFont();
            }
        }
        return _obj;
    }
    //.........................................................

    public HashMap<String, HashMap> unicode;

    public KsFont() {
        initCode();
    }
    
    public double getHeight(Font font) {
        FontMetrics metrics = (new Canvas()).getFontMetrics(font);
        return metrics.getHeight();
    }
    
    public int[] getWidths(Font font) {
        FontMetrics metrics = (new Canvas()).getFontMetrics(font);
        return metrics.getWidths();
    }

    public int getWidth(String text) {
        return this.getWidth(text, new Font("Tahoma", 0, 15));
    }
    public int getWidth(String text, Font font) {
        FontMetrics metrics = (new Canvas()).getFontMetrics(font);
        return metrics.stringWidth(text);
    }
    
    private void initCode() {
        unicode = new HashMap<String, HashMap>();

        unicode.put("fa-solid-900", new HashMap<String, String>());
        unicode.get("fa-solid-900").put("user", "\uf007");
        unicode.get("fa-solid-900").put("anchor", "\uf13d");
        unicode.get("fa-solid-900").put("archive", "\uf187");
        unicode.get("fa-solid-900").put("arrow-alt-circle-down", "\uf358");

        unicode.put("fa-brands-400", new HashMap<String, String>());
        unicode.get("fa-brands-400").put("app-store", "\uf36f");
        unicode.get("fa-brands-400").put("apple", "\uf179");
        unicode.get("fa-brands-400").put("bluetooth", "\uf293");
        unicode.get("fa-brands-400").put("bootstrap", "\uf836");

        unicode.put("fa-regular-400", new HashMap<String, String>());
        unicode.get("fa-regular-400").put("address-book", "\uf2b9");
        unicode.get("fa-regular-400").put("address-card", "\uf2bb");
        unicode.get("fa-regular-400").put("angry", "\uf556");
        unicode.get("fa-regular-400").put("arrow-alt-circle-down", "\uf358");
        unicode.get("fa-regular-400").put("arrow-alt-circle-up", "\uf35b");
        unicode.get("fa-regular-400").put("arrow-alt-circle-left", "\uf359");
        unicode.get("fa-regular-400").put("arrow-alt-circle-right", "\uf35a");
        unicode.get("fa-regular-400").put("bell", "\uf0f3");
        unicode.get("fa-regular-400").put("bell-slash", "\uf1f6");
        unicode.get("fa-regular-400").put("bookmark", "\uf02e");
        unicode.get("fa-regular-400").put("building", "\uf1ad");
        unicode.get("fa-regular-400").put("calendar", "\uf133");
        unicode.get("fa-regular-400").put("calendar-alt", "\uf073");
        unicode.get("fa-regular-400").put("calendar-check", "\uf274");
        unicode.get("fa-regular-400").put("calendar-minus", "\uf272");
        unicode.get("fa-regular-400").put("calendar-plus", "\uf271");
        unicode.get("fa-regular-400").put("calendar-times", "\uf273");
        unicode.get("fa-regular-400").put("caret-square-down", "\uf150");
        unicode.get("fa-regular-400").put("caret-square-left", "\uf191");
        unicode.get("fa-regular-400").put("caret-square-right", "\uf152");
        unicode.get("fa-regular-400").put("caret-square-up", "\uf080");
        unicode.get("fa-regular-400").put("chart-bar", "f150");
        unicode.get("fa-regular-400").put("check-circle", "\uf058");
        unicode.get("fa-regular-400").put("check-square", "\uf14a");
        unicode.get("fa-regular-400").put("circle", "\uf111");
        unicode.get("fa-regular-400").put("clipboard", "\uf328");
        unicode.get("fa-regular-400").put("clock", "\uf017");
        unicode.get("fa-regular-400").put("clone", "\uf24d");
        unicode.get("fa-regular-400").put("closed-captioning", "\uf20a");
        unicode.get("fa-regular-400").put("comment", "\uf075");
        unicode.get("fa-regular-400").put("comment-alt", "\uf27a");
        unicode.get("fa-regular-400").put("comment-dots", "\uf4ad");
        unicode.get("fa-regular-400").put("comments", "\uf086");
        unicode.get("fa-regular-400").put("compass", "\uf14e");
        unicode.get("fa-regular-400").put("copy", "\uf0c5");
        unicode.get("fa-regular-400").put("copyright", "\uf1f9");
             
        unicode.put("fontawesome-webfont", new HashMap<String, String>());
        unicode.get("fontawesome-webfont").put("fa-battery-0", "\uf244");
        unicode.get("fontawesome-webfont").put("fa-bars", "\uf0c9");
        unicode.get("fontawesome-webfont").put("fa-bar-chart", "\uf080");
        unicode.get("fontawesome-webfont").put("fa-balance-scale", "\uf24e");
        unicode.get("fontawesome-webfont").put("fa-area-chart", "\uf1fe");
        unicode.get("fontawesome-webfont").put("fa-archive", "\uf187");
        unicode.get("fontawesome-webfont").put("fa-line-chart", "\uf201");
        unicode.get("fontawesome-webfont").put("fa-print", "\uf02f");
        unicode.get("fontawesome-webfont").put("fa-pie-chart", "\uf200");
        unicode.get("fontawesome-webfont").put("fa-chevron-left", "\uf053");
        unicode.get("fontawesome-webfont").put("fa-chevron-right", "\uf054");
        unicode.get("fontawesome-webfont").put("fa-chevron-up", "\uf077");
        unicode.get("fontawesome-webfont").put("fa-chevron-down", "\uf078");
        unicode.get("fontawesome-webfont").put("fa-home", "\uf015");
    }
}
