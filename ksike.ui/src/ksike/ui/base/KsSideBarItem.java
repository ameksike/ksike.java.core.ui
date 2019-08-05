package ksike.ui.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsSideBarItem extends KsPanel {

    protected KsSideBar container;
    protected KsIcon cmpIco;
    protected JLabel cmpLabel;

    protected Color ksTxtColor;
    protected Color ksBgColor;
    protected Color ksBorderColor;

    protected Color ksLabelColor;
    protected String ksLabelTitle;
    protected String ksLabelFont;
    protected int ksLabelSize;
    protected int ksLabelStyle;

    protected String ksIcoName;
    protected Color ksIcoColor;
    protected int ksIcoSize;

    protected int ksSizeHeightMax;
    protected int ksSizeWidthMax;
    protected int ksSizeHeightMin;
    protected int ksSizeWidthMin;

    public KsSideBarItem() {
        this.initProperties();
        this.initLayout();
    }

    protected void initProperties() {
        this.ksSizeHeightMax = 35;
        this.ksSizeHeightMin = -1;
        this.ksSizeWidthMax = -1;
        this.ksSizeWidthMin = -1;
        this.container = null;
        this.ksTxtColor = Color.WHITE;
        this.ksBorderColor = Color.WHITE;
        this.ksBgColor = new Color(62, 75, 92);
        this.setBackground(this.ksBgColor);
        try {
            this.initIcon();
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(KsSideBarItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.initLabel();
    }

    protected void initLayout() {
        Box box = new Box(BoxLayout.X_AXIS);
        BorderLayout bl = new BorderLayout();
        bl.setHgap(5);
        this.setLayout(bl);
        this.add(new KsSepatator(0), BorderLayout.WEST);
        this.add(box, BorderLayout.CENTER);
        box.add(Box.createVerticalGlue());
        if (this.cmpIco != null) {
            this.cmpIco.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            this.cmpIco.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            box.add(this.cmpIco);
        }
        if (this.cmpIco != null && this.cmpLabel != null) {
            box.add(Box.createHorizontalStrut(5));
        }
        if (this.cmpLabel != null) {
            this.cmpLabel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            this.cmpLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            box.add(this.cmpLabel);
        }
        box.add(Box.createVerticalGlue());
    }
    
    @Override
    public Dimension getMinimumSize() {
        Dimension size = super.getMinimumSize();
        int height = (this.ksSizeHeightMin >= 0) ? this.ksSizeHeightMin : size.height;
        int width = (this.ksSizeWidthMin >= 0) ? this.ksSizeWidthMin : size.width;
        return new Dimension(width, height);
    }

    @Override
    public Dimension getMaximumSize() {
        Dimension size = super.getMaximumSize();
        int height = (this.ksSizeHeightMax >= 0) ? this.ksSizeHeightMax : size.height;
        int width = (this.ksSizeWidthMax >= 0) ? this.ksSizeWidthMax : size.width;
        return new Dimension(width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 50);
    }

    protected void initIcon() throws FontFormatException, IOException {
        this.ksIcoColor = this.ksTxtColor;
        this.ksIcoSize = 16;
        this.cmpIco = new KsIcon();
        this.cmpIco.setKsColorBackground(this.ksIcoColor);
        this.cmpIco.setKsSize(this.ksIcoSize);
        this.ksIcoName = "user";
    }

    protected void initLabel() {
        this.ksLabelTitle = "Test";
        this.ksLabelStyle = 0;
        this.ksLabelFont = "Tahoma";
        this.ksLabelSize = this.ksIcoSize - 2;
        this.ksLabelColor = this.ksTxtColor;
        this.cmpLabel = new JLabel(this.ksLabelTitle);
        this.cmpLabel.setForeground(this.ksLabelColor);
        this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
    }

    public void setSizeFit(int size) {
        this.setKsLabelSize(size - 2);
        this.setKsIcoSize(size);
        this.setPreferredSize(new Dimension(this.getSize().width, size + 5));
    }

    public String getKsLabelTitle() {
        return ksLabelTitle;
    }

    public void setKsLabelTitle(String ksLabelTitle) {
        this.ksLabelTitle = ksLabelTitle;
        this.cmpLabel.setText(ksLabelTitle);
    }

    public int getKsLabelSize() {
        return ksLabelSize;
    }

    public void setKsLabelSize(int ksLabelSize) {
        this.ksLabelSize = ksLabelSize;
        this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
    }

    public String getKsIcoName() {
        return ksIcoName;
    }

    public void setKsIcoName(String ksIcoName) {
        this.ksIcoName = ksIcoName;
        this.cmpIco.setKsName(ksIcoName);
    }

    public Color getKsBgColor() {
        return ksBgColor;
    }

    public void setKsBgColor(Color ksBgColor) {
        this.ksBgColor = ksBgColor;
        this.setBackground(this.ksBgColor);
    }

    public Color getKsTxtColor() {
        return ksTxtColor;
    }

    public void setKsTxtColor(Color ksTxtColor) {
        this.ksTxtColor = ksTxtColor;
        this.cmpIco.setKsColorBackground(this.ksTxtColor);
        this.cmpLabel.setForeground(this.ksTxtColor);
    }

    public Color getKsIcoColor() {
        return ksIcoColor;
    }

    public void setKsIcoColor(Color ksIcoColor) {
        this.ksIcoColor = ksIcoColor;
        this.cmpIco.setKsColorBackground(this.ksIcoColor);
    }

    public Color getKsLabelColor() {
        return ksLabelColor;
    }

    public void setKsLabelColor(Color ksLabelColor) {
        this.ksLabelColor = ksLabelColor;
        this.cmpLabel.setForeground(this.ksLabelColor);
    }

    public int getKsLabelStyle() {
        return ksLabelStyle;
    }

    public void setKsLabelStyle(int ksLabelStyle) {
        this.ksLabelStyle = ksLabelStyle;
        this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
    }

    public String getKsLabelFont() {
        return ksLabelFont;
    }

    public void setKsLabelFont(String ksLabelFont) {
        this.ksLabelFont = ksLabelFont;
        this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
    }

    public void setContainer(KsSideBar container) {
        this.container = container;
    }

    public Color getKsBorderColor() {
        return ksBorderColor;
    }

    public void setKsBorderColor(Color ksBorderColor) {
        this.ksBorderColor = ksBorderColor;
        this.setBorder(BorderFactory.createLineBorder(this.ksBorderColor));
    }

    public int getKsSizeHeightMax() {
        return ksSizeHeightMax;
    }

    public void setKsSizeHeightMax(int ksSizeHeightMax) {
        this.ksSizeHeightMax = ksSizeHeightMax;
    }

    public int getKsSizeWidthMax() {
        return ksSizeWidthMax;
    }

    public void setKsSizeWidthMax(int ksSizeWidthMax) {
        this.ksSizeWidthMax = ksSizeWidthMax;
    }

    public int getKsIcoSize() {
        return ksIcoSize;
    }

    public void setKsIcoSize(int ksIcoSize) {
        this.ksIcoSize = ksIcoSize;
        this.cmpIco.setKsSize(this.ksIcoSize);
    }

}
