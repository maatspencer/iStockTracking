package org.iStockTracking.core;

/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {
        // Initialize Database and Settings
        initialize.start();

        /**
         * Begin YQL Data Queries to fill Stock Objects
         */
        // Create YQL Client
        query.init();

        /**
        * Build Strings for Query Builder i.e. ("AAMC","AAU"....,"MGH")
        * The Symbols for each market are done in arraylists because you are limited by Yahoo to 235 Symbols per query.
         * The partial strings can be appended with the rest of the SQL statement
         */
        query.buildSymbolStr(query.Market.AMEX);
        query.buildSymbolStr(query.Market.NASDAQ);
        query.buildSymbolStr(query.Market.NYSE);

        /**
         *
         */

        // Close YQL Client
        query.end();

    }
}