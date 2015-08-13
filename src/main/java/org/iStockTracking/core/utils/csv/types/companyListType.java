package org.iStockTracking.core.utils.csv.types;

import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/**
 * Created by Matt on 8/11/2015.
 */
@CsvDataType()
public class companyListType {

    @CsvField(pos = 1)
    String symbol;

    @CsvField(pos = 2)
    String name;

    @CsvField(pos = 3)
    String lastSale;

    @CsvField(pos = 4)
    String marketCap;

    @CsvField(pos = 5)
    String IPOyear;

    @CsvField(pos = 6)
    String sector;

    @CsvField(pos = 7)
    String industry;

    @CsvField(pos = 8)
    String summaryQuote;

}
