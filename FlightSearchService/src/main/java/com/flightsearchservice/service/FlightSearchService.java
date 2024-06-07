package com.flightsearchservice.service;

import java.util.List;

import com.flightsearchservice.exceptions.FlightNotFoundException;
import com.flightsearchservice.model.FlightSearchRequest;
import com.flightsearchservice.model.FlightSearchResponse;

public interface FlightSearchService {

	List<FlightSearchResponse> searchFlights(FlightSearchRequest request) throws FlightNotFoundException;
}
