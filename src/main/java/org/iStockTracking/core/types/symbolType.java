package org.iStockTracking.core.types;

import org.iStockTracking.core.utils.yql.types.dividendHistoryType;
import org.iStockTracking.core.utils.yql.types.historicalDataType;

import java.util.ArrayList;
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
     * Data updated on a daily or more frequent basis
     */
    // yahoo.finance.quant
    private long totalAssets;
    private long stockHolders;

    //yahoo.finance.quote
    private long averageDailyVolume;
    private String change;
    private double daysLow;
    private double daysHigh;
    private double yearLow;
    private double yearHigh;
    private String marketCapitalization;
    private double lastTradePriceOnly;
    private String daysRange;
    private long volume;
    private String stockExchange;

    /**
     * Default Constructor
     */
    public symbolType(String symbol, String companyName, String sector, String industry){
        this.symbol = symbol;
        this.companyName = companyName;
        this.sector = sector;
        this.industry = industry;

        this.cashflowHistory = new ArrayList<dividendHistoryType>();
        this.indexHistory = new ArrayList<historicalDataType>();
    }

    /**
     * Get and Set Methods
     */
    public long getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(long averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public List<dividendHistoryType> getCashflowHistory() {
        return cashflowHistory;
    }

    public void setCashflowHistory(List<dividendHistoryType> cashflowHistory) {
        this.cashflowHistory = cashflowHistory;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(double daysHigh) {
        this.daysHigh = daysHigh;
    }

    public double getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(double daysLow) {
        this.daysLow = daysLow;
    }

    public String getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(String daysRange) {
        this.daysRange = daysRange;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<historicalDataType> getIndexHistory() {
        return indexHistory;
    }

    public void setIndexHistory(List<historicalDataType> indexHistory) {
        this.indexHistory = indexHistory;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public double getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public void setLastTradePriceOnly(double lastTradePriceOnly) {
        this.lastTradePriceOnly = lastTradePriceOnly;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public long getStockHolders() {
        return stockHolders;
    }

    public void setStockHolders(long stockHolders) {
        this.stockHolders = stockHolders;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    public long getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(long totalAssets) {
        this.totalAssets = totalAssets;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }
}
