package org.iStockTracking.core;

import org.iStockTracking.core.utils.yql.dataQuery;
import org.iStockTracking.core.utils.yql.types.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 8/17/2015.
 */
public class query {
    private static List<String> AMEXQueryStr;
    private static List<String> NASDAQQueryStr;
    private static List<String> NYSEQueryStr;

    public enum Market{
        AMEX, NYSE, NASDAQ
    }

    public static void buildCashflow(Market market){
        String queryStr = "select * from yahoo.finance.cashflow where symbol in (";
        switch (market){
                case AMEX:{
                // limited to 235 symbols per query
                for(int j=0; j < Math.ceil(globals.AMEX.getCompanyList().size()/235); j++)
                // Build Query String for first 2

                for (int i = 0; i < globals.AMEX.getCompanyList().size() - 1; i++){
                    queryStr += "\"" + globals.AMEX.getCompanyList().get(i).getSymbol() + "\",";
                }
                queryStr += "\"" + globals.AMEX.getCompanyList().get(globals.AMEX.getCompanyList().size() - 1).getSymbol() + "\")";

            }

        }
    }
    public static void buildSymbolStr(Market market){
        switch (market) {
            case AMEX: {
                System.out.println("COUNT: " + globals.AMEX.getCompanyList().size());
                // Initialize Query List
                AMEXQueryStr = new ArrayList<String>();

                // limited to 235 symbols per query
                for(int i=0; i < (int) Math.floor(globals.AMEX.getCompanyList().size()/235); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of 235 (last will be MODULO)
                    for (int j= i * 235; j < ((i+1)*235) - 1; j++){
                            t += "\"" + globals.AMEX.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.AMEX.getCompanyList().get(((i+1)*235) - 1).getSymbol() + "\")";

                    // add item to the list
                    AMEXQueryStr.add(t);
                    System.out.println(t);
                    System.out.println();
                }

                // add the last list item MODULO amount of 235
                int start = (int) ((Math.floor(globals.AMEX.getCompanyList().size()/235)) * 235);
                int finish = start + globals.AMEX.getCompanyList().size() % 235;
                String t = "(";

                for(int i = start; i < finish; i++){
                    t += "\"" + globals.AMEX.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.AMEX.getCompanyList().get(globals.AMEX.getCompanyList().size()-1).getSymbol() + "\")";
                AMEXQueryStr.add(t);
                System.out.println(t);
                System.out.println();

                break;
            }
            case NYSE: {
                System.out.println("COUNT: " + globals.NYSE.getCompanyList().size());
                // Initialize Query List
                NYSEQueryStr = new ArrayList<String>();

                // limited to 235 symbols per query
                for(int i=0; i < (int) Math.floor(globals.NYSE.getCompanyList().size()/235); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of 235 (last will be MODULO)
                    for (int j= i * 235; j < ((i+1)*235) - 1; j++){
                        t += "\"" + globals.NYSE.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.NYSE.getCompanyList().get(((i+1)*235) - 1).getSymbol() + "\")";

                    // add item to the list
                    NYSEQueryStr.add(t);
                    System.out.println(t);
                    System.out.println();
                }

                // add the last list item MODULO amount of 235
                int start = (int) ((Math.floor(globals.NYSE.getCompanyList().size()/235)) * 235);
                int finish = start + globals.NYSE.getCompanyList().size() % 235;
                String t = "(";

                for(int i = start; i < finish; i++){
                    t += "\"" + globals.NYSE.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.NYSE.getCompanyList().get(globals.NYSE.getCompanyList().size()-1).getSymbol() + "\")";
                NYSEQueryStr.add(t);
                System.out.println(t);
                System.out.println();

                break;
            }
            case NASDAQ: {
                System.out.println("COUNT: " + globals.NASDAQ.getCompanyList().size());
                // Initialize Query List
                NASDAQQueryStr = new ArrayList<String>();

                // limited to 235 symbols per query
                for(int i=0; i < (int) Math.floor(globals.NASDAQ.getCompanyList().size()/235); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of 235 (last will be MODULO)
                    for (int j= i * 235; j < ((i+1)*235) - 1; j++){
                        t += "\"" + globals.NASDAQ.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.NASDAQ.getCompanyList().get(((i+1)*235) - 1).getSymbol() + "\")";

                    // add item to the list
                    NASDAQQueryStr.add(t);
                    System.out.println(t);
                    System.out.println();
                }

                // add the last list item MODULO amount of 235
                int start = (int) ((Math.floor(globals.NASDAQ.getCompanyList().size()/235)) * 235);
                int finish = start + globals.NASDAQ.getCompanyList().size() % 235;
                String t = "(";

                for(int i = start; i < finish; i++){
                    t += "\"" + globals.NASDAQ.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.NASDAQ.getCompanyList().get(globals.NASDAQ.getCompanyList().size()-1).getSymbol() + "\")";
                NASDAQQueryStr.add(t);
                System.out.println(t);
                System.out.println();

                break;
            }
        }
    }

    public static void run() throws Exception {
        List<stocksType> stocksTest = dataQuery.stocksToObjectArray("select * from yahoo.finance.stocks where symbol in (\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");

        int count = stocksTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + stocksTest.get(i).getSymbol());
            System.out.println("Name: " + stocksTest.get(i).getCompanyName());
            System.out.println("Start: " + stocksTest.get(i).getStart());
            System.out.println("End: " + stocksTest.get(i).getEnd());
            System.out.println();
        }

        // Test of the quote type
        List<historicalDataType> historicalDataTest = dataQuery.historicalDataToObjectArray("select * from yahoo.finance.historicaldata where symbol = \"YHOO\" and startDate = \"2009-09-11\" and endDate = \"2010-03-10\"");

        count = historicalDataTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + historicalDataTest.get(i).getSymbol());
            System.out.println("    Date: " + historicalDataTest.get(i).getDate());
            System.out.println("    Open: " + historicalDataTest.get(i).getOpen());
            System.out.println("    High: " + historicalDataTest.get(i).getHigh());
            System.out.println("    Low: " + historicalDataTest.get(i).getLow());
            System.out.println("    Close: " + historicalDataTest.get(i).getClose());
            System.out.println("    Volume: " + historicalDataTest.get(i).getVolume());
            System.out.println("    Adjusted Close: " + historicalDataTest.get(i).getAdjClose());
            System.out.println();
        }

        // Test of the cashflow type
        cashflowType cashflowTest = dataQuery.cashflowToObject("SELECT * FROM yahoo.finance.cashflow WHERE symbol='AAPL'");

        System.out.println("Symbol: " + cashflowTest.getSymbol());
        System.out.println("Timeframe: " + cashflowTest.getTimeframe());
        System.out.println();

        // Test of the dividendhistory type
        List<dividendHistoryType> dividendHistoryTest = dataQuery.dividendHistoryToObjectArray("select * from yahoo.finance.dividendhistory where symbol = \"KO\" and startDate = \"1962-01-01\" and endDate = \"2013-12-31\"");

        count = dividendHistoryTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + dividendHistoryTest.get(i).getSymbol());
            System.out.println("    Date: " + dividendHistoryTest.get(i).getDate());
            System.out.println("    Dividends: " + dividendHistoryTest.get(i).getDividends());
            System.out.println();
        }

        // Test of the quantity type
        List<quantityType> quantityTest = dataQuery.quantityToObjectArray("select * from yahoo.finance.quant where symbol in (\"YHOO\")");

        count = quantityTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + quantityTest.get(i).getSymbol());
            System.out.println("    Stock Holders: " + quantityTest.get(i).getStockHolders());
            System.out.println("    Total Assets: " + quantityTest.get(i).getTotalAssets());
            System.out.println();
        }

        // Test of the quote type
        List<quoteType> quoteTest = dataQuery.quoteToObjectArray("select * from yahoo.finance.quote where symbol in (\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");

        count = quoteTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + quoteTest.get(i).getSymbol());
            System.out.println("    Average Daily Volume: " + quoteTest.get(i).getAverageDailyVolume());
            System.out.println("    Change: " + quoteTest.get(i).getChange());
            System.out.println("    Days Low: " + quoteTest.get(i).getDaysLow());
            System.out.println("    Days High: " + quoteTest.get(i).getDaysHigh());
            System.out.println("    Year Low: " + quoteTest.get(i).getYearLow());
            System.out.println("    Year High: " + quoteTest.get(i).getYearHigh());
            System.out.println("    Market Capitalization: " + quoteTest.get(i).getMarketCapitalization());
            System.out.println("    Last Trade Price: " + quoteTest.get(i).getLastTradePriceOnly());
            System.out.println("    Days Range: " + quoteTest.get(i).getDaysRange());
            System.out.println("    Name: " + quoteTest.get(i).getName());
            System.out.println("    Volume: " + quoteTest.get(i).getVolume());
            System.out.println("    Stock Exchange: " + quoteTest.get(i).getStockExchange());
            System.out.println();
        }
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
