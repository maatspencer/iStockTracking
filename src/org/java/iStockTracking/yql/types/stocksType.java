package org.java.iStockTracking.yql.types;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the <code>stock</code> type used in the
 * <code>yahoo.finance.stocks</code> table.
 * @see stocksArrayType
 */
public class stocksType {

	private String symbol;
	private String companyName;
	private Date start;
	private Date end;

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	@JsonProperty("CompanyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
}
