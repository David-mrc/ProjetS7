package IHM;

import fc.interfaces.CyberVideoInterface;
import fc.interfaces.DBInterface;
import fc.interfaces.FCInterface;
import javax.swing.*;


public class App {

    FCInterface fc;
    VueApp vue;
    JFrame f;

    public void demarre(JFrame fenetreAppli) {
        fc = new FCInterface(this, new CyberVideoInterface(), new DBInterface());
        vue = new VueApp(this);
        f = fenetreAppli;
    }

}