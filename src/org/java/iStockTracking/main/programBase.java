package org.java.iStockTracking.main;

import org.java.iStockTracking.yql.dataQuery;
import org.java.iStockTracking.yql.types.StockType;
import java.util.List;


/**
 * Created by Matt on 7/13/2015.
 */
public class programBase {

    public static void main(String[] args) throws Exception {
        dataQuery.setUp();
        List<StockType> stockTest = dataQuery.StockMappingJson("select * from yahoo.finance.stocks where symbol in (\"YHOO\",\"AAPL\",\"GOOG\",\"MSFT\")");

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


    }
}
