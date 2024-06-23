package com.bookingservice.external.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bookingservice.external.client.FlightServiceFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FlightServiceFallback implements FlightServiceFeignClient {

    @Override
    public void reserveSeats(String flightNumber, int seats) {

        log.info("flight service is down, try again later {}",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
