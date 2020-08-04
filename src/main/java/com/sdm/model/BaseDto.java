package com.sdm.model;

import com.sdm.constants.IConstants;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sdm.utils.HttpStatusDeserializer;
import com.sdm.utils.HttpStatusSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * BaseDTO to hold result with message and status code.
 *
 * @author Thota.
 * @version 1.0
 **/

public class BaseDto<T> {

    private String message;

    @JsonSerialize(using = HttpStatusSerializer.class)
    @JsonDeserialize(using = HttpStatusDeserializer.class)
    private HttpStatus responseStatus = HttpStatus.OK;

    private T result;

    private Integer status;

    private String responseCode;

    public BaseDto() {
    }

    public BaseDto(String message, HttpStatus responseStatus) {
        this.message = message;
        this.responseStatus = responseStatus;
        this.status = responseStatus.value();
        this.responseCode = responseStatus.getReasonPhrase();
    }

    /**
     * Instantiates a new base dto.
     *
     * @param result         the result
     * @param message        the message
     * @param responseStatus the http response status
     */
    public BaseDto(T result, String message, HttpStatus responseStatus) {
        this.result = result;
        this.message = message;
        this.responseStatus = responseStatus;
        this.status = responseStatus.value();
        this.responseCode = responseStatus.getReasonPhrase();
    }

    public BaseDto(HttpStatus responseStatus, T result) {
        this.result = result;
        this.responseStatus = responseStatus;
        this.status = responseStatus.value();
        this.responseCode = responseStatus.getReasonPhrase();
    }

    public BaseDto(IConstants.StandardResponse response, HttpStatus responseStatus) {
        this.message = response.toString();
        this.responseStatus = responseStatus;
        this.status = responseStatus.value();
        this.responseCode = responseStatus.getReasonPhrase();
    }

    public ResponseEntity<BaseDto<T>> respond() {
        return new ResponseEntity<>(this, this.getResponseStatus());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}

