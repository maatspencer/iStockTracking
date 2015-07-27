package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * This class represents the <code>cashflow</code> type used in the
 * <code>yahoo.finance.cashflow</code> table.
 * @see cashflowArrayType
 */

public class cashflowType {

	private String symbol;
	private String timeframe;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the cash flow period
	 */
	public String getTimeframe() {
		return timeframe;
	}

	/**
	 * @param timeframe the companyName to set
	 */
	@JsonProperty("timeframe")
	public void setTimeframe(String timeframe) {
		this.timeframe = timeframe;
	}
}
