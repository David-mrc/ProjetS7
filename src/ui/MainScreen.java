package ui;

import fc.Movie;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainScreen extends ScrollScreen {

    MainScreen(Window window, FCInterface fc) {
        super(new BorderLayout());

        JLabel monthlyTopRentalLabel = Screen.createTitle("Top Movies of the Month");
        pane.add(monthlyTopRentalLabel, BorderLayout.NORTH);

        JPanel monthlyTopRentalsPane = new JPanel();
        ArrayList<Movie> monthlyTopRentals = fc.getMonthlyTopRentals(10);
        for (Movie movie: monthlyTopRentals) {
            JButton movieButton = new JButton(movie.getTitle());
            movieButton.addActionListener(e -> window.openMovieScreen(movie));
            monthlyTopRentalsPane.add(movieButton);
        }
        pane.add(monthlyTopRentalsPane, BorderLayout.CENTER);
    }
}
