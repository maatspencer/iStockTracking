package org.iStockTracking.core.data;

import org.iStockTracking.core.globals;
import org.iStockTracking.core.types.symbolType;
import org.iStockTracking.core.utils.IO.httpDownloadUtility;
import org.iStockTracking.core.utils.csv.deserializeSymbols;
import org.iStockTracking.core.utils.csv.types.companyListType;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Matt on 8/1/2015.
 */
public class qSymbolList {

    private static String AMEX = "http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=amex&render=download";
    private static String NYSE = "http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=nyse&render=download";
    private static String NASDAQ = "http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=nasdaq&render=download";


    public static void getHTTP() throws IOException {
        httpDownloadUtility.downloadFile(AMEX, globals.DATA_DIR + "AMEX.csv");
        httpDownloadUtility.downloadFile(NYSE, globals.DATA_DIR + "NYSE.csv");
        httpDownloadUtility.downloadFile(NASDAQ, globals.DATA_DIR + "NASDAQ.csv");
    }

    public static void map() throws IOException {
        /**
         * Map each csv object to a new symbolType and add it the initialized array list for each market
         */
        //AMEX
        List<companyListType> oAMEX = deserializeSymbols.parse(globals.DATA_DIR + "AMEX.csv");
        for (int i = 0; i < oAMEX.size(); i++) {
            symbolType x = new symbolType(oAMEX.get(i).getSymbol().replace(" ",""),oAMEX.get(i).getName(), oAMEX.get(i).getSector(), oAMEX.get(i).getIndustry());
            globals.AMEX.getCompanyList().add(x);
        }

        //NYSE
        List<companyListType> oNYSE = deserializeSymbols.parse(globals.DATA_DIR + "NYSE.csv");
        for (int i = 0; i < oNYSE.size(); i++) {
            symbolType y = new symbolType(oNYSE.get(i).getSymbol().replace(" ", ""),oNYSE.get(i).getName(), oNYSE.get(i).getSector(), oNYSE.get(i).getIndustry());
            globals.NYSE.getCompanyList().add(y);
        }

        //NASDAQ
        List<companyListType> oNASDAQ = deserializeSymbols.parse(globals.DATA_DIR + "NASDAQ.csv");
        for (int i = 0; i < oNASDAQ.size(); i++) {
            symbolType z = new symbolType(oNASDAQ.get(i).getSymbol().replace(" ", ""),oNASDAQ.get(i).getName(), oNASDAQ.get(i).getSector(), oNASDAQ.get(i).getIndustry());
            globals.NASDAQ.getCompanyList().add(z);
        }
    }

    public static void sort()
    {
        Collections.sort(globals.AMEX.getCompanyList(), Comparator.comparing(symbolType::getSymbol));
        Collections.sort(globals.NASDAQ.getCompanyList(), Comparator.comparing(symbolType::getSymbol));
        Collections.sort(globals.NYSE.getCompanyList(), Comparator.comparing(symbolType::getSymbol));
    }
}
