package IHM;

import java.awt.Component;
import fc.FCInterface;
import javax.swing.*;
import IHM.VueApp;


public class App {

    FCInterface fc;
    VueApp vue;
    JFrame f;

    public void demarre(JFrame fenetreAppli) {
        fc = new FCInterface(this);
        vue = new VueApp(this);
        f = fenetreAppli;
    }

}