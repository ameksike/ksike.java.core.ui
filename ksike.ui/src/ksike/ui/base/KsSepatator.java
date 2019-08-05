package ksike.ui.base;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.border.Border;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsSepatator extends JSeparator {

    public KsSepatator() {
        super();
    }
    
    public KsSepatator(int size) {
        super();
        this.setSizeFit(size);
    }
    
    public KsSepatator(int width, int height) {
        super();
        this.setSizeFit(width, height);
    }

    public void setSizeFit(int size) {
        this.setSizeFit(size, size);
    }

    public void setSizeFit(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
    }
}
