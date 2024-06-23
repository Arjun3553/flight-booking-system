package com.bookingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingservice.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
