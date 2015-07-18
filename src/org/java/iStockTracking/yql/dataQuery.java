package org.java.iStockTracking.yql;
        import org.yql4j.*;
        import org.java.iStockTracking.yql.types.*;
        import org.yql4j.types.QueryResultType;

        import com.fasterxml.jackson.core.type.TypeReference;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Tests for the {@link YqlClient}.
 */
public class dataQuery {

    private static YqlClient client;

    public static void setUp() {
        client = YqlClients.createDefault();
    }

    public static void tearDown() throws Exception {
        client.close();
    }

    public static String queryToString(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static String queryToString(String strQuery, String withVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withVariable);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static String queryToXML(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(true);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static String queryToXML(String strQuery, String withNameVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withNameVariable);
        query.setDiagnostics(true);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static String queryToJSON(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.JSON);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static String queryToJSON(String strQuery, String withNameVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withNameVariable);
        query.setDiagnostics(true);
        query.setFormat(ResultFormat.JSON);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    public static List<StockType> StockMappingXml(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(true);
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

    public void testUseTable() throws Exception {
        String tableFile = "https://raw.githubusercontent.com/philippn/"
                + "yql-tables/master/yahoo.finance.components.xml";
        YqlQuery query = new YqlQuery("select * from mytable where symbol='^GDAXI'");
        query.setDiagnostics(true);
        query.addTableFile(tableFile, "mytable");
        YqlResult result = client.query(query);
        QueryResultType<String[]> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<String[]>>() {});
    }
}