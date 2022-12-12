package ui;

import fc.Movie;
import fc.User;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccountScreen extends ScrollScreen {
    FCInterface fc;


    AccountScreen(Window window, FCInterface fc) {
        super(new BorderLayout());
        this.fc = fc;

        JLabel userInfo = createTitle("User Information - ");
        pane.add(userInfo, BorderLayout.NORTH);

        User currentUser =  fc.getUser();
        JLabel name = createText("Name  -  " + currentUser.getFirstname() + " " + currentUser.getLastName());

        JLabel address;
        if(currentUser.getAddress() != null){
            address = createText("Address  -  " + " " + currentUser.getAddress());
        } else {
            address = createText("Address  -  " + " " + "Not Given");
        }
        pane.add(address, BorderLayout.CENTER);

        JLabel dob;
        if(currentUser.getBirthday() != null){
            dob = createText("Date of Birth  -  " + " " + currentUser.getBirthday());
        } else {
            dob = createText("Date of Birth  -  " + " " + "Not Given");
        }
        pane.add(dob, BorderLayout.CENTER);

        if(currentUser.isSubscriber()) {
            JLabel sub = createText("Proud Subscriber ! ");
            pane.add(sub, BorderLayout.CENTER);
        }

        JLabel history = createTitle("Past Rentals - ");
        pane.add(history, BorderLayout.CENTER);

        ArrayList<Movie> historyArray = fc.getHistory();

        JPanel historyPane = new JPanel();
        for(Movie m : historyArray){
            JButton movieButton = new JButton(m.getTitle());
            movieButton.addActionListener(e -> window.openMovieScreen(m));
            historyPane.add(movieButton);
        }
        pane.add(historyPane, BorderLayout.CENTER);

        //TODO: add card status.
    }

    private JLabel createTitle(String title) {
        JLabel label = new JLabel(title);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        return label;
    }

    private JLabel createText(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.ORANGE);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        return label;
    }
}
