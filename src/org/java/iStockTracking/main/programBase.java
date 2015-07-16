package org.java.iStockTracking.main;


import org.yql4j.YqlClient;
import org.yql4j.YqlClients;
import org.yql4j.YqlQuery;
import org.yql4j.YqlResult;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    private static YqlClient client;

    public static void main(String[] args) throws Exception {
        client = YqlClients.createDefault();
        testSimpleQuery();


    }
    public static void testSimpleQuery() throws Exception {
        YqlQuery query = new YqlQuery("select * from geo.oceans");
        YqlResult result = client.query(query);
        assertTrue(result.getContentAsString().contains("Arctic Ocean"));
        System.out.print(result.getContentAsString());
    }
}
