package com.flightservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.flightservice.entity.Flight;
import com.flightservice.exceptions.FlightServiceExceptions;
import com.flightservice.model.FlightRequest;
import com.flightservice.model.FlightResponse;
import com.flightservice.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	private final FlightRepository flightRepository;

	FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;

	}

	@Override
	public FlightResponse createFlight(FlightRequest flightRequest) throws FlightServiceExceptions {

		if (flightRepository.existsByFlightNumber(flightRequest.getFlightNumber())) {

			throw new FlightServiceExceptions("FLIGHT_ALREADY_EXIST", HttpStatus.CONFLICT);

		} else {

			Flight flight = Flight.builder().flightNumber(flightRequest.getFlightNumber())
					.origin(flightRequest.getOrigin()).destination(flightRequest.getDestination())
					.departureDate(flightRequest.getDepartureDate()).arrivalDate(flightRequest.getArrivalDate())
					.totalSeats(flightRequest.getTotalSeats()).availableSeats(flightRequest.getAvailableSeats())
					.amount(flightRequest.getAmount()).build();

			flightRepository.save(flight);

			FlightResponse flightResponse = new FlightResponse();
			BeanUtils.copyProperties(flight, flightResponse);

			return flightResponse;
		}

	}

	@Override
	public List<FlightResponse> getAllFlights() throws FlightServiceExceptions {

		if (flightRepository.findAll().isEmpty()) {
			throw new FlightServiceExceptions("FLIGHT_LIST_NOT_FOUND", HttpStatus.NOT_FOUND);
		} else {
			List<Flight> flights = flightRepository.findAll();

			return flights.stream().map(this::mapToFlightResponse)
					.collect(Collectors.toList());

		}
	}

	@Override
	public FlightResponse getAFlight(String flightNumber) throws FlightServiceExceptions {

		if (flightRepository.existsByFlightNumber(flightNumber)) {

			Flight flight = flightRepository.findByFlightNumber(flightNumber).get();
			FlightResponse flightReponse = new FlightResponse();
			BeanUtils.copyProperties(flight, flightReponse);
			return flightReponse;
		} else {

			throw new FlightServiceExceptions("FLIGHT_NOT_FOUND", HttpStatus.NOT_FOUND);
		}

	}

	public FlightResponse mapToFlightResponse(Flight flight) {

		FlightResponse flightResponse = new FlightResponse();
		BeanUtils.copyProperties(flight, flightResponse);
		return flightResponse;
	}

}
