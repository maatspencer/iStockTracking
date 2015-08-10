package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


/**
 * This class represents the <code>quote</code> type used in the
 * <code>yahoo.finance.historicaldata</code> table.
 * @see historicalDataType
 */
public class historicalDataArrayType {

	@JacksonXmlElementWrapper(useWrapping = false)
	private historicalDataType[] quote;

	/**
	 * @return the stock
	 */
	public historicalDataType[] getQuote() {
		return quote;
	}

	/**
	 * @param quote the stock to set
	 */
	@JsonProperty("quote")
	public void setQuote(historicalDataType[] quote) {this.quote = quote;}
}