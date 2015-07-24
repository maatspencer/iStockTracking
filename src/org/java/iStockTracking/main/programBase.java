package org.java.iStockTracking.main;

import org.java.iStockTracking.yql.dataQuery;
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
        List<stocksType> stockTest = dataQuery.stockToObjectArray("select * from yahoo.finance.stocks where symbol in (\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");

        int count = stockTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + stockTest.get(i).getSymbol());
            System.out.println("Name: " + stockTest.get(i).getCompanyName());
            System.out.println("Industry: " + stockTest.get(i).getIndustry());
            System.out.println("Sector: " + stockTest.get(i).getSector());
            System.out.println("Full Time Employees: " + stockTest.get(i).getFullTimeEmployees());
            System.out.println("Start: " + stockTest.get(i).getStart());
            System.out.println("End: " + stockTest.get(i).getEnd());
            System.out.println();
        }

        // Test of the quote type
        List<historicalDataType> quoteTest = dataQuery.historicalDataToObjectArray("select * from yahoo.finance.historicaldata where symbol = \"YHOO\" and startDate = \"2009-09-11\" and endDate = \"2010-03-10\"");

        count = quoteTest.size();

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++){
            System.out.println("Symbol: " + quoteTest.get(i).getSymbol());
            System.out.println("    Date: " + quoteTest.get(i).getDate());
            System.out.println("    Open: " + quoteTest.get(i).getOpen());
            System.out.println("    High: " + quoteTest.get(i).getHigh());
            System.out.println("    Low: " + quoteTest.get(i).getLow());
            System.out.println("    Close: " + quoteTest.get(i).getClose());
            System.out.println("    Volume: " + quoteTest.get(i).getVolume());
            System.out.println("    Adjusted Close: " + quoteTest.get(i).getAdjClose());
            System.out.println();
        }

        // Test of the cashflow type
        cashflowType cashflowTest = dataQuery.cashflowToObject("SELECT * FROM yahoo.finance.cashflow WHERE symbol='AAPL'");

        System.out.println("Symbol: " + cashflowTest.getSymbol());
        System.out.println("Timeframe: " + cashflowTest.getTimeframe());
        System.out.println();
    }
}