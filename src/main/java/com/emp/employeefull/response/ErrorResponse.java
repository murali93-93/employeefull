package com.emp.employeefull.response;

import lombok.Data;

public record ErrorResponse (String message,String errorCode,String details){}

   /* private String message;
    private String errorCode;
    private String details;

    public ErrorResponse(String message, String errorCode, String details) {
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }
*/
