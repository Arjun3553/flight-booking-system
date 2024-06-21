package com.flightservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class FlightServiceExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	private final HttpStatus errorCode;

	public FlightServiceExceptions(String message, HttpStatus errorCode) {
		super(message);
		this.errorCode = errorCode;

	}

}
