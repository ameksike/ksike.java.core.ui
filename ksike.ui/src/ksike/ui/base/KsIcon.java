package ksike.ui.base;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 22/04/2019
 */
public final class KsIcon extends JLabel implements MouseListener {

    private String ksName;
    private int ksSize;
    private Color ksColorMouseOver;
    private Color ksColorMouseLeave;
    private Color ksColorMousePress;
    private Color ksColorMouseRelease;
    private Color ksColorBackground;
    private Color ksColorMouseClick;

    public KsIcon() throws FontFormatException, IOException {
        super();

        this.ksName = "user";
        this.ksSize = 14;
        this.ksColorBackground = Color.BLACK;
        this.ksColorMouseLeave = this.ksColorBackground;
        this.ksColorMouseOver = this.ksColorBackground;
        this.ksColorMousePress = this.ksColorBackground;
        this.ksColorMouseRelease = this.ksColorBackground;
        this.ksColorMouseClick = this.ksColorBackground;

        this.setIcoByCode();
        this.addMouseListener(this);
    }

    public void setKsColorBackground(Color ksColorBackground) {
        this.ksColorBackground = ksColorBackground;
        this.ksColorMouseLeave = this.ksColorBackground;
        this.ksColorMouseOver = this.ksColorBackground;
        this.ksColorMousePress = this.ksColorBackground;
        this.ksColorMouseRelease = this.ksColorBackground;
        this.ksColorMouseClick = this.ksColorBackground;
        this.setForeground(this.ksColorBackground);
    }

    public Color getKsColorBackground() {
        return ksColorBackground;
    }

    public int getKsSize() {
        return ksSize;
    }

    public String getKsName() {
        return ksName;
    }

    public Color getKsColorMouseOver() {
        return ksColorMouseOver;
    }

    public Color getKsColorMouseLeave() {
        return ksColorMouseLeave;
    }

    public Color getKsColorMousePress() {
        return ksColorMousePress;
    }

    public Color getKsColorMouseRelease() {
        return ksColorMouseRelease;
    }

    public Color getKsColorMouseClick() {
        return ksColorMouseClick;
    }

    public void setKsColorMouseClick(Color ksColorMouseClick) {
        this.ksColorMouseClick = ksColorMouseClick;
    }

    public void setKsColorMouseRelease(Color ksColorMouseRelease) {
        this.ksColorMouseRelease = ksColorMouseRelease;
    }

    public void setKsColorMouseOver(Color ksColorMouseOver) {
        this.ksColorMouseOver = ksColorMouseOver;
    }

    public void setKsColorMouseLeave(Color ksColorMouseLeave) {
        this.ksColorMouseLeave = ksColorMouseLeave;
    }

    public void setKsColorMousePress(Color ksColorMousePress) {
        this.ksColorMousePress = ksColorMousePress;
    }

    public void setKsSize(int ksSize) {
        this.ksSize = ksSize;
        this.setIcoByCode();
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
        this.setIcoByCode();
    }

    public Font getFontTtf(String name, int size) {
        InputStream ttf = this.getClass().getResourceAsStream("/ksike/ui/font/" + name + ".ttf");
        Font ttfBase = null;
        try {
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, ttf);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(KsIcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ttfBase.deriveFont(Font.BOLD, size);
    }

    public boolean setIcoByCode(String key, int size) {
        for (Map.Entry<String, HashMap> entry : KsFont.self().unicode.entrySet()) {
            if (entry.getValue().containsKey(key)) {
                this.setFont(this.getFontTtf(entry.getKey(), size));
                this.setText(String.valueOf(entry.getValue().get(key)));
                this.setHorizontalAlignment(CENTER);
                this.setVerticalAlignment(CENTER);
                return true;
            }
        }
        return false;
    }

    public boolean setIcoByCode() {
        return this.setIcoByCode(this.ksName, this.ksSize);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setForeground(this.ksColorMouseClick);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setForeground(this.ksColorMousePress);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setForeground(this.ksColorMouseRelease);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setForeground(this.ksColorMouseOver);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setForeground(this.ksColorMouseLeave);
    }
}
