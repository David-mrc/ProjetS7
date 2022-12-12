package ui;

import fc.Movie;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;

public class MovieScreen extends Screen {
    JPanel pane;
    JLabel title;

    MovieScreen(Window window, FCInterface fc) {
        super(new GridBagLayout());
        pane = new JPanel(new BorderLayout());
        add(pane);
    }

    void setMovie(Movie movie) {
        title = createTitle(movie.getTitle());
        pane.add(title, BorderLayout.NORTH);
    }

    @Override
    void clear() {
        pane.removeAll();
    }
}
