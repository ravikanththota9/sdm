package com.sdm.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerHierarchyMappingModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer customerId;

	private Integer reportingCustomerId;

	private String customerType;

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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
		return "CustomerHierarchyMappingModel{" +
				"id=" + id +
				", customerId=" + customerId +
				", reportingCustomerId=" + reportingCustomerId +
				", customerType='" + customerType + '\'' +
				", isDeleted=" + isDeleted +
				", createdDate=" + createdDate +
				", createdUserId=" + createdUserId +
				", lastUpdatedDate=" + lastUpdatedDate +
				", lastUpdatedUserId=" + lastUpdatedUserId +
				'}';
	}
}
