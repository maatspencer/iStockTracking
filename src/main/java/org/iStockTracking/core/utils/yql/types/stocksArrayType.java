package org.iStockTracking.core.utils.yql.types;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


/**
 * This class represents an array of <code>stock</code> types used in
 * the <code>yahoo.finance.stocks</code> table.
 * @see stocksType
 */
public class stocksArrayType {

	@JacksonXmlElementWrapper(useWrapping=false)
	private stocksType[] stock;

	/**
	 * @return the stock
	 */
	public stocksType[] getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(stocksType[] stock) {
		this.stock = stock;
	}
}
