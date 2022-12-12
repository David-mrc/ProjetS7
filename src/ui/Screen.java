package ui;

import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {
    protected final static Color BACKGROUND = new Color(20, 20, 20);

    Screen(LayoutManager layout) {
        super(layout);
        setBackground(BACKGROUND);
    }

    void clear() {}

    protected static JLabel createTitle(String title) {
        JLabel label = new JLabel(title);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
}
