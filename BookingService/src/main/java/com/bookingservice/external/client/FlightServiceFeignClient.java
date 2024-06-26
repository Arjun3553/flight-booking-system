package com.bookingservice.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookingservice.external.config.FlightServiceConfig;
import com.bookingservice.external.fallback.FlightServiceFallback;

@FeignClient(name = "FLIGHT-SERVICE", url = "http://localhost:8888/v1/api/flights", configuration = FlightServiceConfig.class, fallback = FlightServiceFallback.class)
public interface FlightServiceFeignClient {

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber, @RequestParam int seats);

}
