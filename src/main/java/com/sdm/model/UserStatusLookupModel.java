package com.sdm.model;

import java.util.Date;

public class UserStatusLookupModel {

    private Integer id;
    private String statusCode;
    private String statusDescription;
    private Date createdDate;
    private Integer createdUserId;
    private Date lastUpdatedDate;
    private Integer lastUpdatedUserId;
    private Integer isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
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
        return "UserStatusLookupModel{" +
                "id=" + id +
                ", statusCode='" + statusCode + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", createdDate=" + createdDate +
                ", createdUserId=" + createdUserId +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedUserId=" + lastUpdatedUserId +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
