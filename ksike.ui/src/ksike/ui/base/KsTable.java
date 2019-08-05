package ksike.ui.base;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 22/04/2019
 */
public class KsTable extends JTable implements MouseMotionListener{

    public KsTable() {
        super();
        init();
    }

    public void init() {
        this.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"test11", "test12", "test13", "test14"},
                    {"test21", "test22", "test13", "test14"},
                    /*   {"test31", "test32", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},
                     {"test41", "test42", "test13", "test14"},*/
                    {"test51", "test52", "test13", "test14"}
                },
                new String[]{
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        this.addMouseMotionListener(this);
        //this.add(new MouseMotionAdapter() {});

        this.setGridColor(new java.awt.Color(62, 75, 92));
        this.setSelectionBackground(new java.awt.Color(102, 204, 255));
        this.setSelectionForeground(new java.awt.Color(0, 0, 0));

        this.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (this.getColumnModel().getColumnCount() > 0) {
            this.getColumnModel().getColumn(0).setPreferredWidth(50);
        }
    }



    public boolean validIndex(int index, DefaultTableModel tm) {
        return index >= 0 && index < tm.getRowCount();
    }

    public void clean(DefaultTableModel tm) {
        int total = tm.getRowCount();
        if (tm.getRowCount() > 0) {
            for (int i = 0; i < total; i++) {
                tm.removeRow(0);
            }
        }
    }

    public void addItm(Object[] values) {
        ((DefaultTableModel) this.getModel()).addRow(values);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        int row = this.rowAtPoint(e.getPoint());
        if (row > -1) {
            this.clearSelection();
            this.setRowSelectionInterval(row, row);
        } else {
            this.setSelectionBackground(new Color(60, 141, 188));
        }
    }
}
