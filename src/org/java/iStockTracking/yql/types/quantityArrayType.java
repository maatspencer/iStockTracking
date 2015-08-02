package org.java.iStockTracking.yql.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


/**
 * This class represents an array of the <code>quant</code> type used in the
 * <code>yahoo.finance.quant</code> table.
 * @see quantityType
 */
public class quantityArrayType {

	@JacksonXmlElementWrapper(useWrapping = false)
	private quantityType[] stock;

	/**
	 * @return array of quantity tables
	 */
	public quantityType[] getStock() {
		return stock;
	}

	/**
	 * @param stock the array of quantity tables
	 */
	@JsonProperty("stock")
	public void setStock(quantityType[] stock) {
		this.stock = stock;
	}
}