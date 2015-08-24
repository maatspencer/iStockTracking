package org.iStockTracking.core.data;

import org.iStockTracking.core.globals;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 8/20/2015.
 */
public class qQueryStrings {

    public static List<String> AMEXQueryStr;
    public static List<String> NASDAQQueryStr;
    public static List<String> NYSEQueryStr;
    
    private static final int max = 250; //Maximum results for each YQL queryBase

    public static void build(queryBase.Market market){
        switch (market) {
            case AMEX: {
                // Initialize Query List
                AMEXQueryStr = new ArrayList<String>();

                // limited to "max: symbols per queryBase
                for(int i=0; i < (int) Math.floor(((double) globals.AMEX.getCompanyList().size() / max)); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of max (last will be MODULO)
                    for (int j= i * max; j < ((i+1)*max) - 1; j++){
                        t += "\"" + globals.AMEX.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.AMEX.getCompanyList().get(((i+1)*max) - 1).getSymbol() + "\")";

                    // add item to the list
                    AMEXQueryStr.add(t);
                }

                // add the last list item MODULO amount of max
                int start = (int) ((Math.floor((double) globals.AMEX.getCompanyList().size()/max)) * max);
                int finish = start + (globals.AMEX.getCompanyList().size() % max);
                String t = "(";

                for(int i = start; i < finish - 1; i++){
                    t += "\"" + globals.AMEX.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.AMEX.getCompanyList().get(finish - 1).getSymbol() + "\")";
                AMEXQueryStr.add(t);

                break;
            }

            case NYSE: {
                // Initialize Query List
                NYSEQueryStr = new ArrayList<String>();

                // limited to max symbols per queryBase
                for(int i=0; i < (int) Math.floor(((double) globals.NYSE.getCompanyList().size() / max)); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of max (last will be MODULO)
                    for (int j= i * max; j < ((i+1)*max) - 1; j++){
                        t += "\"" + globals.NYSE.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.NYSE.getCompanyList().get(((i+1)*max) - 1).getSymbol() + "\")";

                    // add item to the list
                    NYSEQueryStr.add(t);
                }

                // add the last list item MODULO amount of max
                int start = (int) ((Math.floor((double) globals.NYSE.getCompanyList().size()/max)) * max);
                int finish = start + (globals.NYSE.getCompanyList().size() % max);
                String t = "(";

                for(int i = start; i < finish - 1; i++){
                    t += "\"" + globals.NYSE.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.NYSE.getCompanyList().get(finish - 1).getSymbol() + "\")";
                NYSEQueryStr.add(t);

                break;
            }

            case NASDAQ: {
                // Initialize Query List
                NASDAQQueryStr = new ArrayList<String>();

                // limited to max symbols per queryBase
                for(int i=0; i < (int) Math.floor(((double) globals.NASDAQ.getCompanyList().size() / max)); i++){
                    // Create temp string
                    String t = "(";

                    // build a list of symbols for each set of max (last will be MODULO)
                    for (int j= i * max; j < ((i+1)*max) - 1; j++){
                        t += "\"" + globals.NASDAQ.getCompanyList().get(j).getSymbol() + "\",";
                    }
                    t += "\"" + globals.NASDAQ.getCompanyList().get(((i+1)*max) - 1).getSymbol() + "\")";

                    // add item to the list
                    NASDAQQueryStr.add(t);
                }

                // add the last list item MODULO amount of max
                int start = (int) ((Math.floor((double) globals.NASDAQ.getCompanyList().size()/max)) * max);
                int finish = start + (globals.NASDAQ.getCompanyList().size() % max);
                String t = "(";

                for(int i = start; i < finish - 1; i++){
                    t += "\"" + globals.NASDAQ.getCompanyList().get(i).getSymbol() + "\",";
                }
                t += "\"" + globals.NASDAQ.getCompanyList().get(finish - 1).getSymbol() + "\")";
                NASDAQQueryStr.add(t);

                break;
            }
        }
    }
}
