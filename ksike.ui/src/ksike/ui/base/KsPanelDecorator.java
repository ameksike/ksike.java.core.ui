package ksike.ui.base;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author jose.rod
 */
public class KsPanelDecorator extends KsPanel {

    protected JPanel item;
    protected int flag;

    public KsPanelDecorator() {
        super();
        this.flag = 0;
    }

    protected Component decorate(Component comp) {
        if (this.flag == 0) {
            this.flag++;
            this.item = (JPanel) comp;
            System.out.println("KsPanelDecorator: FIRSSSSSS");
            return super.add(comp);
        } else {
            if (this.item != null) {
                System.out.println("KsPanelDecorator: on item");
                return this.item.add(comp);
            } else {
                System.out.println("KsPanelDecorator: on item null ");
                return null;
            }
        }
    }

    @Override
    public Component add(Component comp) {
        return this.decorate(comp);
    }

    @Override
    public Component add(KsPanel comp) {
        return this.decorate(comp);
    }

    @Override
    public Component add(KsPanel comp, String id, String label) {
        return this.decorate(comp);
    }
}
