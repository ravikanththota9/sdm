package com.sdm.dto;

import java.util.Date;

public class DeviceResponseDTO {

    private String deviceName;

    private String status;

    private Date scannedTime;

    private String remarks;

    private String runType;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getScannedTime() {
        return scannedTime;
    }

    public void setScannedTime(Date scannedTime) {
        this.scannedTime = scannedTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    @Override
    public String toString() {
        return "DeviceResponseDTO{" +
                "deviceName='" + deviceName + '\'' +
                ", status='" + status + '\'' +
                ", scannedTime=" + scannedTime +
                ", remarks='" + remarks + '\'' +
                ", runType='" + runType + '\'' +
                '}';
    }
}
