package com.bookingservice.model;

import lombok.Data;

@Data
public sealed class BookingRequest permits FlightBookingRequest, HotelBookingRequest {

	private String passengerName;
	private double amount;
	private PaymentMode paymentMode;
	private String flightNumber;
	private int seats;

}
