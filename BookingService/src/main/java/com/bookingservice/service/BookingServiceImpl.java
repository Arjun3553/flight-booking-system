package com.bookingservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bookingservice.entity.Booking;
import com.bookingservice.external.client.FlightServiceFeignClient;
import com.bookingservice.model.BookingRequest;
import com.bookingservice.model.BookingResponse;
import com.bookingservice.repository.BookingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Qualifier("bookingService")
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final FlightServiceFeignClient flightService;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }

    @Override
    public String reserveSeats(BookingRequest bookingRequest) {
        log.info("create booking for user {}", bookingRequest.getPassengerName());

        Booking booking = Booking.builder().bookingNumber(UUID.randomUUID().toString())
                .passengerName(bookingRequest.getPassengerName())
                .status("BOOKING_CREATED").amount(5000).paymentMode(bookingRequest.getPaymentMode().name())
                .flightNumber(bookingRequest.getFlightNumber()).seats(bookingRequest.getSeats()).build();

        bookingRepository.save(booking);

        log.info("booking status: {}", booking.getStatus());

        flightService.reserveSeats(bookingRequest.getFlightNumber(), bookingRequest.getSeats());

        log.info("seats are reserved for booking {}", bookingRequest.getFlightNumber());

        return "Successfully created booking id for user";

    }

}
