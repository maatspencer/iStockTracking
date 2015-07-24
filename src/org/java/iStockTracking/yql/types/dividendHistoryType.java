/*
 * Copyright (C) 2014 Philipp Nanz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents the <code>cashflow</code> type used in the
 * <code>yahoo.finance.cashflow</code> table.
 */

public class dividendHistoryType {

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
