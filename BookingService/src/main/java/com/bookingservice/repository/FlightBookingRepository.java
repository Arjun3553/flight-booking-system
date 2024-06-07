package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.FlightBooking;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {

}
