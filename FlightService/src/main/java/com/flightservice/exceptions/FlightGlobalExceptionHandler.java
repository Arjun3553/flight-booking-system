package com.flightservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flightservice.model.ErrorResponse;

@RestControllerAdvice
public class FlightGlobalExceptionHandler {

	@ExceptionHandler(FlightServiceExceptions.class)
	public ResponseEntity<ErrorResponse> handleFlightServiceException(FlightServiceExceptions ex) {

		ErrorResponse erObj = ErrorResponse.builder().errorCode(ex.getErrorCode())
				.errorMessage(ex.getMessage()).build();

		return new ResponseEntity<>(erObj, erObj.getErrorCode());

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

		ErrorResponse erObj = ErrorResponse.builder().errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
				.errorMessage(ex.getMessage()).build();

		return new ResponseEntity<>(erObj, erObj.getErrorCode());

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<>();
		ex.getFieldErrors().forEach((errors) -> {
			errorMap.put(errors.getField(), errors.getDefaultMessage());
		});

		return errorMap;

	}

}
