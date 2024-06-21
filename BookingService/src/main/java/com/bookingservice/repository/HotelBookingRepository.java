package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.HotelBooking;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {

    boolean existsByPassengerName(String passengerName);

}
