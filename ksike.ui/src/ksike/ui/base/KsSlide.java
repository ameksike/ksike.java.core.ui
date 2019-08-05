package ksike.ui.base;

import java.awt.Component;
import javax.swing.BoxLayout;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsSlide extends KsPanel{
    
    public KsSlide(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    @Override
    public Component add(Component comp) {
        this.removeAll();
        super.add(comp);        
        this.repaint();
        this.revalidate();
        return comp;
    }
}
