package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the <code>quote</code> type used in the
 * <code>yahoo.finance.quote</code> table.
 * @see quantityArrayType
 */
public class quoteType {

	private String symbol;
	private long averageDailyVolume;
	private String change;
	private double daysLow;
	private double daysHigh;
	private double yearLow;
	private double yearHigh;
	private String marketCapitalization;
	private double lastTradePriceOnly;
	private String daysRange;
	private String name;
	private String Symbol2;
	private long volume;
	private String stockExchange;

	/**
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 */
	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return averageDailyVolume
	 */
	public long getAverageDailyVolume() {
		return averageDailyVolume;
	}

	/**
	 * @param averageDailyVolume
	 */
	@JsonProperty("AverageDailyVolume")
	public void setAverageDailyVolume(long averageDailyVolume) {
		this.averageDailyVolume = averageDailyVolume;
	}

	/**
	 * @return change
	 */
	public String getChange() {
		return change;
	}

	/**
	 * @param change
	 */
	@JsonProperty("Change")
	public void setChange(String change) {
		this.change = change;
	}

	/**
	 * @return daysLow
	 */
	public double getDaysLow() {
		return daysLow;
	}

	/**
	 * @param daysLow
	 */
	@JsonProperty("DaysLow")
	public void setDaysLow(double daysLow) {
		this.daysLow = daysLow;
	}

	/**
	 * @return daysHigh
	 */
	public double getDaysHigh() {
		return daysHigh;
	}

	/**
	 * @param daysHigh
	 */
	@JsonProperty("DaysHigh")
	public void setDaysHigh(double daysHigh) {
		this.daysHigh = daysHigh;
	}

	/**
	 * @return yearLow
	 */
	public double getYearLow() {
		return yearLow;
	}

	/**
	 * @param yearLow
	 */
	@JsonProperty("YearLow")
	public void setYearLow(double yearLow) {
		this.yearLow = yearLow;
	}

	/**
	 * @return yearHigh
	 */
	public double getYearHigh() {
		return yearHigh;
	}

	/**
	 * @param yearHigh
	 */
	@JsonProperty("YearHigh")
	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}

	/**
	 * @return marketCapitalization
	 */
	public String getMarketCapitalization() {
		return marketCapitalization;
	}

	/**
	 * @param marketCapitalization
	 */
	@JsonProperty("MarketCapitalization")
	public void setMarketCapitalization(String marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}

	/**
	 * @return lastTradePriceOnly
	 */
	public double getLastTradePriceOnly() {
		return lastTradePriceOnly;
	}

	/**
	 * @param lastTradePriceOnly
	 */
	@JsonProperty("LastTradePriceOnly")
	public void setLastTradePriceOnly(double lastTradePriceOnly) {
		this.lastTradePriceOnly = lastTradePriceOnly;
	}

	/**
	 * @return daysRange
	 */
	public String getDaysRange() {
		return daysRange;
	}

	/**
	 * @param daysRange
	 */
	@JsonProperty("DaysRange")
	public void setDaysRange(String daysRange) {
		this.daysRange = daysRange;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Symbol2
	 */
	public String getSymbol2() {
		return Symbol2;
	}

	/**
	 * @param symbol2
	 */
	@JsonProperty("Symbol")
	public void setSymbol2(String symbol2) {
		Symbol2 = symbol2;
	}

	/**
	 * @return volume
	 */
	public long getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 */
	@JsonProperty("Volume")
	public void setVolume(long volume) {
		this.volume = volume;
	}

	/**
	 * @return stockExchange
	 */
	public String getStockExchange() {
		return stockExchange;
	}

	/**
	 * @param stockExchange
	 */
	@JsonProperty("StockExchange")
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

}


