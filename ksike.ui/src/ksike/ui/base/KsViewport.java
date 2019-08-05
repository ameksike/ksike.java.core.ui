package ksike.ui.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsViewport extends KsPanel {

    public KsPanel north;
    public KsPanel south;
    public KsPanel west;
    public KsPanel east;
    public KsPanel center;

    public KsViewport() {
        this.setLayout(new BorderLayout());
        this.initRegionNorth();
        this.initRegionSouth();
        this.initRegionWest();
        this.initRegionEast();
        this.initRegionCenter();
            
        //this.markoutRegion();
    }

    public void markoutRegion() {
        this.north.setBackground(Color.black);
        this.south.setBackground(Color.black);
        
        this.west.setBackground(Color.green);
        this.east.setBackground(Color.blue);
        this.center.setBackground(Color.white);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1024, 768);
    }

    protected void initRegionNorth() {
        this.north = new KsPanel();
        this.north.setPreferredSize(new Dimension(this.getSize().width, 50));
        this.north.setLayout(new BorderLayout());
        this.add(this.north, BorderLayout.NORTH);
    }

    protected void initRegionSouth() {
        this.south = new KsPanel();
        this.south.setPreferredSize(new Dimension(this.getSize().width, 70));
        this.south.setLayout(new BorderLayout());
        this.add(this.south, BorderLayout.SOUTH);
    }

    protected void initRegionWest() {
        this.west = new KsPanel();
        this.west.setPreferredSize(new Dimension(250, this.getSize().height));
        this.west.setLayout(new BorderLayout());
        this.add(this.west, BorderLayout.WEST);
    }

    protected void initRegionEast() {
        this.east = new KsPanel();
        this.east.setPreferredSize(new Dimension(50, this.getSize().height));
        this.east.setLayout(new BorderLayout());
        this.add(this.east, BorderLayout.EAST);
    }

    protected void initRegionCenter() {
        this.center = new KsPanel();
        this.center.setLayout(new BorderLayout());
        this.add(this.center, BorderLayout.CENTER);
    }
}
