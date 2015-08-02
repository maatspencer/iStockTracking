package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the <code>quant</code> type used in the
 * <code>yahoo.finance.quant</code> table.
 * @see quantityArrayType
 */
public class quantityType {

	private String symbol;
	private long stockHolders;
	private long totalAssets;


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
	 * @return the number of stock holders
	 */
	public long getStockHolders() {
		return stockHolders;
	}

	/**
	 * @param stockHolders the number of stock holders to set
	 */
	@JsonProperty("Stockholders")
	public void setStockHolders(long stockHolders) {
		this.stockHolders = stockHolders;
	}

	/**
	 *
	 * @return the companies total assets
	 */
	public long getTotalAssets() {
		return totalAssets;
	}

	/**
	 * @param totalAssets set the companies total assets
	 */
	@JsonProperty("TotalAssets")
	public void setTotalAssets(long totalAssets) {
		this.totalAssets = totalAssets;
	}




}
