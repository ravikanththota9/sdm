package com.sdm.dto;

public class ClientAccountResponseDTO {

    private String userName;

    private String password;

    private Integer deviceCount;

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

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    @Override
    public String toString() {
        return "UserAccountsDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", deviceCount=" + deviceCount +
                '}';
    }
}
