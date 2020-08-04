package com.sdm.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class User implements Serializable {

    private Integer userId = 2;
    private String userName;
    private String password;
    private String userEmail = "mgray@constantcompanion.com";
    private Integer customerId = 1;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
