package com.sdm.dto;

import java.util.ArrayList;
import java.util.List;

public class ClientAccountDevicesResponseDTO {

    private String userName;

    private List<DeviceResponseDTO> deviceResponseDTOList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<DeviceResponseDTO> getDeviceResponseDTOList() {
        return deviceResponseDTOList;
    }

    public void setDeviceResponseDTOList(List<DeviceResponseDTO> deviceResponseDTOList) {
        this.deviceResponseDTOList = deviceResponseDTOList;
    }

    @Override
    public String toString() {
        return "ClientAccountsResponseDTO{" +
                "userName='" + userName + '\'' +
                ", deviceResponseDTOList=" + deviceResponseDTOList +
                '}';
    }
}
