package com.sdm.model;

import java.util.Date;

public class CountryLookupModel {

    private Integer countryId;

    private String countryCode;

    private String countryName;

    private Date createdDate;

    private Integer createdUserId;

    private Date lastUpdatedDate;

    private Integer lastUpdatedUserId;

    private Integer isDeleted;


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
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(Integer lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "CountryLookupModel{" +
                "countryId=" + countryId +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", createdDate=" + createdDate +
                ", createdUserId=" + createdUserId +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedUserId=" + lastUpdatedUserId +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
