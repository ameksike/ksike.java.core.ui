package ksike.ui.bite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import ksike.ui.base.KsItemBtn;
import ksike.ui.base.KsImage;
import ksike.ui.base.KsMouseListener;
import ksike.ui.base.KsPanel;
import ksike.ui.base.KsSideBar;
import ksike.ui.base.KsSlide;
import ksike.ui.base.KsTable;
import ksike.ui.base.KsToolBar;
import ksike.ui.base.KsViewport;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsDashboard extends KsViewport {

    public KsBrowser browser;

    private KsPanel cmpWPanel;
    private KsToolBar cmpWTool;
    private KsImage cmpLogo;
    private KsPanel cmpLPanel;
    private KsItemBtn togglew;
    private KsItemBtn toggles;
    protected KsTable log;

    private Color ksWestColor;
    private int ksWestWidth;
    private Color ksNorthColor;
    private int ksNortHeight;
    private Color ksSouthColor;
    private int ksSoutHeight;
    private Color ksCenterColor;

    private String ksLogo;

    public KsDashboard() {
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());

        this.ksWestWidth = 250;
        this.ksNortHeight = 100;
        this.ksSoutHeight = 150;

        this.initRegionEast();
        this.initRegionWest();
        this.initRegionNorth();
        this.initRegionSouth();
        this.initRegionCenter();

    }

    public Color getKsWestColor() {
        return ksWestColor;
    }

    public void setKsWestColor(Color ksWestColor) {
        this.ksWestColor = ksWestColor;
        this.cmpWPanel.setBackground(this.ksWestColor);
    }

    public Color getKsNorthColor() {
        return ksNorthColor;
    }

    public void setKsNorthColor(Color ksNorthColor) {
        this.ksNorthColor = ksNorthColor;
        this.north.setBackground(this.ksNorthColor);
    }

    public Color getKsSouthColor() {
        return ksSouthColor;
    }

    public void setKsSouthColor(Color ksSouthColor) {
        this.ksSouthColor = ksSouthColor;
        this.south.setBackground(this.ksSouthColor);
    }

    public Color getKsCenterColor() {
        return ksCenterColor;
    }

    public void setKsCenterColor(Color ksCenterColor) {
        this.ksCenterColor = ksCenterColor;
        this.center.setBackground(this.ksCenterColor);
    }

    @Override
    protected void initRegionEast() {
        this.east = new KsPanel() {
            @Override
            public Component add(Component comp) {
                return south.add(comp);
            }
        };
        this.east.setLayout(new BorderLayout());
        this.add(this.east, BorderLayout.CENTER);
    }

    @Override
    protected void initRegionWest() {
        Box box = new Box(BoxLayout.Y_AXIS);
        togglew = new KsItemBtn("fa-chevron-left", "icon", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!togglew.isToggle()) {
                    cmpWPanel.setPreferredSize(new Dimension(29, (int) cmpWPanel.getSize().getHeight()));
                    togglew.setKsIcoName("fa-chevron-right");
                } else {
                    cmpWPanel.setPreferredSize(new Dimension(ksWestWidth, cmpWPanel.getHeight()));
                    togglew.setKsIcoName("fa-chevron-left");
                }
                cmpWPanel.updateUI();
            }
        });
        this.cmpWTool = new KsToolBar();
        this.cmpWTool.add(togglew);
        this.cmpLogo = new KsImage();
        this.cmpLogo.setSize(200, 100);
        box.add(this.cmpLogo);
        box.add(cmpWTool);
        this.west = new KsSideBar();
        this.cmpWPanel = new KsPanel(this.ksWestWidth, this.getSize().height);
        this.cmpWPanel.setLayout(new BorderLayout());
        this.cmpWPanel.setBackground(new Color(53, 65, 79));
        this.add(this.cmpWPanel, BorderLayout.WEST);
        this.cmpWPanel.add(box, BorderLayout.NORTH);
        this.cmpWPanel.add(this.west, BorderLayout.CENTER);
    }

    @Override
    protected void initRegionNorth() {
        if (this.east != null) {
            this.north = new KsPanel();
            this.north.setLayout(new BorderLayout());
            this.north.setPreferredSize(new Dimension(this.east.getSize().width, this.ksNortHeight));
            this.setKsNorthColor(new Color(60, 141, 188));
            this.browser = new KsBrowser();
            KsPanel container = new KsPanel();
            container.setLayout(new BorderLayout());
            container.add(this.north, BorderLayout.NORTH);
            container.add(this.browser, BorderLayout.CENTER);
            this.east.add(container, BorderLayout.NORTH);
        } else {
            System.out.println("EAST is null on initRegionNorth");
        }
    }

    @Override
    protected void initRegionSouth() {
        this.log = new KsTable();
        this.log.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Date", "Name", "Description", "Note"
                }
        ));

        this.south = new KsPanel() {
            @Override
            public Component add(Component comp) {
                log.addItm(null);
                return null;
            }

            public Component add(Object[] values) {
                log.addItm(new String[]{"Date", "Name", "Description", "Note"});
                return null;
            }
        };

        //this.setKsSouthColor(new Color(60, 141, 188));
        this.south.setLayout(new BorderLayout());
        
        //this.log.setPreferredScrollableViewportSize(new Dimension(450,63));
        this.log.setFillsViewportHeight(true);

        JScrollPane js = new JScrollPane(this.log);
        js.setVisible(true);
        
        
        toggles = new KsItemBtn("fa-chevron-down", "icon", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!toggles.isToggle()) {
                    south.setPreferredSize(new Dimension((int) south.getSize().getWidth(), 18));
                    toggles.setKsIcoName("fa-chevron-up");
                } else {
                    south.setPreferredSize(new Dimension(south.getWidth(), 150));
                    toggles.setKsIcoName("fa-chevron-down");
                }
                cmpWPanel.updateUI();
            }
        });
        this.cmpWTool = new KsToolBar();
        this.cmpWTool.add(toggles);
        this.south.add(this.cmpWTool, BorderLayout.NORTH);
        this.south.add(js, BorderLayout.CENTER);
        if (this.east != null) {
            this.south.setPreferredSize(new Dimension(this.east.getSize().width, this.ksSoutHeight));
            this.east.add(this.south, BorderLayout.SOUTH);

        } else {
            System.out.println("EAST is null on initRegionSouth");
        }
    }

    @Override
    protected void initRegionCenter() {
        this.center = new KsSlide();
        this.center.setLayout(new BorderLayout());
        this.setKsCenterColor(new Color(213, 219, 227));
        if (this.east != null) {
            this.east.add(this.center, BorderLayout.CENTER);
        } else {
            System.out.println("EAST is null on initRegionCenter");
        }
    }

    public void log(String name, String des, String note, String format) {
        String date = (new SimpleDateFormat(format)).format(new Date());
        log.addItm(new String[]{date, name, des, note});
    }

    public void log(String name, String des, String note) {
        this.log(name, des, note, "dd/MM/yyyy HH:mm:ss");
    }
}
