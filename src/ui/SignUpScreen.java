package ui;

import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;

public class SignUpScreen extends Screen {
    JTextField idField, firstNameField, lastNameField, addressField;
    JLabel feedBackLabel;

    SignUpScreen(Window window, FCInterface fc) {
        super(new GridBagLayout());

        JPanel pane = new JPanel(new BorderLayout());
        pane.setBackground(BACKGROUND);

        JPanel northPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPane.setBackground(BACKGROUND);
        JLabel title = new JLabel("Sign Up");
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

        JPanel firstNamePane = new JPanel(new BorderLayout());
        firstNamePane.setBackground(BACKGROUND);
        JLabel firstNameLabel = new JLabel("First Name : ");
        firstNameLabel.setForeground(Color.WHITE);
        firstNamePane.add(firstNameLabel, BorderLayout.CENTER);
        firstNameField = new JTextField();
        firstNameField.setPreferredSize(new Dimension(200, 30));
        firstNamePane.add(firstNameField, BorderLayout.EAST);

        JPanel lastNamePane = new JPanel(new BorderLayout());
        lastNamePane.setBackground(BACKGROUND);
        JLabel lastNameLabel = new JLabel("Last Name : ");
        lastNameLabel.setForeground(Color.WHITE);
        lastNamePane.add(lastNameLabel, BorderLayout.CENTER);
        lastNameField = new JTextField();
        lastNameField.setPreferredSize(new Dimension(200, 30));
        lastNamePane.add(lastNameField, BorderLayout.EAST);

        JPanel addressPane = new JPanel(new BorderLayout());
        addressPane.setBackground(BACKGROUND);
        JLabel addressLabel = new JLabel("Address : ");
        addressLabel.setForeground(Color.WHITE);
        addressPane.add(addressLabel, BorderLayout.CENTER);
        addressField = new JTextField();
        addressField.setPreferredSize(new Dimension(200, 30));
        addressPane.add(addressField, BorderLayout.EAST);

        JPanel signUpPane = new JPanel(new BorderLayout());
        signUpPane.setBackground(BACKGROUND);
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> {
            int id;
            String firstName, lastName, address;

            try {
                id = Integer.parseInt(idField.getText());
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                address = addressField.getText();
            } catch (Exception ex) {
                feedBackLabel.setText("Can't create account");
                return;
            }

            if (fc.createAccount(id, firstName, lastName, address)) {
                window.openMainScreen();
            } else {
                feedBackLabel.setText("Can't create account");
            }
        });
        signUpPane.add(signUpButton, BorderLayout.CENTER);

        feedBackLabel = new JLabel("");
        feedBackLabel.setForeground(Color.RED);

        signUpPane.add(feedBackLabel, BorderLayout.SOUTH);
        addressPane.add(signUpPane, BorderLayout.SOUTH);
        lastNamePane.add(addressPane, BorderLayout.SOUTH);
        firstNamePane.add(lastNamePane, BorderLayout.SOUTH);
        idPane.add(firstNamePane, BorderLayout.SOUTH);
        pane.add(idPane, BorderLayout.SOUTH);
        add(pane);
    }

    @Override
    void clear() {
        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        addressField.setText("");
        feedBackLabel.setText("");
    }
}
