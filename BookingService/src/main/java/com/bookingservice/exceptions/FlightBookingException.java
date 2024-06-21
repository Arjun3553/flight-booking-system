package com.bookingservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FlightBookingException extends RuntimeException {

    private final HttpStatus errorCode;

    public FlightBookingException(final String errorMessage, final HttpStatus errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;

    }

}
