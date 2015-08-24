package org.iStockTracking.core.data;

import org.iStockTracking.core.utils.yql.dataQuery;

/**
 * Created by Matt on 8/17/2015.
 */
public class queryBase {
    public enum Market{
        AMEX, NYSE, NASDAQ
    }

    public static void init() throws Exception {
        // Setup YQL client
        dataQuery.setUp();
        // build Symbol Strings for queries
    }
    public static void end() throws Exception {
        // Xlose YQL client
        dataQuery.tearDown();
    }
}
