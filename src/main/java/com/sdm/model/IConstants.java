package com.sdm.model;

public interface IConstants {
  interface Headers {
    String UUID = "UUID";
    String USER_EMAIL = "userEmail";
    String USER_NAME = "userName";
    String CONTENT_TYPE = "Content-Type";
    String X_USER_ID = "x-user-id";
    String X_USER_NAME = "x-user-name";
    String X_REQUEST_ID = "x-request-id";
    String X_SESSION_ID = "x-session-id";
    String X_TENANT_ID = "x-tenant-id";
    String X_CUSTOMER_NAME = "x-customer-name";
    String X_ACTUAL_CUSTOMER_NAME = "x-actual-customer-name";
    String X_TIMING_DIAGNOSIS = "x-timing-diagnosis";
    String X_IMPERSONATE = "x-impersonate";
    String AUTHORIZATION = "Authorization";
    String BEARER = "Bearer";
    String IS_SUPPLIER = "is_supplier";
    String REFERER = "Referer";
  }

  interface ContentType {
    String TEXT_XML = "text/xml";
    String APPLICATION_JSON = "application/json";
    String MULTIPART_FORMDATA = "multipart/form-data";
    String APPLICATION_VND_MS_EXCEL = "application/vnd.ms-excel";
  }

  interface MediaType {
    String APPLICATION_JSON_WITH_UTF8_CHARSET = "application/json; charset=UTF-8";
    String APPLICATION_JSON = "application/json";
  }

  interface QueryParameter {
    String EMAIL = "email";
  }


  enum StandardResponse {
    SUCCESS("Request processed successfully"),
    ERROR("Request processing failed due to error");

    private String message;

    StandardResponse(String message) {
      this.message = message;
    }

    @Override
    public String toString() {
      return message;
    }
  }

}
