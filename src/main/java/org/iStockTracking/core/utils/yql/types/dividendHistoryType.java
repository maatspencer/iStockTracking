package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * This class represents the <code>dividendhistory</code> type used in the
 * <code>yahoo.finance.dividendhistory</code> table.
 * @see cashflowType
 */

public class dividendHistoryType {

	private String symbol;
	private Date date;
	private double dividends;

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
	 * @return the date for the dividend result
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date of the dividend
	 */
	@JsonProperty("Date")
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the dividends for the current time period
	 * @see cashflowType
	 */
	public double getDividends() {
		return dividends;
	}

	/**
	 * @param dividends the dividends for the current time period
	 * @see cashflowType
	 */
	@JsonProperty("Dividends")
	public void setDividends(double dividends) {
		this.dividends = dividends;
	}
}
