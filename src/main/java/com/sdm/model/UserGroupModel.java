package com.sdm.model;

import java.util.Date;

public class UserGroupModel {

    private Integer id;
    private String userGroupName;
    private String userGroupDescription;
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

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserGroupDescription() {
        return userGroupDescription;
    }

    public void setUserGroupDescription(String userGroupDescription) {
        this.userGroupDescription = userGroupDescription;
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
        return "UserGroupModel{" +
                "id=" + id +
                ", userGroupName='" + userGroupName + '\'' +
                ", userGroupDescription='" + userGroupDescription + '\'' +
                ", createdUserId=" + createdUserId +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedUserId=" + lastUpdatedUserId +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
