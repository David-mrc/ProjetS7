package ui;

import fc.Movie;
import fc.interfaces.FCInterface;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Window extends JFrame {
    private final FCInterface fc;
    private final TopBar topBar;
    private final JPanel mainPane;
    private final CardLayout cardLayout;
    private JScrollPane scrollPane;
    private Screen defaultScreen, loginScreen, signUpScreen, mainScreen, accountScreen;
    private MovieScreen movieScreen;
    private String currentScreen;
    private final static String DEFAULT_SCREEN = "Default", LOGIN_SCREEN = "Login", SIGNUP_SCREEN = "Sign Up";
    private final static String MAIN_SCREEN = "Main", MOVIE_SCREEN = "Movie", ACCOUNT_SCREEN = "Account";

    Window(FCInterface fc) {
        try {
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        setTitle("CyberVideo AL2000");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        setMinimumSize(new Dimension(800, 500));

        this.fc = fc;

        topBar = new TopBar(this, fc);
        add(topBar, BorderLayout.NORTH);

        AdBanner banner1 = new AdBanner(new File("resources/empty_ad.png"));
        add(banner1, BorderLayout.WEST);

        AdBanner banner2 = new AdBanner(new File("resources/empty_ad.png"));
        add(banner2, BorderLayout.EAST);

        cardLayout = new CardLayout();
        mainPane = new JPanel(cardLayout);
        add(mainPane, BorderLayout.CENTER);

        openDefaultScreen();
        pack();
    }

    void openDefaultScreen() {
        if (defaultScreen == null) {
            defaultScreen = new DefaultScreen(this);
            mainPane.add(defaultScreen, DEFAULT_SCREEN);
        }
        cardLayout.show(mainPane, DEFAULT_SCREEN);
        topBar.hidePrevious();
        topBar.hideMenus();
        currentScreen = DEFAULT_SCREEN;
    }

    void openLoginScreen() {
        if (loginScreen == null) {
            loginScreen = new LoginScreen(this, fc);
            mainPane.add(loginScreen, LOGIN_SCREEN);
        }
        cardLayout.show(mainPane, LOGIN_SCREEN);
        topBar.showPrevious();
        topBar.hideMenus();
        loginScreen.clear();
        currentScreen = LOGIN_SCREEN;
    }

    void openSignUpScreen() {
        if (signUpScreen == null) {
            signUpScreen = new SignUpScreen(this, fc);
            mainPane.add(signUpScreen, SIGNUP_SCREEN);
        }
        cardLayout.show(mainPane, SIGNUP_SCREEN);
        topBar.showPrevious();
        topBar.hideMenus();
        signUpScreen.clear();
        currentScreen = SIGNUP_SCREEN;
    }

    void openMainScreen() {
        if (mainScreen == null || scrollPane == null) {
            mainScreen = new MainScreen(this, fc);
            scrollPane = new JScrollPane(mainScreen,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
            );
            mainPane.add(scrollPane, MAIN_SCREEN);
        }
        cardLayout.show(mainPane, MAIN_SCREEN);
        topBar.hidePrevious();
        topBar.showMenus();
        mainScreen.clear();
        currentScreen = MAIN_SCREEN;
    }

    void openMovieScreen(Movie movie) {
        if (movieScreen == null) {
            movieScreen = new MovieScreen(this, fc);
            mainPane.add(movieScreen, MOVIE_SCREEN);
        }
        cardLayout.show(mainPane, MOVIE_SCREEN);
        topBar.showPrevious();
        topBar.showMenus();
        movieScreen.clear();
        movieScreen.setMovie(movie);
        currentScreen = MOVIE_SCREEN;
    }

    void openAccountScreen() {
        if (accountScreen == null) {
            accountScreen = new AccountScreen(this, fc);
            mainPane.add(accountScreen, ACCOUNT_SCREEN);
        }
        cardLayout.show(mainPane, ACCOUNT_SCREEN);
        topBar.hidePrevious();
        topBar.hideMenus();
        currentScreen = ACCOUNT_SCREEN;
    }

    void previous() {
        switch (currentScreen) {
            case LOGIN_SCREEN:
            case SIGNUP_SCREEN:
                openDefaultScreen();
                break;
            case MOVIE_SCREEN:
            case ACCOUNT_SCREEN:
                openMainScreen();
                break;
            default:
                break;
        }
    }

    public static void launch(FCInterface fc) {
        SwingUtilities.invokeLater(() -> new Window(fc).setVisible(true));
    }
}
