package org.iStockTracking.core.utils.csv.types;

/**
 * Created by Matt on 8/11/2015.
*/
public class companyListType {

    private String Symbol;
    private String Name;
    private String LastSale;
    private String MarketCap;
    private String IPOyear;
    private String Sector;
    private String industry;
    private String SummaryQuote;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIPOyear() {
        return IPOyear;
    }

    public void setIPOyear(String IPOyear) {
        this.IPOyear = IPOyear;
    }

    public String getLastSale() {
        return LastSale;
    }

    public void setLastSale(String lastSale) {
        LastSale = lastSale;
    }

    public String getMarketCap() {
        return MarketCap;
    }

    public void setMarketCap(String marketCap) {
        MarketCap = marketCap;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getSummaryQuote() {
        return SummaryQuote;
    }

    public void setSummaryQuote(String summaryQuote) {
        SummaryQuote = summaryQuote;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }
}
