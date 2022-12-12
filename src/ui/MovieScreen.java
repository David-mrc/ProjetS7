package ui;

import fc.Actor;
import fc.Movie;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovieScreen extends Screen {
    FCInterface fc;
    Window window;
    JPanel pane;
    JLabel title;

    MovieScreen(Window window, FCInterface fc) {
        super(new GridBagLayout());
        this.fc = fc;
        this.window = window;

        pane = new JPanel(new StackLayout());
        pane.setBackground(BACKGROUND);
        add(pane);
    }

    void setMovie(Movie movie) {
        title = createTitle(movie.getTitle());
        pane.add(title);

        JLabel director = new JLabel("Directed by : " +
                movie.getDirectorFirstname() + ' ' + movie.getDirectorLastname());
        director.setForeground(Color.WHITE);
        pane.add(director);

        pane.add(new JLabel(" "));

        ArrayList<Actor> actors = fc.getMovieActors(movie);
        JLabel actorsLabel = new JLabel("Actors : ");
        actorsLabel.setForeground(Color.WHITE);
        pane.add(actorsLabel);
        for (Actor actor : actors) {
            JLabel actorLabel = new JLabel(actor.getFirstName() + ' ' + actor.getLastName());
            actorLabel.setForeground(Color.WHITE);
            pane.add(actorLabel);
        }

        JPanel rentPane = new JPanel();
        rentPane.setBackground(BACKGROUND);
        pane.add(rentPane);

        JButton rentAsBluRayButton = new JButton("Rent as Blu-Ray");
        rentPane.add(rentAsBluRayButton);

        JButton rentAsQRCodeButton = new JButton("Rent as QR Code");
        rentPane.add(rentAsQRCodeButton);
    }

    @Override
    void clear() {
        pane.removeAll();
    }
}
