package com.flightsearchservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSearchResponse {

	private Long id;
	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private Double amount;
	private Integer totalSeats;
	private Integer availableSeats;
}
