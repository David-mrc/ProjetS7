package ui;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JPanel {
    JTextField idField;

    LoginScreen(Window window) {
        super(new GridBagLayout());
        setBackground(new Color(20, 20, 20));

        JPanel pane = new JPanel(new BorderLayout());
        pane.setBackground(new Color(20, 20, 20));

        JPanel northPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPane.setBackground(new Color(20, 20, 20));
        JLabel title = new JLabel("Sign In");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setForeground(Color.ORANGE);
        northPane.add(title);
        pane.add(northPane, BorderLayout.NORTH);

        JLabel idLabel = new JLabel("Username : ");
        idLabel.setForeground(Color.WHITE);
        pane.add(idLabel, BorderLayout.WEST);

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 30));
        pane.add(idField, BorderLayout.CENTER);

        JButton signInButton = new JButton("Sign In");
        pane.add(signInButton, BorderLayout.EAST);

        add(pane);
    }

    void clear() {
        idField.setText("");
    }
}
