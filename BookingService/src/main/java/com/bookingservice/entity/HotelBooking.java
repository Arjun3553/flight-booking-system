package com.bookingservice.entity;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("HOTEL")
public class HotelBooking extends Booking {

	private String hotelName;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;

}
