package com.sdm.model;

import java.util.Date;

public class PartnerModel {

    private Integer customerId;

    private String partnerName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    @Override
    public String toString() {
        return "PartnerModel{" +
                "customerId=" + customerId +
                ", partnerName='" + partnerName + '\'' +
                '}';
    }
}
