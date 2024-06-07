package com.flightservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FlightServiceExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private HttpStatus httpStatusCode;

	public FlightServiceExceptions(String message, String errorCode, HttpStatus httpStatusCode) {
		super(message);
		this.errorCode = errorCode;
		this.httpStatusCode = httpStatusCode;
	}

}
