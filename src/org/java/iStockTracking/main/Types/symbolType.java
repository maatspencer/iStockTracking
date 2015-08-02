package org.java.iStockTracking.main.Types;

import org.java.iStockTracking.yql.types.dividendHistoryType;
import org.java.iStockTracking.yql.types.historicalDataType;

import java.util.Date;
import java.util.List;

/**
 * Created by Matt on 8/2/2015.
 */
public class symbolType {
    /**
     * Constants obtained during installation
     */
    // From nasdaq csv files
    private String symbol;
    private String companyName;
    private String sector;
    private String industry;

    // yahoo.finance.cashflow
    private String timeframe;

    // yahoo.finance.stocks
    private Date startDate;
    private Date endDate;  //Will need to be updated to today each use

    /**
     * Historical data where only the previous day will have to be added
     */

    // yahoo.finance.dividendhistory
    private List<dividendHistoryType> cashflowHistory;

    // yahoo.finance.historicaldata
    private List<historicalDataType> indexHistory;

    /**
     * Data updated on a daily basis
     */
    // yahoo.finance.quant



}
