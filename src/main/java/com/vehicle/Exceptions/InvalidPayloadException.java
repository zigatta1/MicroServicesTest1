package com.vehicle.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InvalidPayloadException extends RuntimeException {

    private HttpStatus statusCode;
    private String errorMessage;

    public InvalidPayloadException(HttpStatus statusCode, String errorMessage) {
        super(String.format("%s", errorMessage));
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
