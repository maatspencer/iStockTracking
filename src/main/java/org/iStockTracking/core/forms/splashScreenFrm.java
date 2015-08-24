package org.iStockTracking.core.forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Matt on 8/23/2015.
 */
public class splashScreenFrm
        extends JFrame{
    private JPanel rootPanel;

    public splashScreenFrm()
        throws IOException
    {
        // Remove Border and title bar
        setUndecorated(true);

        // Standard for all forms
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set size and center window
        setSize(640,350);
        setLocationRelativeTo(null);

        // Add backround image
        BufferedImage myPicture = ImageIO.read(getClass().getResource("/splashScreen.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);

        setVisible(true);
    }
}
