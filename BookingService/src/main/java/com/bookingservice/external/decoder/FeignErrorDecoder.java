package com.bookingservice.external.decoder;

import org.springframework.http.HttpStatus;

import com.bookingservice.exceptions.FeignClientException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        switch (response.status()) {
            case 400:
                return new FeignClientException(
                        "Bad request,  Enter all the required fields & check if the values entered is correct",
                        HttpStatus.BAD_REQUEST);

            default:
                return new Exception("generic error");
        }

    }

}
