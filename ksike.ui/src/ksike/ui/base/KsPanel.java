package ksike.ui.base;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsPanel extends JPanel {

    protected int width;
    protected int height;

    public KsPanel() {
        super();
        this.height = 50;
        this.width = 50;
        this.setBackground(new Color(98, 119, 147));
    }

    public KsPanel(int width, int height) {
        super();
        this.height = height;
        this.width = width;
        this.setPreferredSize(new Dimension(this.width, this.height));
    }

    public KsPanel(KsPanel item) {
        super();
        super.add(item);
        this.setBackground(Color.WHITE);
    }

    public Component add(KsPanel item) {
        return super.add(item);
    }

    public Component add(Object[] item) {
        return null;
    }

    public Component add(KsPanel item, String id, String label) {
        return super.add(item);
    }

    public Component add(String id, String label, KsMouseListener handler) {
        return null;
    }

    public Component add(String id, String label) {
        return null;
    }

    public Dimension getLocalSize() {
        return new Dimension(width, height);
    }

    /*
     @Override
     public Dimension getPreferredSize() {
     return new Dimension(this.width, this.height);
     }
     */
    /*
     @Override
     public Dimension getMinimumSize() {
     return getLocalSize();
     }

     @Override
     public Dimension getMaximumSize() {
     return getLocalSize();
     }
     */
}
