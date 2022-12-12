package ui;

import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends ScrollScreen {

    MainScreen(Window window, FCInterface fc) {
        super(new BorderLayout());

        JLabel weeklyTopRentalLabel = createTitle("Top Movies of the Week");
        pane.add(weeklyTopRentalLabel, BorderLayout.NORTH);

        fc.getWeeklyTopRentals(10);
        JButton movie = new JButton();
    }

    private JLabel createTitle(String title) {
        JLabel label = new JLabel(title);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }
}
