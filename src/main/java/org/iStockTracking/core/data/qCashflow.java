package org.iStockTracking.core.data;

import org.iStockTracking.core.forms.splashScreenMain;
import org.iStockTracking.core.globals;
import org.iStockTracking.core.utils.yql.dataQuery;
import org.iStockTracking.core.utils.yql.types.cashflowType;

import java.util.List;

/**
 * Created by Matt on 8/20/2015.
 */
public class qCashflow {
    public static void build(queryBase.Market market)
            throws Exception
    {
        switch (market) {
            case AMEX:{
                for (int i = 0; i < qQueryStrings.AMEXQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.cashflow where symbol in " + qQueryStrings.AMEXQueryStr.get(i);

                    List<cashflowType> t  = dataQuery.cashflowToObject(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.AMEX.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.AMEX.getCompanyList().get(k).getSymbol())){
                                globals.AMEX.getCompanyList().get(k).setTimeframe(t.get(j).getTimeframe());
                            }
                        }
                    }
                }
                break;
            }

            case NYSE:{
                for (int i = 0; i < qQueryStrings.NYSEQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.cashflow where symbol in " + qQueryStrings.NYSEQueryStr.get(i);

                    List<cashflowType> t  = dataQuery.cashflowToObject(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.NYSE.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.NYSE.getCompanyList().get(k).getSymbol())){
                                globals.NYSE.getCompanyList().get(k).setTimeframe(t.get(j).getTimeframe());
                            }
                        }
                    }
                }
                break;
            }

            case NASDAQ:{
                for (int i = 0; i < qQueryStrings.NASDAQQueryStr.size(); i++){
                    String queryStr = "select * from yahoo.finance.cashflow where symbol in " + qQueryStrings.NASDAQQueryStr.get(i);

                    List<cashflowType> t  = dataQuery.cashflowToObject(queryStr);
                    for (int j = 0; j < t.size(); j++){
                        for (int k=0; k < globals.NASDAQ.getCompanyList().size(); k++){
                            if (t.get(j).getSymbol().equals(globals.NASDAQ.getCompanyList().get(k).getSymbol())){
                                globals.NASDAQ.getCompanyList().get(k).setTimeframe(t.get(j).getTimeframe());
                            }
                        }
                    }
                }
                break;
            }



        }
        splashScreenMain.progressTick = splashScreenMain.at.getAndAdd(5);
    }
}
