package com.sdm.model;

import java.util.List;

public class UserRequestModel {

    private Integer Id;
    private String loginId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayName;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String contactNumber;
    private Integer customerId;
    private String city;
    private Integer stateLookupId;
    private Integer countryLookupId;
    private String zipCode;
    private Integer userStatusLookupId;
    private String email;
    private List<Integer> userGroupIds;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStateLookupId() {
        return stateLookupId;
    }

    public void setStateLookupId(Integer stateLookupId) {
        this.stateLookupId = stateLookupId;
    }

    public Integer getCountryLookupId() {
        return countryLookupId;
    }

    public void setCountryLookupId(Integer countryLookupId) {
        this.countryLookupId = countryLookupId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getUserStatusLookupId() {
        return userStatusLookupId;
    }

    public void setUserStatusLookupId(Integer userStatusLookupId) {
        this.userStatusLookupId = userStatusLookupId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getUserGroupIds() {
        return userGroupIds;
    }

    public void setUserGroupIds(List<Integer> userGroupIds) {
        this.userGroupIds = userGroupIds;
    }

    @Override
    public String toString() {
        return "UserRequestModel{" +
                "Id=" + Id +
                ", loginId='" + loginId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", customerId=" + customerId +
                ", city='" + city + '\'' +
                ", stateLookupId=" + stateLookupId +
                ", countryLookupId=" + countryLookupId +
                ", zipCode='" + zipCode + '\'' +
                ", userStatusLookupId=" + userStatusLookupId +
                ", email='" + email + '\'' +
                ", userGroupIds=" + userGroupIds +
                '}';
    }
}

