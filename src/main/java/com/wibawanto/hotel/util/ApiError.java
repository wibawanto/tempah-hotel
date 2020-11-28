package com.wibawanto.hotel.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author andika
 */
@Getter
@Setter
public class ApiError {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private List errors;

    public ApiError(HttpStatus status, String message, List errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
