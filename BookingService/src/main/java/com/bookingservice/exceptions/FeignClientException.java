package com.bookingservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FeignClientException extends Exception {

    private final HttpStatus errorCode;

    public FeignClientException(final String errorMessage, final HttpStatus errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }
}
