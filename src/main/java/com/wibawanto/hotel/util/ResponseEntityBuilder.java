package com.wibawanto.hotel.util;

import org.springframework.http.ResponseEntity;

/**
 * @author andika
 */
public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
