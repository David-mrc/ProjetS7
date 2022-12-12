package ui;

import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen {
    JTextField idField;
    JLabel feedBackLabel;

    LoginScreen(Window window, FCInterface fc) {
        super(new GridBagLayout());

        JPanel pane = new JPanel(new BorderLayout());
        pane.setBackground(BACKGROUND);

        JPanel northPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPane.setBackground(BACKGROUND);
        JLabel title = new JLabel("Sign In");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setForeground(Color.ORANGE);
        northPane.add(title);
        pane.add(northPane, BorderLayout.NORTH);

        JPanel idPane = new JPanel(new BorderLayout());
        idPane.setBackground(BACKGROUND);
        JLabel idLabel = new JLabel("UserID : ");
        idLabel.setForeground(Color.WHITE);
        idPane.add(idLabel, BorderLayout.CENTER);
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(200, 30));
        idPane.add(idField, BorderLayout.EAST);

        JPanel signInPane = new JPanel(new BorderLayout());
        signInPane.setBackground(BACKGROUND);
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(e -> {
            int id = -1;

            try {
                id = Integer.parseInt(idField.getText());
            } catch (Exception ex) {
                feedBackLabel.setText("Can't log in");
            }

            if (fc.login(id)) {
                window.openMainScreen();
            } else {
                feedBackLabel.setText("Can't log in");
            }
        });
        signInPane.add(signInButton, BorderLayout.CENTER);

        feedBackLabel = new JLabel("");
        feedBackLabel.setForeground(Color.RED);

        signInPane.add(feedBackLabel, BorderLayout.SOUTH);
        idPane.add(signInPane, BorderLayout.SOUTH);
        pane.add(idPane, BorderLayout.EAST);
        add(pane);
    }

    @Override
    void clear() {
        idField.setText("");
        feedBackLabel.setText("");
    }
}
