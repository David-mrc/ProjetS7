package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AdBanner extends JPanel {

    AdBanner(File f) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(150, 0));
        setBackground(new Color(20, 20, 20));

        try {
            BufferedImage image = ImageIO.read(f);
            JLabel imageLabel = new JLabel(new ImageIcon(
                    image.getScaledInstance(150, image.getHeight(), Image.SCALE_SMOOTH))
            );
            add(imageLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
