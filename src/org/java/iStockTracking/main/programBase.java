package org.java.iStockTracking.main;

import org.java.iStockTracking.yql.dataQuery;
import org.java.iStockTracking.yql.types.dividendHistoryType;
import org.java.iStockTracking.yql.types.stocksType;
import org.java.iStockTracking.yql.types.cashflowType;
import org.java.iStockTracking.yql.types.historicalDataType;

import java.util.List;


/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {
        dataQuery.setUp();
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
    }
}