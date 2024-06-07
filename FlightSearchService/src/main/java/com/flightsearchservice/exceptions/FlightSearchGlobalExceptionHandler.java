package com.flightsearchservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flightsearchservice.model.ErrorMessage;

@RestControllerAdvice
public class FlightSearchGlobalExceptionHandler {

	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleFlightNotFoundException(FlightNotFoundException ex) {
		ErrorMessage errorObj = ErrorMessage.builder().errorMessage(ex.getMessage()).errorCode(ex.getErrorCode())
				.build();

		return new ResponseEntity<>(errorObj, errorObj.getErrorCode());

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
		ErrorMessage errorObj = ErrorMessage.builder().errorMessage(ex.getMessage())
				.errorCode(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return new ResponseEntity<>(errorObj, errorObj.getErrorCode());
	}
}
