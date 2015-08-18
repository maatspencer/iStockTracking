package org.iStockTracking.core.utils.IO;

import org.iStockTracking.core.globals;

/**
 * Created by Matt on 8/18/2015.
 */
public class OS {
    public static void properties(){
        // Determine operating system name
        getName();
        // Determine if its a windows system
        isWindows();
    }
    private static void getName(){
        globals.operatingSystem = System.getProperty("os.name");
    }
    private static void isWindows(){
        if (globals.operatingSystem.startsWith("Win")){
            globals.isWindows = true;
        }
        else {
            globals.isWindows = false;
        }
    }
}
