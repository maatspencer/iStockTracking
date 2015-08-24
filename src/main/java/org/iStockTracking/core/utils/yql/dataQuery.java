package org.iStockTracking.core.utils.yql;
        import com.fasterxml.jackson.core.type.TypeReference;
        import org.iStockTracking.core.utils.yql.types.*;
        import org.yql4j.*;
        import org.yql4j.types.QueryResultType;

        import java.util.ArrayList;
        import java.util.List;

/**
 * This class defines all of the YQL queries that are made by the application.
 * @author Matt Spencer <maatspencer@gmail.com></maatspencer@gmail.com>
 * @since 2015/08/8
 * @version 0.1.5
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
     * Simple YQL queryBase
     * @param strQuery example: "select * from geo.oceans"
     * @return raw queryBase results
     * @throws Exception
     */
    public static String queryToString(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * Simple YQL queryBase utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withVariable definition for @name in the queryBase
     * @return raw queryBase results
     * @throws Exception
     */
    public static String queryToString(String strQuery, String withVariable) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.addVariable("name", withVariable);
        YqlResult result = client.query(query);

        return result.getContentAsString();
    }

    /**
     * YQL queryBase (XML Format)
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
     * YQL queryBase (XML Format) utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withNameVariable definition for @name in the queryBase
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
     * YQL queryBase (JSON Format)
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
     * YQL queryBase (JSON Format) utilizing a @name variable
     * @param strQuery ex: "select * from geo.oceans where name=@name"
     * @param withNameVariable definition for @name in the queryBase
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

    public static List<stocksType> stocksToObjectArray(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<stocksArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<stocksArrayType>>() {});

        List<stocksType> stockArr = new ArrayList<stocksType>();
        for (stocksType item : mappedResult.getResults().getStock()){
            stockArr.add(item);
        }

        return stockArr;
    }

    public static List<historicalDataType> historicalDataToObjectArray(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<historicalDataArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<historicalDataArrayType>>() {});

        List<historicalDataType> historicArr = new ArrayList<historicalDataType>();
        for (historicalDataType item : mappedResult.getResults().getQuote()){
            historicArr.add(item);
        }

        return historicArr;
    }

    public static List<cashflowType> cashflowToObject(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<cashflowArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<cashflowArrayType>>() {});

        List<cashflowType> cashflowResult = new ArrayList<>();
        for (cashflowType item : mappedResult.getResults().getCashflow()){
           cashflowResult.add(item);
        }

        return cashflowResult;
    }

    public static List<dividendHistoryType> dividendHistoryToObjectArray(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<dividendHistoryArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<dividendHistoryArrayType>>() {});

        List<dividendHistoryType> dividendHistoryArr = new ArrayList<dividendHistoryType>();
        for (dividendHistoryType item : mappedResult.getResults().getQuote()){
            dividendHistoryArr.add(item);
        }

        return dividendHistoryArr;
    }

    public static List<quantityType> quantityToObjectArray(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<quantityArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<quantityArrayType>>() {});

        List<quantityType> quantityArr = new ArrayList<quantityType>();
        for (quantityType item : mappedResult.getResults().getStock()){
            quantityArr.add(item);
        }

        return quantityArr;
    }

    public static List<quoteType> quoteToObjectArray(String strQuery) throws Exception {
        YqlQuery query = new YqlQuery(strQuery);
        query.setDiagnostics(false);
        query.setFormat(ResultFormat.JSON);
        query.useCommunityOpenDataTables();
        YqlResult result = client.query(query);
        QueryResultType<quoteArrayType> mappedResult =
                result.getContentAsMappedObject(
                        new TypeReference<QueryResultType<quoteArrayType>>() {});

        List<quoteType> quoteArr = new ArrayList<quoteType>();
        for (quoteType item : mappedResult.getResults().getQuote()){
            quoteArr.add(item);
        }

        return quoteArr;
    }
}