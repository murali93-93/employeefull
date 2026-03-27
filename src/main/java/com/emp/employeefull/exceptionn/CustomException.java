package com.emp.employeefull.exceptionn;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{

    private String errorCode;
    private String details;
    private HttpStatus httpStatus;

    public CustomException(){
        super();
    }

    public CustomException(String message, String details, HttpStatus httpStatus) {
        super(message);
        this.details = details;
        this.httpStatus = httpStatus;
    }
    // Message + Status
    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    // Full constructor
    public CustomException(String message, String errorCode, String details, HttpStatus httpStatus) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
        this.httpStatus = httpStatus;
    }

    // Message + Cause + Status
    public CustomException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    // Getters
    public String getErrorCode() {
        return errorCode;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}
