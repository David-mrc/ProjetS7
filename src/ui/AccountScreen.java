package ui;

import fc.Movie;
import fc.User;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccountScreen extends Screen {
    FCInterface fc;


    AccountScreen(Window window, FCInterface fc) {
        super(new StackLayout());
        this.fc = fc;

        JLabel userInfo = createTitle("User Information - ");
        add(userInfo, BorderLayout.CENTER);

        User currentUser =  fc.getUser();
        JLabel name = createText("Name  -  " + currentUser.getFirstname() + " " + currentUser.getLastName());
        add(name, BorderLayout.CENTER);

        JLabel address;
        if(currentUser.getAddress() != null){
            address = createText("Address  -    "  + currentUser.getAddress());
        } else {
            address = createText("Address  -    " + "Not Given");
        }
        add(address, BorderLayout.CENTER);

        JLabel dob;
        if(currentUser.getBirthday() != null){
            dob = createText("Date of Birth  -    "  + currentUser.getBirthday());
        } else {
            dob = createText("Date of Birth  -    "  + "Not Given");
        }
        add(dob, BorderLayout.CENTER);

        JLabel sub;
        if(currentUser.isSubscriber()) {
            sub = createText("Proud Subscriber ! ");
        } else {
            sub = createText("Not Subscribed ... ");
        }
        add(sub, BorderLayout.CENTER);

        JLabel history = createTitle("Past Rentals - ");
        add(history, BorderLayout.CENTER);

        ArrayList<Movie> historyArray = fc.getHistory();

        JPanel historyPane = new JPanel();
        for(Movie m : historyArray){
            JButton movieButton = new JButton(m.getTitle());
            movieButton.addActionListener(e -> window.openMovieScreen(m));
            historyPane.add(movieButton);
        }
        add(historyPane, BorderLayout.CENTER);

        if(currentUser.isSubscriber()) {
            JLabel cards = createTitle("Subscriber Card - ");
            add(cards, BorderLayout.CENTER);
            JLabel balance = createText("Balance - " + fc.getBalance() + "€");
            add(balance, BorderLayout.CENTER);
        }
    }

    private JLabel createText(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        return label;
    }
}
