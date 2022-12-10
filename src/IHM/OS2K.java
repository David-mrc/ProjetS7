package IHM;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;


import javax.swing.*;

public class OS2K implements Runnable {

    App monApplication;
    JButton login;
    JFrame frame;

    public void run() {

        frame = new JFrame("CyberVideo AL2000");
        monApplication = new App();
        monApplication.demarre(frame);

        Box barreHorizontale = Box.createHorizontalBox();
        login = creerBouton("Log In");
        barreHorizontale.add(login);
        frame.add(barreHorizontale, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 510);
        frame.setVisible(true);
    }

    public JButton creerBouton(String nomBouton) {
        JButton bouton = new JButton(nomBouton);
        bouton.addActionListener((ActionListener) new AdapteurSouris());
        bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bouton.setFocusable(false);
        return bouton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new OS2K());
    }

}

