package com.flightsearchservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FlightNotFoundException extends Exception {

	private HttpStatus errorCode;

	public FlightNotFoundException(String errorMessage, HttpStatus errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

}
