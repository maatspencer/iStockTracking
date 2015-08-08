package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the <code>quant</code> type used in the
 * <code>yahoo.finance.quant</code> table.
 * @see quantityArrayType
 */
public class quantityType {

	private String symbol;
	private String stockHolders;
	private String totalAssets;

	// Unused fields in Query
	private String ReturnOnEquity;
	private String TrailingPE;
	private String Analysts;
	private String EarningsGrowth;
	private String EbitMarge;
	private String LastYear;
	private String SixMonths;
	private String Today;
	private String LastMonth;
	private String TwoMonthsAgo;
	private String ThreeMonthsAgo;
	private	String FourMonthsAgo;
	private String CompanyName;

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
	public String getStockHolders() {
		return stockHolders;
	}

	/**
	 * @param stockHolders the number of stock holders to set
	 */
	@JsonProperty("Stockholders")
	public void setStockHolders(String stockHolders) {
		this.stockHolders = stockHolders;
	}

	/**
	 *
	 * @return the companies total assets
	 */
	public String getTotalAssets() {
		return totalAssets;
	}

	/**
	 * @param totalAssets set the companies total assets
	 */
	@JsonProperty("TotalAssets")
	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	/**
	 * Unused fields
	 */
	public String getReturnOnEquity() {
		return ReturnOnEquity;
	}

	@JsonProperty("ReturnOnEquity")
	public void setReturnOnEquity(String returnOnEquity) {
		ReturnOnEquity = returnOnEquity;
	}

	public String getTrailingPE() {
		return TrailingPE;
	}

	@JsonProperty("TrailingPE")
	public void setTrailingPE(String trailingPE) {
		TrailingPE = trailingPE;
	}

	public String getAnalysts() {
		return Analysts;
	}

	@JsonProperty("Analysts")
	public void setAnalysts(String analysts) {
		Analysts = analysts;
	}

	public String getEarningsGrowth() {
		return EarningsGrowth;
	}

	@JsonProperty("EarningsGrowth")
	public void setEarningsGrowth(String earningsGrowth) {
		EarningsGrowth = earningsGrowth;
	}

	public String getEbitMarge() {
		return EbitMarge;
	}

	@JsonProperty("EbitMarge")
	public void setEbitMarge(String ebitMarge) {
		EbitMarge = ebitMarge;
	}

	public String getLastYear() {
		return LastYear;
	}

	@JsonProperty("LastYear")
	public void setLastYear(String lastYear) {
		LastYear = lastYear;
	}

	public String getSixMonths() {
		return SixMonths;
	}

	@JsonProperty("SixMonths")
	public void setSixMonths(String sixMonths) {
		SixMonths = sixMonths;
	}

	public String getToday() {
		return Today;
	}

	@JsonProperty("Today")
	public void setToday(String today) {
		Today = today;
	}

	public String getLastMonth() {
		return LastMonth;
	}

	@JsonProperty("LastMonth")
	public void setLastMonth(String lastMonth) {
		LastMonth = lastMonth;
	}

	public String getTwoMonthsAgo() {
		return TwoMonthsAgo;
	}

	@JsonProperty("TwoMonthsAgo")
	public void setTwoMonthsAgo(String twoMonthsAgo) {
		TwoMonthsAgo = twoMonthsAgo;
	}

	public String getThreeMonthsAgo() {
		return ThreeMonthsAgo;
	}

	@JsonProperty("ThreeMonthsAgo")
	public void setThreeMonthsAgo(String threeMonthsAgo) {
		ThreeMonthsAgo = threeMonthsAgo;
	}

	public String getFourMonthsAgo() {
		return FourMonthsAgo;
	}

	@JsonProperty("FourMonthsAgo")
	public void setFourMonthsAgo(String fourMonthsAgo) {
		FourMonthsAgo = fourMonthsAgo;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	@JsonProperty("CompanyName")
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
}
