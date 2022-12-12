package ui;

import javax.swing.*;
import java.awt.*;

public abstract class ScrollScreen extends JScrollPane {
    protected final static Color BACKGROUND = new Color(20, 20, 20);
    protected final JPanel pane;

    ScrollScreen(LayoutManager layout) {
        pane = new JPanel(layout);
        pane.setBackground(BACKGROUND);
        add(pane);
    }

    void clear() {}
}
