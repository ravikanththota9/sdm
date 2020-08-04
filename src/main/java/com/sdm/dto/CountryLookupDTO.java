package com.sdm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/*import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/

public class CountryLookupDTO {

    private Integer countryId;

    /*@Size(min = 2, max = 2, message = "Country Code should be of 2 characters")
    @NotNull(message = "Country Code is required")*/
    private String countryCode;

    /*@Size(min = 1, max = 200, message = "Country Name should not be empty")
    @NotNull(message = "Country Name is required")*/
    private String countryName;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode.trim();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName.trim();
    }

    @Override
    public String toString() {
        return "CountryLookupDTO{" +
                "countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
