package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.BookingResponse;
import com.bookingservice.model.FlightBookingRequest;
import com.bookingservice.model.HotelBookingRequest;
import com.bookingservice.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/api/bookings")
@Slf4j
public class BookingController {

	private final BookingService bookingService;
	private final BookingService hotelBookingService;
	private final BookingService booking;

	public BookingController(@Qualifier("flightBookingService") BookingService bookingService,
			@Qualifier("hotelBookingService") BookingService hotelBookingService, @Qualifier("bookingService") BookingService booking) {
		this.booking = booking;
		this.bookingService = bookingService;
		this.hotelBookingService = hotelBookingService;

	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String createBooking(@RequestBody BookingRequest bookingRequest) {
		log.info("create a booking with request {}", bookingRequest);
		return booking.reserveSeats(bookingRequest);
	}

	@PostMapping("/flight")
	public BookingResponse createFlightBooking(@RequestBody FlightBookingRequest flightBookingRequest) {
		log.info("save {}", flightBookingRequest.getFlightNumber());
		return bookingService.createBooking(flightBookingRequest);
	}

	@PostMapping("/hotel")
	public BookingResponse createHotelBooking(@RequestBody HotelBookingRequest hotelBookingRequest) {
		log.info("save {}", hotelBookingRequest.getHotelName());
		return hotelBookingService.createBooking(hotelBookingRequest);
	}
}
