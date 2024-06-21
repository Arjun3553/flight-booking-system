package com.bookingservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bookingservice.model.ErrorResponse;

@RestControllerAdvice
public class BookingServiceGlobalExceptionHandler {

    @ExceptionHandler(FlightBookingException.class)
    public final ResponseEntity<ErrorResponse> handleFlightBookingExceptions(FlightBookingException ex) {

        ErrorResponse errObj = ErrorResponse.builder().errorMessage(ex.getLocalizedMessage())
                .errorCode(ex.getErrorCode()).build();

        return new ResponseEntity<>(errObj, errObj.getErrorCode());

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleGenericExceptions(Exception ex) {
        ErrorResponse errObj = ErrorResponse.builder().errorMessage(ex.getLocalizedMessage())
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return new ResponseEntity<>(errObj, errObj.getErrorCode());
    }

    @ExceptionHandler(HotelBookingException.class)
    public final ResponseEntity<ErrorResponse> handleHotelBookingException(HotelBookingException ex) {
        ErrorResponse errObj = ErrorResponse.builder().errorCode(ex.getErrorCode())
                .errorMessage(ex.getLocalizedMessage()).build();

        return new ResponseEntity<>(errObj, errObj.getErrorCode());
    }

}
