package ksike.ui.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 22/04/2019
 */
public class KsItemBtn extends KsPanel implements MouseListener {

    protected KsIcon cmpIco;
    protected JLabel cmpLabel;
    protected boolean toggle;

    protected Color ksColorFit;
    protected Color ksColorBorder;
    protected Color ksColorBackground;
    protected Color ksColorMouseLeave;
    protected Color ksColorMousePress;
    protected Color ksColorMouseRelease;
    protected Color ksColorMouseOver;

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

    public KsItemBtn() {
        super();
        this.initProperties();
        this.initLayout();
        this.initCmp();
        this.addMouseListener(this);
    }

    public KsItemBtn(String value, String type) {
        super();
        this.initProperties();
        this.initLayout();
        this.initCmp(value, type);
        this.addMouseListener(this);
    }

    public KsItemBtn(String value, String type, KsMouseListener handler) {
        super();
        this.initProperties();
        this.initLayout();
        this.initCmp(value, type);
        this.addMouseListener(handler);
        this.addMouseListener(this);
    }

    private void initCmp() {
        this.initIcon();
        this.initLabel();
        this.update();
    }

    private void initCmp(String value, String type) {
        switch (type) {
            case "icon":
                this.ksIcoName = value;
                this.cmpLabel = null;
                this.initIcon();
                break;

            case "label":
                this.ksLabelTitle = value;
                this.cmpIco = null;
                this.initLabel();
                break;

            default:
                this.ksIcoName = value;
                this.ksLabelTitle = type;
                this.initIcon();
                this.initLabel();
                break;

        }
        this.update();
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public void setTogle() {
        this.toggle = !toggle;
    }

    private void initProperties() {
        this.cmpIco = null;
        this.cmpLabel = null;
        this.ksIcoName = "user";
        this.ksLabelTitle = "Test";
        this.toggle = false;

        this.ksColorFit = Color.WHITE;
        this.ksColorBackground = new Color(53, 65, 79);
        this.ksColorMouseOver = new Color(62, 75, 92);
        this.ksColorMousePress = new Color(14, 18, 22);
        this.ksColorMouseLeave = this.ksColorBackground;
        this.ksColorMouseRelease = this.ksColorBackground;
        this.ksColorBorder = this.ksColorBackground;

        this.setKsColorBackground(this.ksColorBackground);
        this.setKsColorBorder(this.ksColorBorder);
    }

    private void initLayout() {
        BorderLayout bl = new BorderLayout();
        bl.setHgap(2);
        bl.setVgap(2);
        this.setLayout(bl);
    }

    private void update() {
        //int width = 8;
        //int height = (int) this.getSize().getHeight();
        this.removeAll();
        this.add(this.getBox(), BorderLayout.CENTER);
        if (this.cmpIco != null) {
            width += KsFont.self().getHeight(this.cmpIco.getFont());
        }
        if (this.cmpLabel != null) {
            width += KsFont.self().getWidth(this.cmpLabel.getText());
        }
        //System.out.println("**update********************");
        //System.out.println("**width****" + width + "  " + height);
        //this.setPreferredSize(new Dimension(width, height==0 ? height : 20 ));
        this.repaint();
        this.revalidate();
    }

    private Box getBox() {
        Box box = new Box(BoxLayout.X_AXIS);
        box.add(Box.createVerticalGlue());
        box.add(Box.createHorizontalStrut(2));
        if (this.cmpIco != null) {
            this.cmpIco.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            this.cmpIco.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            box.add(Box.createHorizontalStrut(2));
            box.add(this.cmpIco);
            box.add(Box.createHorizontalStrut(2));
        }

        if (this.cmpLabel != null) {
            this.cmpLabel.setAlignmentY(JComponent.CENTER_ALIGNMENT);
            this.cmpLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            box.add(Box.createHorizontalStrut(2));
            box.add(this.cmpLabel);
            box.add(Box.createHorizontalStrut(2));
        }
        box.add(Box.createHorizontalStrut(2));
        box.add(Box.createVerticalGlue());
        return box;
    }

    private void initIcon() {
        try {
            this.ksIcoSize = 16;
            this.ksIcoColor = this.ksColorFit;
            this.cmpIco = new KsIcon();
            this.cmpIco.setKsColorBackground(this.ksIcoColor);
            this.cmpIco.setKsSize(this.ksIcoSize);
            this.cmpIco.setKsName(this.ksIcoName);
            this.cmpIco.setVisible(true);

        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(KsItemBtn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initLabel() {
        this.ksLabelStyle = 0;
        this.ksLabelFont = "Tahoma";
        this.ksLabelSize = this.ksIcoSize - 2;
        this.ksLabelColor = this.ksColorFit;
        this.cmpLabel = new JLabel(this.ksLabelTitle);
        this.cmpLabel.setForeground(this.ksLabelColor);
        this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
        this.cmpLabel.setVisible(true);
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
        if (this.cmpLabel != null) {
            this.cmpLabel.setText(ksLabelTitle);
            if (this.ksLabelTitle.isEmpty()) {
                this.setPreferredSize(new Dimension(this.cmpIco.getWidth() + 10, this.getHeight()));
            }
        }
    }

    public int getKsLabelSize() {
        return ksLabelSize;
    }

    public void setKsLabelSize(int ksLabelSize) {
        this.ksLabelSize = ksLabelSize;
        if (this.cmpLabel != null) {
            this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
        }
    }

    public String getKsIcoName() {
        return ksIcoName;
    }

    public void setKsIcoName(String ksIcoName) {
        this.ksIcoName = ksIcoName;
        this.cmpIco.setKsName(ksIcoName);
        if (this.ksIcoName.isEmpty()) {
            this.cmpIco.setVisible(false);
            this.setPreferredSize(new Dimension(this.cmpLabel.getWidth() + 10, this.getHeight()));
        } else {
            this.cmpIco.setVisible(true);
        }
    }

    public Color getKsColorFit() {
        return ksColorFit;
    }

    public void setKsColorFit(Color ksColorFit) {
        this.ksColorFit = ksColorFit;
        if (this.cmpIco != null) {
            this.cmpIco.setKsColorBackground(this.ksColorFit);
        }
        if (this.cmpLabel != null) {
            this.cmpLabel.setForeground(this.ksColorFit);
        }
    }

    public Color getKsIcoColor() {
        return ksIcoColor;
    }

    public void setKsIcoColor(Color ksIcoColor) {
        this.ksIcoColor = ksIcoColor;
        if (this.cmpIco != null) {
            this.cmpIco.setKsColorBackground(this.ksIcoColor);
        }
    }

    public Color getKsLabelColor() {
        return ksLabelColor;
    }

    public void setKsLabelColor(Color ksLabelColor) {
        this.ksLabelColor = ksLabelColor;
        if (this.cmpLabel != null) {
            this.cmpLabel.setForeground(this.ksLabelColor);
        }
    }

    public int getKsLabelStyle() {
        return ksLabelStyle;
    }

    public void setKsLabelStyle(int ksLabelStyle) {
        this.ksLabelStyle = ksLabelStyle;
        if (this.cmpLabel != null) {
            this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
        }
    }

    public String getKsLabelFont() {
        return ksLabelFont;
    }

    public void setKsLabelFont(String ksLabelFont) {
        this.ksLabelFont = ksLabelFont;
        if (this.cmpLabel != null) {
            this.cmpLabel.setFont(new java.awt.Font(this.ksLabelFont, this.ksLabelStyle, this.ksLabelSize));
        }
    }

    public Color getKsColorBorder() {
        return ksColorBorder;
    }

    public void setKsColorBorder(Color ksColorBorder) {
        this.ksColorBorder = ksColorBorder;
        this.setBorder(BorderFactory.createLineBorder(this.ksColorBorder));
    }

    public Color getKsColorBackground() {
        return ksColorBackground;
    }

    public void setKsColorBackground(Color ksColorBackground) {
        this.ksColorBackground = ksColorBackground;
        this.setBackground(this.ksColorBackground);
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

    public Color getKsColorMouseOver() {
        return ksColorMouseOver;
    }

    public void setKsColorMouseOver(Color ksColorMouseOver) {
        this.ksColorMouseOver = ksColorMouseOver;
    }

    public int getKsSizeHeightMin() {
        return ksSizeHeightMin;
    }

    public void setKsSizeHeightMin(int ksSizeHeightMin) {
        this.ksSizeHeightMin = ksSizeHeightMin;
    }

    public int getKsSizeWidthMin() {
        return ksSizeWidthMin;
    }

    public void setKsSizeWidthMin(int ksSizeWidthMin) {
        this.ksSizeWidthMin = ksSizeWidthMin;
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
        if (this.cmpIco != null) {
            this.cmpIco.setKsSize(this.ksIcoSize);
        }
    }

    @Override
    public void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
        if (this.cmpIco != null) {
            this.cmpIco.addMouseListener(l);
        }
        if (this.cmpLabel != null) {
            this.cmpLabel.addMouseListener(l);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setBackground(this.ksColorMouseRelease);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setTogle();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(this.ksColorMousePress);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(this.ksColorMouseRelease);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(this.ksColorMouseOver);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(this.ksColorMouseLeave);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

}
