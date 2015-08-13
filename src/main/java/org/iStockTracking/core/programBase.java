package org.iStockTracking.core;

import org.iStockTracking.core.utils.csv.symbolList;

/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {
        //Get list of symbols for markets
        symbolList.getHTTP();
        symbolList.map();
    }
}