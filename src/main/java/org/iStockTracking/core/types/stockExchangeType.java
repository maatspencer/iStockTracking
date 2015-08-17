package org.iStockTracking.core.types;

import java.util.List;

/**
 * Created by Matt on 8/2/2015.
 */
public class stockExchangeType {
    private String name;
    private String country;
    private List<symbolType> companyList;

    public List<symbolType> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<symbolType> companyList) {
        this.companyList = companyList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
