package ui;

import javax.swing.*;
import java.awt.*;

class TopBar extends JPanel {
    private final static Color BACKGROUND = new Color(6, 6, 6);
    private final JPanel menus;
    private final JButton previousButton;
    private final Component padding;

    TopBar(Window window) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(0, 40));
        setBackground(BACKGROUND);

        JPanel leftPane = new JPanel();
        leftPane.setBackground(BACKGROUND);

        previousButton = new JButton("←");
        previousButton.addActionListener(e -> window.previous());
        leftPane.add(previousButton);

        padding = Box.createRigidArea(new Dimension(75, 0));
        leftPane.add(padding);

        leftPane.add(Box.createRigidArea(new Dimension(65, 0)));

        JLabel AL2000Label = new JLabel("AL2000");
        AL2000Label.setForeground(Color.ORANGE);
        AL2000Label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        leftPane.add(AL2000Label);

        add(leftPane, BorderLayout.WEST);

        menus = new JPanel();
        menus.setBackground(BACKGROUND);
        menus.add(new JButton("Movies"));
        menus.add(new JButton("Categories"));
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
