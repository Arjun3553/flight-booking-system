package com.flightsearchservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightsearchservice.entity.FlightSearch;

@Repository
public interface FlightSearchRepo extends JpaRepository<FlightSearch, Long> {

	List<FlightSearch> findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
			String origin, String destination, LocalDate date, Integer passenger);

}
