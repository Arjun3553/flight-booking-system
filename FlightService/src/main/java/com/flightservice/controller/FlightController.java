package com.flightservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightservice.exceptions.FlightServiceExceptions;
import com.flightservice.model.FlightRequest;
import com.flightservice.model.FlightResponse;
import com.flightservice.services.FlightService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/v1/api/flights")
public class FlightController {

	private final FlightService flightService;

	FlightController(final FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping
	public ResponseEntity<?> createFlight(@RequestBody FlightRequest flightRequest) throws FlightServiceExceptions {
		var flight = flightService.createFlight(flightRequest);
		return new ResponseEntity<>(flight, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<FlightResponse>> getAllFlights() throws FlightServiceExceptions {
		List<FlightResponse> flightResponseList = flightService.getAllFlights();
		return new ResponseEntity<>(flightResponseList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlightResponse> getAFlight(@PathVariable("id") String flightNumber)
			throws FlightServiceExceptions {
		var flight = flightService.getAFlight(flightNumber);
		return new ResponseEntity<>(flight, HttpStatus.OK);

	}

	@PutMapping("/reserveSeats/{id}")
	public void reserveSeats(@PathVariable("id") String flightNumber, @RequestParam int seats)
			throws FlightServiceExceptions {
		flightService.reserveSeats(flightNumber, seats);
	}

}
