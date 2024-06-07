package com.bookingservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	public BookingController(@Qualifier("flightBookingService") BookingService bookingService,
			BookingService hotelBookingService) {

		this.bookingService = bookingService;
		this.hotelBookingService = hotelBookingService;

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
