package ksike.ui.base;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsImage extends JLabel {

    private String ksPath;
    private ImageIcon ksico;

    private int ksSizeHeight;
    private int ksSizeWidth;

    public KsImage() {
        this.ksico = null;

        this.ksSizeHeight = 50;
        this.ksSizeWidth = 100;

        this.setText("");
        this.setKsPath("/ksike/ui/img/kui.ico.png");
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
    }

    public String getKsPath() {
        return ksPath;
    }

    public void updateSize() {
        
        this.setIcon(new ImageIcon(this.ksico.getImage().getScaledInstance(
                this.ksSizeWidth, //this.ksSizeWidth == 0 ? super.getWidth() : this.ksSizeWidth, 
                this.ksSizeHeight, //this.ksSizeHeight == 0 ? super.getHeight() : this.ksSizeHeight, 
                Image.SCALE_SMOOTH
        )));
    }

    public void setKsPath(String ksPath) {
        this.ksPath = ksPath;
        this.ksico = new ImageIcon(getClass().getResource(this.ksPath));
        this.updateSize();
    }

    @Override
    public void setSize(int width, int height) {
        //super.setSize(width, height);
        this.ksSizeHeight = height;
        this.ksSizeWidth = width;
        this.updateSize();
    }

    public int getKsSizeHeight() {
        return ksSizeHeight;
    }

    public void setKsSizeHeight(int ksSizeHeight) {
        this.ksSizeHeight = ksSizeHeight;
        this.updateSize();
    }

    public int getKsSizeWidth() {
        return ksSizeWidth;
    }

    public void setKsSizeWidth(int ksSizeWidth) {
        this.ksSizeWidth = ksSizeWidth;
        this.updateSize();
    }

    @Override
    public void setText(String text) {
        super.setText("");
    }
}
