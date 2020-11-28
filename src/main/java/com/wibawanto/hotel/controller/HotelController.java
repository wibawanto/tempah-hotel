package com.wibawanto.hotel.controller;

import com.wibawanto.hotel.domain.Hotel;
import com.wibawanto.hotel.domain.Reservation;
import com.wibawanto.hotel.form.ReservationForm;
import com.wibawanto.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author andika
 */
@RestController
@RequestMapping("/v1/hotels")
@Validated
@RequiredArgsConstructor
public class HotelController {
    public final HotelService hotelService;

    @GetMapping
    Iterable<Hotel> findAll() {
        return hotelService.findAll();
    }
}
