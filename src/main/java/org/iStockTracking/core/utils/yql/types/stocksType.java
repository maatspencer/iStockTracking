package org.iStockTracking.core.utils.yql.types;

import java.text.*;
import java.util.Date;
import java.util.Locale;

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
	public void setStart(String start)
		throws ParseException
	{
		if (start.contains("NaN")){
			start = start.replace("NaN-","");
			start += "-01";
		}

		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date d = format.parse(start);

		this.start = d;
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
	public void setEnd(String end)
		throws Exception
	{
		if (end.contains("NaN")){
			end = end.replace("NaN-","");
			end += "-01";
		}

		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date d = format.parse(end);

		this.end = d;
	}
}
