package org.iStockTracking.core.utils.csv;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.iStockTracking.core.utils.IO.fileToString;
import org.iStockTracking.core.utils.csv.types.companyListType;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Matt on 8/13/2015.
 */
public class deserializeSymbols {
    private static String fullPath;

    private static CSVReader createReader()
            throws IOException
    {
        StringReader reader = new StringReader(fileToString.readFile(fullPath, Charset.defaultCharset()));
        return new CSVReader(reader);
    }

    public static List<companyListType> parse(String path)
            throws IOException
    {
        fullPath = path;
        HeaderColumnNameMappingStrategy<companyListType> strategy = new HeaderColumnNameMappingStrategy<companyListType>();
        strategy.setType(companyListType.class);
        CsvToBean<companyListType> bean = new CsvToBean<companyListType>();

        List<companyListType> cList = bean.parse(strategy, createReader());
        return cList;
    }

}
