package com.wibawanto.hotel.config;

import com.wibawanto.hotel.exception.ResourceNotFoundException;
import com.wibawanto.hotel.util.ApiError;
import com.wibawanto.hotel.util.ResponseEntityBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andika
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex) {

        List<String> details = Arrays.asList(ex.getMessage());

        ApiError err = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Resource Not Found" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Malformed JSON request" ,
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> details = new ArrayList<String>();
        details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getObjectName()+ " : " +error.getDefaultMessage())
                .collect(Collectors.toList());

        ApiError err = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Validation Errors" ,
                details);

        return ResponseEntityBuilder.build(err);
    }
}
