/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ksike.ui.base;

import java.awt.Color;
import java.awt.FlowLayout;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class KsToolBar extends KsPanel {

    private int ksSizeHeightMax;
    private int ksSizeHeightMin;
    private int ksSizeWidthMax;
    private int ksSizeWidthMin;

    private void init() {
        this.ksSizeHeightMax = 50;
        this.ksSizeHeightMin = -1;
        this.ksSizeWidthMax = -1;
        this.ksSizeWidthMin = -1;

        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        this.setAlignmentY(BOTTOM_ALIGNMENT);
        //this.setLayout(new BorderLayout());
        this.setBackground(new Color(53, 65, 79));
    }

    public KsToolBar() {
        super();
        this.init();
    }

    public KsToolBar(int width, int height) {
        super();
        this.init();
        this.height = height;
        this.width = width;
    }
}
