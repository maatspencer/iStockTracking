package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * This class represents the <code>quote</code> type used in the
 * <code>yahoo.finance.historicaldata</code> table.
 * @see historicalDataArrayType
 */
public class historicalDataType {

	private String symbol;
	private Date date;
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	private double adjClose;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	@JsonProperty("Symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the date of the quote
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date of the quote
	 */
	@JsonProperty("Date")
	public void setDate(Date date) {this.date = date;}

	/**
	 * @return the opening price of the quote
	 */
	public double getOpen() {
		return open;
	}

	/**
	 * @param open the opening price of the quote
	 */
	@JsonProperty("Open")
	public void setOpen(double open) {
		this.open = open;
	}

	/**
	 * @return the high price of the quote
	 */
	public double getHigh() {return high;}

	/**
	 * @param high the high price of the quote
	 */
	@JsonProperty("High")
	public void setHigh(double high) {this.high = high;}

	/**
	 * @return the low price of the quote
	 */
	public double getLow() {
		return low;
	}

	/**
	 * @param low the low price of the quote
	 */
	@JsonProperty("Low")
	public void setLow(double low) { this.low = low;}

	/**
	 * @return the closing price of the quote
	 */
	public double getClose() {
		return close;
	}

	/**
	 * @param close the low price of the quote
	 */
	@JsonProperty("Close")
	public void setClose(double close) { this.close = close;}

	/**
	 * @return the adjusted closing price of the quote
	 */
	public double getAdjClose() {
		return adjClose;
	}

	/**
	 * @param adjClose the low price of the quote
	 */
	@JsonProperty("Adj_Close")
	public void setAdj_Close(double adjClose) { this.adjClose = adjClose;}

	/**
	 * @return the volume of the stock
	 */
	public long getVolume() {
		return volume;
	}

	/**
	 * @param volume the low price of the quote
	 */
	@JsonProperty("Volume")
	public void setVolume(long volume) { this.volume = volume;}

}
