package org.java.iStockTracking.yql;
        import org.yql4j.*;
        import org.java.iStockTracking.yql.types.*;
        import org.yql4j.types.QueryResultType;

        import com.fasterxml.jackson.core.type.TypeReference;

        import java.util.ArrayList;
        import java.util.List;

/**
 * This class defines all of the YQL queries that are made by the application.
 * @author Matt Spencer <maatspencer@gmail.com></maatspencer@gmail.com>
 * @since 2015/07/18
 * @version 0.1.0
 */
public class dataQuery {

    private static YqlClient client;

    /**
     * Initializes the YQL Client
     */
    public static void setUp() {
        client = YqlClients.createDefault();
    }

    /**
     * Closes the YQL Client
     * @throws Exception
     */
    public static void tearDown() throws Exception {
        client.close();
    }

    /**
     * Simple YQL query
     * @param strQuery example: "select * from geo.oceans"
     * @return raw query results
     * @throws Exception
     */
    public static String queryToString(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * Simple YQL query utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withVariable definition for @name in the query
     * @return raw query results
     * @throws Exception
     */
    public static String queryToString(String strQuery, String withVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withVariable);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * YQL query (XML Format)
     * @param strQuery example: "select * from geo.oceans"
     * @return raw XML results
     * @throws Exception
     */
    public static String queryToXML(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.XML);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * YQL query (XML Format) utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withNameVariable definition for @name in the query
     * @return raw XML results
     * @throws Exception
     */
    public static String queryToXML(String strQuery, String withNameVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withNameVariable);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.XML);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * YQL query (JSON Format)
     * @param strQuery example: "select * from geo.oceans"
     * @return raw JSON results
     * @throws Exception
     */
    public static String queryToJSON(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.JSON);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * YQL query (JSON Format) utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withNameVariable definition for @name in the query
     * @return raw JSON results
     * @throws Exception
     */
    public static String queryToJSON(String strQuery, String withNameVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withNameVariable);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.JSON);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static List<StockType> StockMappingJson(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<StockArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<StockArrayType>>() {});

        List<StockType> stockArr = new ArrayList<>();
        for (StockType item : mappedResult.getResults().getStock()){
            stockArr.add(item);
        }

        return stockArr;
    }
}