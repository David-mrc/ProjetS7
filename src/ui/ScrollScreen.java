package ui;

import javax.swing.*;
import java.awt.*;

public abstract class ScrollScreen extends JScrollPane {
    protected final static Color BACKGROUND = new Color(20, 20, 20);

    ScrollScreen() {
        setBackground(BACKGROUND);
    }

    void clear() {}
}
