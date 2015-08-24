package org.iStockTracking.core.data;

import org.iStockTracking.core.globals;
import org.iStockTracking.core.utils.yql.dataQuery;
import org.iStockTracking.core.utils.yql.types.stocksType;

import java.util.List;

/**
 * Created by Matt on 8/20/2015.
 */
public class qStocks {
    public static void build(queryBase.Market market)
            throws Exception
    {
        switch (market) {
            case AMEX:{
                for (int i = 0; i < qQueryStrings.AMEXQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.stocks where symbol in " + qQueryStrings.AMEXQueryStr.get(i);

                    List<stocksType> t = dataQuery.stocksToObjectArray(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.AMEX.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.AMEX.getCompanyList().get(k).getSymbol())){
                                globals.AMEX.getCompanyList().get(k).setStartDate(t.get(j).getStart());
                                globals.AMEX.getCompanyList().get(k).setEndDate(t.get(j).getEnd());
                                break;
                            }
                        }
                    }
                }
                break;
            }

            case NYSE:{
                for (int i = 0; i < qQueryStrings.NYSEQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.stocks where symbol in " + qQueryStrings.NYSEQueryStr.get(i);

                    List<stocksType> t = dataQuery.stocksToObjectArray(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.NYSE.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.NYSE.getCompanyList().get(k).getSymbol())){
                                globals.NYSE.getCompanyList().get(k).setStartDate(t.get(j).getStart());
                                globals.NYSE.getCompanyList().get(k).setEndDate(t.get(j).getEnd());
                                break;
                            }
                        }
                    }
                }
                break;
            }

            case NASDAQ:{
                for (int i = 0; i < qQueryStrings.NASDAQQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.stocks where symbol in " + qQueryStrings.NASDAQQueryStr.get(i);

                    List<stocksType> t = dataQuery.stocksToObjectArray(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.NASDAQ.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.NASDAQ.getCompanyList().get(k).getSymbol())){
                                globals.NASDAQ.getCompanyList().get(k).setStartDate(t.get(j).getStart());
                                globals.NASDAQ.getCompanyList().get(k).setEndDate(t.get(j).getEnd());
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
    }
}
