package com.rest.webservice.webservices.exceptions;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class ExceptionResponse {

    private Date Timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        Timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public String getMessage() {
        return message;
    }


    public String getDetails() {
        return details;
    }

}
