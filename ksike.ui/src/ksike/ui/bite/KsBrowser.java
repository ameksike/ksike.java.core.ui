package ksike.ui.bite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import ksike.ui.base.KsItemBtn;
import ksike.ui.base.KsMouseListener;
import ksike.ui.base.KsPanel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsBrowser extends KsPanel {

    protected KsPanel cmpLts;
    protected KsItemBtn cmpBtnPv;
    protected KsItemBtn cmpBtnNx;

    protected int ksHeight;
    protected int ksBtnWidth;
    protected int index;

    public KsBrowser() {
        this.init();
        this.index = 0;
    }

    public void init() {
        this.ksHeight = 20;
        this.ksBtnWidth = 50;
        this.setLayout(new BorderLayout());
        this.initLeft();
        this.initRigth();
        this.initCenter();
    }

    public void initLeft() {
        this.cmpBtnPv = new KsItemBtn("fa-chevron-left", "icon", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (index > 0) {
                    Component tmp = cmpLts.getComponent(--index);
                    ((KsBrowserItem) tmp).dispatchEvent(e);
                }
            }
        }) ;
        this.add(this.cmpBtnPv, BorderLayout.LINE_START);
    }

    public void initRigth() {
        this.cmpBtnNx = new KsItemBtn("fa-chevron-right", "icon", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (index < cmpLts.getComponents().length) {
                    Component tmp = cmpLts.getComponent(index++);
                    ((KsBrowserItem) tmp).dispatchEvent(e);
                }
            }
        });
        this.add(this.cmpBtnNx, BorderLayout.LINE_END);
    }

    public void initCenter() {
        this.cmpLts = new KsPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(this.getWidth(), ksHeight);
            }
        };

        this.cmpLts.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.cmpLts.setBackground(new Color(53, 65, 79));
        this.add(this.cmpLts, BorderLayout.CENTER);
    }

    public void itemReset() {
        this.itemReset(null);
    }

    public void itemReset(KsBrowserItem active) {
        for (Component elm : this.cmpLts.getComponents()) {
            if (elm instanceof KsBrowserItem) {
                this.itemReset((KsBrowserItem) elm, active);
            }
        }
    }

    public void clean() {
        this.cmpLts.removeAll();
        this.index = 0;
        this.update();
    }

    public void update() {
        this.repaint();
        this.revalidate();
    }

    public void itemReset(KsBrowserItem elm, KsBrowserItem active) {
        if (active != null && elm.equals(active)) {
            elm.setKsActive(true);
            elm.setBackground(elm.getKsColorMousePress());
        } else {
            elm.setKsActive(false);
            elm.setBackground(elm.getKsColorBackground());
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public Component add(String id, String label, KsMouseListener handler) {
        KsBrowserItem tmp = new KsBrowserItem(id, label, handler);
        tmp.setKsIndex(this.cmpLts.getComponents().length);
        tmp.setPreferredSize(new Dimension(ksBtnWidth, this.getHeight() + 10));
        tmp.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        tmp.setContainer(this);
        return this.cmpLts.add(tmp);
    }

    public class KsBrowserItem extends KsItemBtn {

        protected KsBrowser container;
        protected boolean ksActive;
        protected int ksIndex;

        public KsBrowserItem() {
            super();
        }

        public KsBrowserItem(String id, String label, KsMouseListener handler) {
            super(id, label, handler);
        }

        public boolean isKsActive() {
            return ksActive;
        }

        public void setKsActive(boolean ksActive) {
            this.ksActive = ksActive;
        }

        public int getKsIndex() {
            return ksIndex;
        }

        public void setKsIndex(int ksIndex) {
            this.ksIndex = ksIndex;
        }

        public void setContainer(KsBrowser container) {
            this.container = container;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            this.container.itemReset(this);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            if (this.isKsActive()) {
                this.setBackground(this.ksColorMousePress);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            this.container.setIndex(this.getKsIndex());
        }

    }
}
