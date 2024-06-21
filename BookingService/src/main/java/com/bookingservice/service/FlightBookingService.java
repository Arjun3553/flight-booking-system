package com.bookingservice.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingStatus;
import com.bookingservice.entity.FlightBooking;
import com.bookingservice.exceptions.FlightBookingException;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.BookingResponse;
import com.bookingservice.model.FlightBookingRequest;
import com.bookingservice.model.FlightBookingResponse;
import com.bookingservice.repository.FlightBookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Qualifier("flightBookingService")
public class FlightBookingService implements BookingService {

	private final FlightBookingRepository flightBookingRepository;

	@Override
	public BookingResponse createBooking(BookingRequest bookingRequest) {

		if (!(bookingRequest instanceof FlightBookingRequest)) {
			throw new FlightBookingException("Invalid Booking Type", HttpStatus.BAD_REQUEST);
		}
		FlightBooking flightBooking = mapToFlightBooking(bookingRequest);

		if (flightBookingRepository.existsByFlightNumber(flightBooking.getFlightNumber())) {
			throw new FlightBookingException(
					"Flight Already Booked For Passenger : " + flightBooking.getPassengerName()
							+ " with FlightNumber : "
							+ flightBooking.getFlightNumber() + "",
					HttpStatus.CONFLICT);
		}

		flightBooking = flightBookingRepository.save(flightBooking);

		FlightBookingResponse flightBookingResponse = new FlightBookingResponse();
		BeanUtils.copyProperties(flightBooking, flightBookingResponse);

		return flightBookingResponse;

	}

	private FlightBooking mapToFlightBooking(BookingRequest bookingRequest) {
		FlightBookingRequest flightBookingRequest = (FlightBookingRequest) bookingRequest;

		FlightBooking flightBooking = new FlightBooking();
		flightBooking.setAmount(flightBookingRequest.getAmount());
		flightBooking.setBookingDate(LocalDate.now());
		flightBooking.setBookingNumber(UUID.randomUUID().toString());
		flightBooking.setFlightNumber(flightBookingRequest.getFlightNumber());
		flightBooking.setPassengerName(flightBookingRequest.getPassengerName());
		flightBooking.setPaymentMode(flightBookingRequest.getPaymentMode().name());
		flightBooking.setStatus(BookingStatus.CREATED.name());

		return flightBooking;
	}

}
