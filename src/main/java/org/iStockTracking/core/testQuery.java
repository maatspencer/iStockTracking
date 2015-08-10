package org.iStockTracking.core;

import org.iStockTracking.core.utils.yql.dataQuery;
import org.iStockTracking.core.utils.yql.types.*;

import java.util.List;


/**
 * Created by Matt on 8/8/2015.
 */
public class testQuery {

        public static void run() throws Exception {
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
            dataQuery.tearDown();
        }
}
