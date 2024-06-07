package com.flightservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightservice.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	Optional<Flight> findByFlightNumber(String flightNumber);

	boolean existsByFlightNumber(String flightNumber);

}
