package com.flightsearchservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightsearchservice.exceptions.FlightNotFoundException;
import com.flightsearchservice.model.FlightSearchRequest;
import com.flightsearchservice.model.FlightSearchResponse;
import com.flightsearchservice.service.FlightSearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
public class FlightSearchController {

	private final FlightSearchService flightSearchService;

	@GetMapping("/flights")
	public ResponseEntity<List<FlightSearchResponse>> searchFlights(FlightSearchRequest request)
			throws FlightNotFoundException {

		return new ResponseEntity<>(flightSearchService.searchFlights(request), HttpStatus.OK);
	}

}
