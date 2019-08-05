package ksike.ui.bite;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import ksike.ui.base.KsPanel;
import ksike.ui.base.KsViewport;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsViewportWest extends KsViewport {

    public KsViewportWest() {
        this.setLayout(new BorderLayout());
        this.initRegionEast();
        this.initRegionWest();
        this.initRegionNorth();
        this.initRegionSouth();
        this.initRegionCenter();
        this.markoutRegion();
    }

    @Override
    protected void initRegionEast() {
        this.east = new KsPanel(){
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
        this.west = new KsPanel();
        this.west.setLayout(new BorderLayout());
        this.west.setPreferredSize(new Dimension(250, this.getSize().height));
        this.add(this.west, BorderLayout.WEST);
    }

    @Override
    protected void initRegionNorth() {
        this.north = new KsPanel();
        this.north.setLayout(new BorderLayout());
        if (this.east != null) {
            this.north.setPreferredSize(new Dimension(this.east.getSize().width, 50));
            this.east.add(this.north, BorderLayout.NORTH);
        } else {
            System.out.println("EAST is null on initRegionNorth");
        }
    }

    @Override
    protected void initRegionSouth() {
        this.south = new KsPanel();
        //this.south.setLayout(new BorderLayout());
        if (this.east != null) {
            this.south.setPreferredSize(new Dimension(this.east.getSize().width, 70));
            this.east.add(this.south, BorderLayout.SOUTH);
        } else {
            System.out.println("EAST is null on initRegionSouth");
        }
    }

    @Override
    protected void initRegionCenter() {
        this.center = new KsPanel();
        this.center.setLayout(new BorderLayout());
        if (this.east != null) {
            this.east.add(this.center, BorderLayout.CENTER);
        } else {
            System.out.println("EAST is null on initRegionCenter");
        }
    }
}
