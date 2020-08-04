package com.sdm.exception;

public class UserManagementException extends RuntimeException{

    private String message;

    public UserManagementException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
