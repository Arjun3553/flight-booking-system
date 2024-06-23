package com.bookingservice.external.config;

import java.lang.System.Logger;

import org.springframework.context.annotation.Bean;

import com.bookingservice.external.decoder.FeignErrorDecoder;

import feign.codec.ErrorDecoder;

public class FlightServiceConfig {

    @Bean
    public Logger.Level feignClientLogger() {
        return Logger.Level.ALL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

}
