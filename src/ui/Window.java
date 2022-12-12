package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Window extends JFrame {
    private final static String DEFAULT_SCREEN = "Default Screen";
    private final static String LOGIN_SCREEN = "Login Screen";
    private final TopBar topBar;
    private final JPanel mainPane;
    private final CardLayout cardLayout;
    private DefaultScreen defaultScreen;
    private LoginScreen loginScreen;
    private String currentScreen;

    Window() {
        setTitle("CyberVideo AL2000");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        setMinimumSize(new Dimension(800, 500));

        topBar = new TopBar(this);
        add(topBar, BorderLayout.NORTH);

        AdBanner banner1 = new AdBanner(new File("resources/empty_ad.png"));
        add(banner1, BorderLayout.WEST);

        AdBanner banner2 = new AdBanner(new File("resources/empty_ad.png"));
        add(banner2, BorderLayout.EAST);

        cardLayout = new CardLayout();
        mainPane = new JPanel(cardLayout);
        add(mainPane, BorderLayout.CENTER);

        openDefaultScreen();
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
            loginScreen = new LoginScreen(this);
            mainPane.add(loginScreen, LOGIN_SCREEN);
        }
        cardLayout.show(mainPane, LOGIN_SCREEN);
        topBar.showPrevious();
        topBar.showMenus();
        loginScreen.clear();
        currentScreen = LOGIN_SCREEN;
    }

    void previous() {
        switch (currentScreen) {
            case LOGIN_SCREEN:
                openDefaultScreen();
                break;
            default:
                break;
        }
    }

    public static void launch() {
        SwingUtilities.invokeLater(() -> new Window().setVisible(true));
    }
}
