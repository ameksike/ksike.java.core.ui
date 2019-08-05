package ksike.ui.base;

import java.awt.Cursor;
import java.awt.FontFormatException;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 *
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsSideBarItemBtn extends KsSideBarItem implements MouseListener {

    protected boolean ksActive;

    public KsSideBarItemBtn() throws FontFormatException, IOException {
        super();
        this.init();
    }

    private void init() {
        this.ksActive = false;
        this.addMouseListener(this);
        this.cmpIco.addMouseListener(this);
        this.cmpLabel.addMouseListener(this);
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
        this.cmpIco.addMouseListener(l);
        this.cmpLabel.addMouseListener(l);
    }

    public void setKsActive(boolean ksActive) {
        this.ksActive = ksActive;
    }

    public boolean isKsActive() {
        return ksActive;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        this.setKsActive(true);
        if (this.container != null) {
            this.container.itemReset(this);
            this.setBackground(this.container.getKsColorMouseClick());
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (this.container != null) {
            this.container.itemReset();
            this.setBackground(this.container.getKsColorBackground());
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (this.container != null) {
            this.container.itemReset();
            this.setBackground(this.container.getKsColorMouseRelease());
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        if (this.container != null) {
            this.container.itemReset();
            this.setBackground(this.container.getKsColorMouseOver());
        }
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        if (this.container != null) {
            this.container.itemReset();
            if (this.isKsActive()) {
                this.setBackground(this.container.getKsColorMouseClick());
            } else {
                this.setBackground(this.container.getKsColorMouseLeave());
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
