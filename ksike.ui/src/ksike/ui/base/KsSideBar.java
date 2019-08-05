package ksike.ui.base;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsSideBar extends KsPanel {

    private Color ksColorBorder;
    private Color ksColorBackground;
    private Color ksColorMouseLeave;
    private Color ksColorMousePress;
    private Color ksColorMouseRelease;
    private Color ksColorMouseClick;
    private Color ksColorMouseOver;
    private int ksSizeFit;
    private Box cmpBox;

    private void init() {
        this.height = 600;
        this.width = 200;
        this.ksSizeFit = 20;
        this.ksColorBackground = new Color(53, 65, 79);
        this.ksColorMouseOver = new Color(62, 75, 92);
        this.ksColorMouseClick = new Color(14, 18, 22);
        this.ksColorMouseLeave = this.ksColorBackground;
        this.ksColorMousePress = this.ksColorBackground;
        this.ksColorMouseRelease = this.ksColorBackground;
        this.ksColorBorder = this.ksColorBackground;
        this.setBackground(this.ksColorBackground);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public KsSideBar() {
        super();
        this.init();
    }

    public KsSideBar(int width, int height) {
        super();
        this.init();
        this.height = height;
        this.width = width;
    }

    @Override
    public Component add(KsPanel item) {
        this.setItemStyle((KsSideBarItem) item);
        ((KsSideBarItem) item).setContainer(this);
        return super.add(item);
    }

    @Override
    public Component add(KsPanel item, String icoid, String label) {
        ((KsSideBarItem) item).setKsIcoName(icoid);
        ((KsSideBarItem) item).setKsLabelTitle(label);
        return this.add(item);
    }

    @Override
    public Component add(String icoid, String label, KsMouseListener handler) {
        KsSideBarItem item = null;
        if (handler != null) {
            try {
                item = new KsSideBarItemBtn();
                item.addMouseListener(handler);
            } catch (FontFormatException | IOException ex) {
                Logger.getLogger(KsSideBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            item = new KsSideBarItem();
        }
        return this.add(item, icoid, label);
    }

    @Override
    public Component add(String icoid, String label) {
        return this.add(icoid, label, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(119, 250);
    }

    public void itemReset() {
        this.itemReset(null);
    }

    public void itemReset(KsSideBarItem active) {
        this.itemReset(active, this.ksColorBackground);
    }

    public void itemReset(KsSideBarItem active, Color color) {
        for (Component elm : this.getComponents()) {
            if (elm instanceof KsSideBarItem) {
                this.itemBtnReset((KsSideBarItem) elm, active, color);
                ((KsSideBarItem) elm).setKsBorderColor(this.ksColorBorder);
            }
        }
    }

    public void itemBtnReset(KsSideBarItem elm, KsSideBarItem active, Color color) {
        if (elm instanceof KsSideBarItemBtn) {
            if (active != null) {
                if (elm.equals(active)) {
                    ((KsSideBarItemBtn) elm).setKsActive(true);
                } else {
                    ((KsSideBarItemBtn) elm).setKsActive(false);
                }
            }
            if (((KsSideBarItemBtn) elm).isKsActive()) {
                this.setActive(elm);
            } else {
                ((KsSideBarItem) elm).setBackground(color);
            }
        }
    }

    public void setItemStyle(KsSideBarItem btn) {
        if (btn instanceof KsSideBarItemBtn) {
            btn.setKsBgColor(this.ksColorBackground);
        } else {
            btn.setKsBgColor(this.ksColorMouseOver);
        }
        btn.setKsBorderColor(this.ksColorBorder);
        btn.setSizeFit(this.ksSizeFit);
    }

    public int getKsSizeFit() {
        return ksSizeFit;
    }

    public void setKsSizeFit(int ksSizeFit) {
        this.ksSizeFit = ksSizeFit;
    }

    public Color getKsColorBackground() {
        return ksColorBackground;
    }

    public void setKsColorBackground(Color ksColorBackground) {
        this.ksColorBackground = ksColorBackground;
        this.itemReset();
    }

    public Color getKsColorMouseLeave() {
        return ksColorMouseLeave;
    }

    public void setKsColorMouseLeave(Color ksColorMouseLeave) {
        this.ksColorMouseLeave = ksColorMouseLeave;
    }

    public Color getKsColorMousePress() {
        return ksColorMousePress;
    }

    public void setKsColorMousePress(Color ksColorMousePress) {
        this.ksColorMousePress = ksColorMousePress;
    }

    public Color getKsColorMouseRelease() {
        return ksColorMouseRelease;
    }

    public void setKsColorMouseRelease(Color ksColorMouseRelease) {
        this.ksColorMouseRelease = ksColorMouseRelease;
    }

    public Color getKsColorMouseClick() {
        return ksColorMouseClick;
    }

    public void setKsColorMouseClick(Color ksColorMouseClick) {
        this.ksColorMouseClick = ksColorMouseClick;
    }

    public Color getKsColorMouseOver() {
        return ksColorMouseOver;
    }

    public void setKsColorMouseOver(Color ksColorMouseOver) {
        this.ksColorMouseOver = ksColorMouseOver;
    }

    public Color getKsColorBorder() {
        return ksColorBorder;
    }

    public void setKsColorBorder(Color ksColorBorder) {
        this.ksColorBorder = ksColorBorder;
        this.itemReset();
    }

    public void setActive(KsSideBarItem elm) {
        ((KsSideBarItem) elm).setBackground(this.ksColorMouseClick);
        if (elm instanceof KsSideBarItemBtn) {
            ((KsSideBarItemBtn) elm).setKsActive(true);
        }
    }
}
