package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


/**
 * This class represents an array of the <code>dividendhistory</code> type used in the
 * <code>yahoo.finance.dividendhistory</code> table.
 * @see dividendHistoryType
 */
public class dividendHistoryArrayType {

	@JacksonXmlElementWrapper(useWrapping = false)
	private dividendHistoryType[] quote;

	/**
	 * @return the quote
	 */
	public dividendHistoryType[] getQuote() {
		return quote;
	}

	/**
	 * @param quote the quote to set
	 */
	@JsonProperty("quote")
	public void setQuote(dividendHistoryType[] quote) {this.quote = quote;}
}