package org.iStockTracking.core.forms;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Matt on 9/6/2015.
 */

public class splashScreenMain {
    SplashScreen screen;

    public static AtomicInteger at = new AtomicInteger(0);
    public static int progressTick;

    public splashScreenMain()
        throws IOException
    {
        // initialize the splash screen
        splashScreenInit();
        // do something here to simulate the program doing something that
        // is time consuming
        do {
            // run either of these two -- not both
            screen.setProgress("Loading... " + progressTick, progressTick);  // progress bar with a message

        } while (progressTick < 100);

        splashScreenDestruct();
    }

    private void splashScreenDestruct() {
        screen.setScreenVisible(false);
    }

    private void splashScreenInit()
        throws IOException
    {
        // Add backround image
        //BufferedImage myPicture = ImageIO.read(getClass().getResource("/SplashScreen.png"));
        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\Matt\\Documents\\Java Projects\\iStockTracking\\resources\\SplashScreen.png"));
        ImageIcon myImage = new ImageIcon(myPicture);
        screen = new SplashScreen(myImage);
        screen.setLocationRelativeTo(null);
        screen.setSize(640, 375);
        screen.setProgressMax(100);
        screen.setScreenVisible(true);
    }

    public static void add()
        throws IOException
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new splashScreenMain();
    }
}
