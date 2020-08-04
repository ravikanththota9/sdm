package com.sdm.model;

import java.util.Date;

public class StateLookupModel {

	private Integer stateId;

	private String stateCode;

	private String stateName;

	private Date createdDate;

	private Integer createdUserId;

	private Date lastUpdatedDate;

	private Integer lastUpdatedUserId;

	private Integer countryLookupId;

	private Integer isDeleted;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	public Integer getCountryLookupId() {
		return countryLookupId;
	}

	public void setCountryLookupId(Integer countryLookupId) {
		this.countryLookupId = countryLookupId;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "StateLookupModel {" + "stateId=" + stateId + ", stateCode=" + stateCode + '\'' + ", stateName="
				+ stateName + '\'' + ", createdDate=" + createdDate + ", createdUserId=" + createdUserId
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedUserId=" + lastUpdatedUserId
				+ ", countryLookupId=" + countryLookupId + ", isDeleted=" + isDeleted + '}';
	}

}
