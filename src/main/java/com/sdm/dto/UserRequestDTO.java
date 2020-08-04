package com.sdm.dto;

import java.util.Date;
import java.util.List;

public class UserRequestDTO {

    private Integer Id;
    private String loginId;
    private String loginPassword;
    private String firstName;
    private String middleName;
    private String lastName;
    private String displayName;
    private Date createdDate;
    private Integer createdUserId;
    private Date lastUpdatedDate;
    private Integer lastUpdatedUserId;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String contactNumber;
    private Integer customerId;
    private String city;
    private Integer stateLookupId;
    private Integer countryLookupId;
    private String zipCode;
    private String imagePath;
    private Integer idDeleted;
    private Integer inNew;
    private Integer newLinkExpiryHour;
    private String otp;
    private Integer userStatusLookupId;
    private String email;
    private Integer failedLoginAttempts;
    private Integer passwordChangeCount;
    private List<Integer> userGroupId;

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

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(Integer idDeleted) {
        this.idDeleted = idDeleted;
    }

    public Integer getInNew() {
        return inNew;
    }

    public void setInNew(Integer inNew) {
        this.inNew = inNew;
    }

    public Integer getNewLinkExpiryHour() {
        return newLinkExpiryHour;
    }

    public void setNewLinkExpiryHour(Integer newLinkExpiryHour) {
        this.newLinkExpiryHour = newLinkExpiryHour;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
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

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public Integer getPasswordChangeCount() {
        return passwordChangeCount;
    }

    public void setPasswordChangeCount(Integer passwordChangeCount) {
        this.passwordChangeCount = passwordChangeCount;
    }

    public List<Integer> getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(List<Integer> userGroupId) {
        this.userGroupId = userGroupId;
    }
}
