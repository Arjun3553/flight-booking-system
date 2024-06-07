package com.flightsearchservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String flightNumber;
	private String origin;
	private String destination;
	private LocalDate departureDate;
	private LocalDate arrivalDate;
	private Double amount;
	private Integer availableSeats;
}
