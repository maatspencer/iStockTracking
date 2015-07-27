package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents an array of the <code>cashflow</code> type used in the
 * <code>yahoo.finance.cashflow</code> table.
 * @see cashflowType
 */

public class cashflowArrayType {

	private cashflowType[] cashflow;

	/**
	 * @return the symbol
	 */
	public cashflowType[] getCashflow() {
		return cashflow;
	}

	/**
	 * @param cashflow the symbol to set
	 */
	@JsonProperty("cashflow")
	public void setCashflow(cashflowType[] cashflow) { this.cashflow = cashflow;}
}
