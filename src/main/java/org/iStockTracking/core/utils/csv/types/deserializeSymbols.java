package org.iStockTracking.core.utils.csv.types;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.StringReader;
import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class deserializeSymbols {
    private static String fullPath;

    private static CSVReader createReader() {
        StringReader reader = new StringReader(fullPath);
        return new CSVReader(reader);
    }

    public static void parse(String path) {
        fullPath = path;
        HeaderColumnNameMappingStrategy<companyListType> strategy = new HeaderColumnNameMappingStrategy<companyListType>();
        strategy.setType(companyListType.class);
        CsvToBean<companyListType> bean = new CsvToBean<companyListType>();

        List<companyListType> beanList = bean.parse(strategy, createReader());
    }
}
