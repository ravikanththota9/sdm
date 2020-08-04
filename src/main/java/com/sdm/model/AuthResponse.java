package com.sdm.model;

public class AuthResponse {
    private Integer userId;
    private String jwtToken;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "userId='" + userId + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
