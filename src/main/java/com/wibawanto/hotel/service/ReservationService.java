package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Guest;
import com.wibawanto.hotel.domain.Reservation;
import com.wibawanto.hotel.domain.Room;
import com.wibawanto.hotel.form.ReservationForm;

import java.util.Set;

/**
 * @author andika
 */
public interface ReservationService {
    Set<Reservation> findReservations(String guestEmail);
    Reservation create(ReservationForm reservationForm);
}
