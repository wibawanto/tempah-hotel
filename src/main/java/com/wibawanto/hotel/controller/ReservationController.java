package com.wibawanto.hotel.controller;

import com.wibawanto.hotel.domain.Reservation;
import com.wibawanto.hotel.form.ReservationForm;
import com.wibawanto.hotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andika
 */
@RestController
@RequestMapping("/v1/reservations")
@Validated
@RequiredArgsConstructor
public class ReservationController {
    public final ReservationService reservationService;
    @PostMapping
    ResponseEntity<Reservation> create(@Valid @RequestBody ReservationForm reservationForm) {
        Reservation reservation = reservationService.create(reservationForm);
        return ResponseEntity.ok().body(reservation);
    }
}
