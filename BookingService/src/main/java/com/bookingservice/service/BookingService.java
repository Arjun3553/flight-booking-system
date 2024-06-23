package com.bookingservice.service;

import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.BookingResponse;

public interface BookingService {

	public BookingResponse createBooking(BookingRequest bookingRequest);

	public String reserveSeats(BookingRequest bookingRequest);
}
