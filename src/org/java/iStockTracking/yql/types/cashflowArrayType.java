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
 * This class represents an array of the <code>cashflow</code> type used in the
 * <code>yahoo.finance.cashflow</code> table.
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
