package com.sdm.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String customerNm;

	private Integer reportingCustomerId;

	private String customerType;

	private String addressLine1;

	private String addressLine2;

	private String addressLine3;

	private Integer countryId;

	private Integer stateId;

	private String cityNm;

	private String zipCd;

	private String emailId;

	private String website;

	private String landLineNbr;

	private String mobileNbr;

	private String logoImg;

	private String contactFirstNm;

	private String contactMiddleNm;

	private String contactLastNm;

	private String contactEmailId;

	private String contactLandLineNbr;

	private String contactMobileNbr;

	private String contactDesignation;

	private Integer isDeleted;

	private Date createdDate;

	private Integer createdUserId;

	private Date lastUpdatedDate;

	private Integer lastUpdatedUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerNm() {
		return customerNm;
	}

	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}

	public Integer getReportingCustomerId() {
		return reportingCustomerId;
	}

	public void setReportingCustomerId(Integer reportingCustomerId) {
		this.reportingCustomerId = reportingCustomerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public String getZipCd() {
		return zipCd;
	}

	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLandLineNbr() {
		return landLineNbr;
	}

	public void setLandLineNbr(String landLineNbr) {
		this.landLineNbr = landLineNbr;
	}

	public String getMobileNbr() {
		return mobileNbr;
	}

	public void setMobileNbr(String mobileNbr) {
		this.mobileNbr = mobileNbr;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getContactFirstNm() {
		return contactFirstNm;
	}

	public void setContactFirstNm(String contactFirstNm) {
		this.contactFirstNm = contactFirstNm;
	}

	public String getContactMiddleNm() {
		return contactMiddleNm;
	}

	public void setContactMiddleNm(String contactMiddleNm) {
		this.contactMiddleNm = contactMiddleNm;
	}

	public String getContactLastNm() {
		return contactLastNm;
	}

	public void setContactLastNm(String contactLastNm) {
		this.contactLastNm = contactLastNm;
	}

	public String getContactEmailId() {
		return contactEmailId;
	}

	public void setContactEmailId(String contactEmailId) {
		this.contactEmailId = contactEmailId;
	}

	public String getContactLandLineNbr() {
		return contactLandLineNbr;
	}

	public void setContactLandLineNbr(String contactLandLineNbr) {
		this.contactLandLineNbr = contactLandLineNbr;
	}

	public String getContactMobileNbr() {
		return contactMobileNbr;
	}

	public void setContactMobileNbr(String contactMobileNbr) {
		this.contactMobileNbr = contactMobileNbr;
	}

	public String getContactDesignation() {
		return contactDesignation;
	}

	public void setContactDesignation(String contactDesignation) {
		this.contactDesignation = contactDesignation;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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

	@Override
	public String toString() {
		return "CustomerModel{" +
				"id=" + id +
				", customerNm='" + customerNm + '\'' +
				", reportingCustomerId=" + reportingCustomerId +
				", customerType='" + customerType + '\'' +
				", addressLine1='" + addressLine1 + '\'' +
				", addressLine2='" + addressLine2 + '\'' +
				", addressLine3='" + addressLine3 + '\'' +
				", countryId=" + countryId +
				", stateId=" + stateId +
				", cityNm='" + cityNm + '\'' +
				", zipCd='" + zipCd + '\'' +
				", emailId='" + emailId + '\'' +
				", website='" + website + '\'' +
				", landLineNbr='" + landLineNbr + '\'' +
				", mobileNbr='" + mobileNbr + '\'' +
				", logoImg='" + logoImg + '\'' +
				", contactFirstNm='" + contactFirstNm + '\'' +
				", contactMiddleNm='" + contactMiddleNm + '\'' +
				", contactLastNm='" + contactLastNm + '\'' +
				", contactEmailId='" + contactEmailId + '\'' +
				", contactLandLineNbr='" + contactLandLineNbr + '\'' +
				", contactMobileNbr='" + contactMobileNbr + '\'' +
				", contactDesignation='" + contactDesignation + '\'' +
				", isDeleted=" + isDeleted +
				", createdDate=" + createdDate +
				", createdUserId=" + createdUserId +
				", lastUpdatedDate=" + lastUpdatedDate +
				", lastUpdatedUserId=" + lastUpdatedUserId +
				'}';
	}
}
