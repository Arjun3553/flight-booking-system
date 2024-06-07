package com.bookingservice.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.BookingStatus;
import com.bookingservice.entity.HotelBooking;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.BookingResponse;
import com.bookingservice.model.FlightBookingRequest;
import com.bookingservice.model.HotelBookingRequest;
import com.bookingservice.model.HotelBookingResponse;
import com.bookingservice.repository.HotelBookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Qualifier("hotelBookingService")
public class HotelBookingService implements BookingService {

	private final HotelBookingRepository hotelBookingRepository;

	@Override
	public BookingResponse createBooking(BookingRequest bookingRequest) {

		if (!(bookingRequest instanceof FlightBookingRequest)) {
			throw new IllegalArgumentException("Invalid Booking Type");
		}
		HotelBooking hotelBooking = mapToHotelBooking(bookingRequest);

		hotelBooking = hotelBookingRepository.save(hotelBooking);

		HotelBookingResponse hotelBookingResponse = new HotelBookingResponse();
		BeanUtils.copyProperties(hotelBooking, hotelBookingResponse);

		return hotelBookingResponse;
	}

	private HotelBooking mapToHotelBooking(BookingRequest bookingRequest) {

		HotelBookingRequest hotelBookingRequest = (HotelBookingRequest) bookingRequest;

		HotelBooking hotelBooking = new HotelBooking();
		hotelBooking.setAmount(hotelBookingRequest.getAmount());
		hotelBooking.setBookingDate(LocalDate.now());
		hotelBooking.setBookingNumber(UUID.randomUUID().toString());
		hotelBooking.setCheckInDate(hotelBookingRequest.getCheckInDate());
		hotelBooking.setCheckOutDate(hotelBookingRequest.getCheckOutDate());
		hotelBooking.setHotelName(hotelBooking.getHotelName());
		hotelBooking.setPassengerName(hotelBookingRequest.getPassengerName());
		hotelBooking.setPaymentMode(hotelBookingRequest.getPaymentMode().name());
		hotelBooking.setStatus(BookingStatus.CREATED.name());

		return hotelBooking;
	}

}
