package com.flightsearchservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.flightsearchservice.entity.FlightSearch;
import com.flightsearchservice.exceptions.FlightNotFoundException;
import com.flightsearchservice.model.FlightSearchRequest;
import com.flightsearchservice.model.FlightSearchResponse;
import com.flightsearchservice.repository.FlightSearchRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

	private final FlightSearchRepo flightRepo;

	@Override
	public List<FlightSearchResponse> searchFlights(FlightSearchRequest request) throws FlightNotFoundException {

		if (flightRepo.findAll().isEmpty()) {
			throw new FlightNotFoundException("No Flight Details Found", HttpStatus.NOT_FOUND);
		} else {
			List<FlightSearch> flightList = flightRepo
					.findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
							request.getOrigin(), request.getDestination(), request.getTravelDate(),
							request.getPassengers());
			List<FlightSearchResponse> flightResponseList = flightList.stream().map(this::mapToFlightSearchResponse)
					.collect(Collectors.toList());

			return flightResponseList;
		}
	}

	public FlightSearchResponse mapToFlightSearchResponse(FlightSearch flight) {

		FlightSearchResponse flightSearchResponse = new FlightSearchResponse();
		BeanUtils.copyProperties(flight, flightSearchResponse);
		return flightSearchResponse;

	}

}
