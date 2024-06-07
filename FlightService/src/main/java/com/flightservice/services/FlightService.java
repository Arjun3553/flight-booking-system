package com.flightservice.services;

import java.util.List;

import com.flightservice.exceptions.FlightServiceExceptions;
import com.flightservice.model.FlightRequest;
import com.flightservice.model.FlightResponse;

public interface FlightService {

	FlightResponse createFlight(FlightRequest flightRequest) throws FlightServiceExceptions;

	List<FlightResponse> getAllFlights() throws FlightServiceExceptions;

	FlightResponse getAFlight(String flightNumber) throws FlightServiceExceptions;

}
