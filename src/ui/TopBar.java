package ui;

import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;

class TopBar extends JPanel {
    private final static Color BACKGROUND = new Color(6, 6, 6);
    private final JPanel menus;
    private final JButton previousButton;
    private final Component padding;

    TopBar(Window window, FCInterface fc) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(0, 40));
        setBackground(BACKGROUND);

        JPanel leftPane = new JPanel();
        leftPane.setBackground(BACKGROUND);

        previousButton = new JButton("←");
        previousButton.addActionListener(e -> window.previous());
        leftPane.add(previousButton);

        padding = Box.createRigidArea(new Dimension(46, 0));
        leftPane.add(padding);

        leftPane.add(Box.createRigidArea(new Dimension(90, 0)));

        JLabel AL2000Label = new JLabel("AL2000");
        AL2000Label.setForeground(Color.ORANGE);
        AL2000Label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        leftPane.add(AL2000Label);

        add(leftPane, BorderLayout.WEST);

        menus = new JPanel();
        menus.setBackground(BACKGROUND);

        JButton UserButton = new JButton("Profile");
        UserButton.addActionListener(e -> window.openAccountScreen());
        menus.add(UserButton);

        JButton signOutButton = new JButton("Sign out");
        signOutButton.addActionListener(e -> {
            window.openDefaultScreen();
            fc.logout();
        });
        menus.add(signOutButton);

        add(menus, BorderLayout.EAST);
    }

    void showPrevious() {
        previousButton.setVisible(true);
        padding.setVisible(false);
    }

    void hidePrevious() {
        previousButton.setVisible(false);
        padding.setVisible(true);
    }

    void showMenus() {
        menus.setVisible(true);
    }

    void hideMenus() {
        menus.setVisible(false);
    }
}
