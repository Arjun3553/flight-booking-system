package com.flightsearchservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSearchRequest {
	
	private String origin;
	private String destination;
	private LocalDate travelDate;
	private Integer passengers;

}
