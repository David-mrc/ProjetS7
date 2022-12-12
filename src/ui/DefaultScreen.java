package ui;

import javax.swing.*;
import java.awt.*;

public class DefaultScreen extends Screen {

    DefaultScreen(Window window) {
        super(new GridBagLayout());

        JButton loginButton = new JButton("Sign In");
        loginButton.addActionListener(e -> window.openLoginScreen());
        add(loginButton);

        JButton createAccountButton = new JButton("Sign Up");
        createAccountButton.addActionListener(e -> window.openSignUpScreen());
        add(createAccountButton);
    }
}
