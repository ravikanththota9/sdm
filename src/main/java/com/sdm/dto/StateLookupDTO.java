package com.sdm.dto;

/*import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;*/

public class StateLookupDTO {

	private Integer stateId;

	/*@Size(min = 2, max = 2, message = "State Code should be of 2 characters")
	@NotNull(message = "State Code is required")*/
	private String stateCode;

	/*@Size(min = 1, max = 200, message = "State Name should not be empty")
	@NotNull(message = "State Name is required")*/
	private String stateName;

	//@NotNull(message = "Country ID is required")
	private Integer countryLookupId;

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

	public Integer getCountryLookupId() {
		return countryLookupId;
	}

	public void setCountryLookupId(Integer countryLookupId) {
		this.countryLookupId = countryLookupId;
	}

	@Override
	public String toString() {
		return "StateLookupDTO {" + "stateCode='" + stateCode + '\'' + ",stateName='" + stateName + '\'' + '}';

	}

}
