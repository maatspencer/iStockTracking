package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


/**
 * This class represents an array of the <code>quote</code> type used in the
 * <code>yahoo.finance.quote</code> table.
 * @see quoteType
 */
public class quoteArrayType {

	@JacksonXmlElementWrapper(useWrapping = false)
	private quoteType[] quote;

	/**
	 * @return quote
	 */
	public quoteType[] getQuote() {
		return quote;
	}

	/**
	 * @param quote
	 */
	@JsonProperty("quote")
	public void setQuote(quoteType[] quote) {
		this.quote = quote;
	}
}