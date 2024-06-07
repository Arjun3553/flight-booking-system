package com.flightservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flightId;

	private String flightNumber;

	private String origin;

	private String destination;

	private LocalDate departureDate;

	private LocalDate arrivalDate;

	private int totalSeats;

	private int availableSeats;

	private double amount;

}
