package org.iStockTracking.core;

import org.iStockTracking.core.types.stockExchangeType;
import org.iStockTracking.core.types.symbolType;
import org.iStockTracking.core.utils.IO.OS;
import org.iStockTracking.core.data.qSymbolList;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Matt on 8/16/2015.
 */
public class initialize {
    public static void start()
        throws IOException
    {
        // Determine Operating System Properties
        OS.properties();

        // Initialize Markets Objects
        createMarketObjects();

        //HTTP GET Request for the stock symbol csv files
        qSymbolList.getHTTP();

        //Parse csv file to objects
        qSymbolList.map();

        //Sort the companyLists
        qSymbolList.sort();

    }

    /**
     * Create Market Objects: globals.AMEX, globals.NYSE, and Globals.NASDAQ
     */
    private static void createMarketObjects()
            throws IOException
    {
        // Initialize Markets Objects
        globals.AMEX = new stockExchangeType();
        globals.AMEX.setName("AMEX");
        globals.AMEX.setCountry("USA");
        globals.AMEX.setCompanyList(new ArrayList<symbolType>());

        globals.NASDAQ = new stockExchangeType();
        globals.NASDAQ.setName("NASDAQ");
        globals.NASDAQ.setCountry("USA");
        globals.NASDAQ.setCompanyList(new ArrayList<symbolType>());

        globals.NYSE = new stockExchangeType();
        globals.NYSE.setName("NYSE");
        globals.NYSE.setCountry("USA");
        globals.NYSE.setCompanyList(new ArrayList<symbolType>());
    }

    private static void printMarketObjects(int market){
        switch (market) {
            case 1: {
                //AMEX
                for (int i = 0; i < globals.AMEX.getCompanyList().size(); i++) {
                    System.out.println(globals.AMEX.getCompanyList().get(i).getCompanyName());
                    System.out.println(globals.AMEX.getCompanyList().get(i).getSymbol());
                    System.out.println(globals.AMEX.getCompanyList().get(i).getIndustry());
                    System.out.println(globals.AMEX.getCompanyList().get(i).getSector());
                    System.out.println();
                }
                break;
            }
            case 2: {
                //NYSE
                 for (int i = 0; i < globals.NYSE.getCompanyList().size(); i++){
                    System.out.println(globals.NYSE.getCompanyList().get(i).getCompanyName());
                    System.out.println(globals.NYSE.getCompanyList().get(i).getSymbol());
                    System.out.println(globals.NYSE.getCompanyList().get(i).getIndustry());
                    System.out.println(globals.NYSE.getCompanyList().get(i).getSector());
                    System.out.println();
                 }
                break;
            }
            case 3: {
                //NASDAQ
                for (int i = 0; i < globals.NASDAQ.getCompanyList().size(); i++) {
                    System.out.println(globals.NASDAQ.getCompanyList().get(i).getCompanyName());
                    System.out.println(globals.NASDAQ.getCompanyList().get(i).getSymbol());
                    System.out.println(globals.NASDAQ.getCompanyList().get(i).getIndustry());
                    System.out.println(globals.NASDAQ.getCompanyList().get(i).getSector());
                    System.out.println();
                }
                break;
            }
        }

    }

}
