package org.iStockTracking.core;

import org.iStockTracking.core.data.qQueryStrings;
import org.iStockTracking.core.data.qStocks;
import org.iStockTracking.core.data.queryBase;
import org.iStockTracking.core.forms.splashScreenFrm;

/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {
        splashScreenFrm loadFrm = new splashScreenFrm();

        // Initialize Database and Settings
        initialize.start();

        /**
         * Begin YQL Data Queries to fill Stock Objects
         */
        // Create YQL Client
        queryBase.init();

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
        //qCashflow.build(queryBase.Market.AMEX);
        //qCashflow.build(queryBase.Market.NASDAQ);
        //qCashflow.build(queryBase.Market.NYSE);

        /**
         * Add the start and end date constants from stocksobject to each symbol
         */
        qStocks.build((queryBase.Market.AMEX));
        qStocks.build((queryBase.Market.NASDAQ));
        qStocks.build((queryBase.Market.NYSE));

        for(int i=0; i < globals.NYSE.getCompanyList().size(); i++){
            System.out.print(globals.NYSE.getCompanyList().get(i).getSymbol() + ", ");
            System.out.print(globals.NYSE.getCompanyList().get(i).getStartDate() + ", ");
            System.out.println(globals.NYSE.getCompanyList().get(i).getEndDate());
        }

        // Close YQL Client
        queryBase.end();

    }
}