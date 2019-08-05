package ksike.ui.test;

import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import ksike.ui.bite.KsDashboard;
import ksike.ui.base.KsMouseListener;

/**
 * @author Antonio Membrides Espinosa
 * @version 1.0
 * @made 23/04/2019
 */
public class UiMain {

    public static void main(String[] args) {
        KsDashboard ds = new KsDashboard();
        //......................................................................
        ds.west.add("bookmark", "Grupo");
        ds.west.add("apple", "Ejemplo1", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ds.center.add(new JLabel("Ejeeeee 1"));
                System.out.println("Ejemplo1 ...............");
            }
        });
        ds.west.add("bell", "Ejemplo2", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ds.center.add(new JLabel("TITIITITITIT"));
                System.out.println("Ejemplo2 ...............");
            }
        });
        ds.west.add("bookmark", "Grupo 2");
        ds.west.add("bluetooth", "Ejemplo3", new KsMouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ds.center.add(new Exfrom());
                ds.east.add(new JLabel("QQQQQQQQQQQQQQQQQQQ"));
                System.out.println("Ejemplo3 ...............");
                ds.browser.add("Ejemplo3", "raroooooo", new KsMouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ds.center.add(new Exfrom());
                        ds.east.add(new JLabel("QQQQQQQQQQQQQQQQQQQ"));
                        System.out.println("Ejemplo3 ...............");
                    }
                });
                ds.browser.add("apple", "icon", new KsMouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ds.center.add(new JLabel("Ejeeeee 1"));
                        System.out.println("Ejemplo1 ...............");
                    }
                });
                ds.browser.add("Ejemplo3", "label", new KsMouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        System.out.println((new Date()).toString());
                        ds.south.add(new String[]{"MAMAMA", "tatat", "tatata", "taata"});
                        ds.center.add(new JLabel("TITIITITITIT"));
                        System.out.println("Ejemplo2 ...............");
                    }
                });
            }
        });
        //......................................................................

        JFrame ui = new JFrame("Test Demo basado en codigo");

        System.out.println("*********************************");
        System.out.println("SELECT xx".contains("SELECT"));
        //ui.setLayout(new BorderLayout());
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.add(ds);
        ui.setVisible(true);
        ui.setSize(1024, 768);

        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        String formattedDate = formatter.format(LocalDate.now());

       

        String dateString = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date());

        System.out.println(dateString);
    }
}
