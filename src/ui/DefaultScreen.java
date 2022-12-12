package ui;

import javax.swing.*;
import java.awt.*;

public class DefaultScreen extends JPanel {

    DefaultScreen(Window window) {
        super(new GridBagLayout());
        setBackground(new Color(20, 20, 20));

        JButton loginButton = new JButton("Sign In");
        loginButton.addActionListener(e -> window.openLoginScreen());
        add(loginButton);

        JButton createAccountButton = new JButton("Sign Up");
        createAccountButton.addActionListener(e -> {
//            window.openAccountCreation();
        });
        add(createAccountButton);
    }
}
