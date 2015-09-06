package org.iStockTracking.core;

import org.iStockTracking.core.data.*;
import org.iStockTracking.core.forms.splashScreenMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {

        // add the splash screen on a new thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    splashScreenMain.add();
                } catch (IOException ex) {
                    Thread t = Thread.currentThread();
                    t.getUncaughtExceptionHandler().uncaughtException(t, ex);
                }
            }
        });
        t1.start();

        // Initialize Database and Settings
        initialize.start();

        /**
         * Begin YQL Data Queries to fill Stock Objects
         */
        // Create YQL Client
        queryBase.init();

        // Create List of Markets
        List<queryBase.Market> markets = new ArrayList<>();
        markets.add(queryBase.Market.AMEX);
        markets.add(queryBase.Market.NASDAQ);
        markets.add(queryBase.Market.NYSE);

        /**
        * Build Strings for Query Builder i.e. ("AAMC","AAU"....,"MGH")
        * The Symbols for each market are done in arraylists because you are limited by Yahoo to 235 Symbols per queryBase.
         * The partial strings can be appended with the rest of the SQL statement
         */
        qQueryStrings.build(queryBase.Market.AMEX);
        qQueryStrings.build(queryBase.Market.NASDAQ);
        qQueryStrings.build(queryBase.Market.NYSE);

        /**
         * Add timeframe constant from cashflowobject to each symbol
         */
        for (int i = 0; i< markets.size(); i++){
            queryBase.Market m = markets.get(i);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        qCashflow.build(m);
                    } catch (Exception ex) {
                        Thread t = Thread.currentThread();
                        t.getUncaughtExceptionHandler().uncaughtException(t, ex);
                    }
                }
            });
            t.start();
        }

        /**
         * Add the start and end date constants from stocksobject to each symbol
         */
        for (int i = 0; i< markets.size(); i++){
            queryBase.Market m = markets.get(i);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        qStocks.build(m);
                    } catch (Exception ex) {
                        Thread t = Thread.currentThread();
                        t.getUncaughtExceptionHandler().uncaughtException(t, ex);
                    }
                }
            });
            t.start();
        }

        // Close YQL Client
        queryBase.end();

    }
}