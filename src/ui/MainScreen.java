package ui;

import fc.Movie;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainScreen extends Screen {
    private final static Dimension BUTTON_SIZE = new Dimension(0, 100);

    MainScreen(Window window, FCInterface fc) {
        super(new BorderLayout());

        // Weekly Top Rentals
        JPanel weeklyPane = new JPanel(new BorderLayout());
        weeklyPane.setBackground(BACKGROUND);
        add(weeklyPane, BorderLayout.NORTH);

        JLabel weeklyTopRentalLabel = Screen.createTitle("Top Movies of the Week");
        weeklyPane.add(weeklyTopRentalLabel, BorderLayout.NORTH);

        JPanel weeklyTopRentalsPane = new JPanel(new StackLayout());
        weeklyTopRentalsPane.setBackground(BACKGROUND);
        ArrayList<Movie> weeklyTopRentals = fc.getWeeklyTopRentals(5);
        for (Movie movie: weeklyTopRentals) {
            JButton movieButton = new JButton(movie.getTitle());
            movieButton.setPreferredSize(BUTTON_SIZE);
            movieButton.addActionListener(e -> window.openMovieScreen(movie));
            weeklyTopRentalsPane.add(movieButton);
        }
        weeklyPane.add(weeklyTopRentalsPane, BorderLayout.CENTER);

        // Monthly Top Rentals
        JPanel nextPane = new JPanel(new BorderLayout());
        add(nextPane, BorderLayout.CENTER);

        JPanel monthlyPane = new JPanel(new BorderLayout());
        monthlyPane.setBackground(BACKGROUND);
        nextPane.add(monthlyPane, BorderLayout.NORTH);

        JLabel monthlyTopRentalLabel = Screen.createTitle("Top Movies of the Month");
        monthlyPane.add(monthlyTopRentalLabel, BorderLayout.NORTH);

        JPanel monthlyTopRentalsPane = new JPanel(new StackLayout());
        monthlyTopRentalsPane.setBackground(BACKGROUND);
        ArrayList<Movie> monthlyTopRentals = fc.getMonthlyTopRentals(5);
        for (Movie movie: monthlyTopRentals) {
            JButton movieButton = new JButton(movie.getTitle());
            movieButton.setPreferredSize(BUTTON_SIZE);
            movieButton.addActionListener(e -> window.openMovieScreen(movie));
            monthlyTopRentalsPane.add(movieButton);
        }
        monthlyPane.add(monthlyTopRentalsPane, BorderLayout.CENTER);

        // Available Movies
        JPanel availablePane = new JPanel(new BorderLayout());
        availablePane.setBackground(BACKGROUND);
        nextPane.add(availablePane, BorderLayout.CENTER);

        JLabel availableLabel = Screen.createTitle("Available Movies");
        availablePane.add(availableLabel, BorderLayout.NORTH);

        JPanel availableMoviesPane = new JPanel(new StackLayout());
        availableMoviesPane.setBackground(BACKGROUND);
        ArrayList<Movie> availableMovies = fc.getAvailableMovies();
        for (Movie movie: availableMovies) {
            JButton movieButton = new JButton(movie.getTitle());
            movieButton.setPreferredSize(BUTTON_SIZE);
            movieButton.addActionListener(e -> window.openMovieScreen(movie));
            availableMoviesPane.add(movieButton);
        }
        availablePane.add(availableMoviesPane, BorderLayout.CENTER);
    }
}
