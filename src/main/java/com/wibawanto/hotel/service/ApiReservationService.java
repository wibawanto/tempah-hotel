package com.wibawanto.hotel.service;

import com.wibawanto.hotel.converter.ReservationFormToGuestConverter;
import com.wibawanto.hotel.domain.*;
import com.wibawanto.hotel.exception.ResourceNotFoundException;
import com.wibawanto.hotel.form.ReservationForm;
import com.wibawanto.hotel.repository.GuestRepository;
import com.wibawanto.hotel.repository.HotelRepository;
import com.wibawanto.hotel.repository.ReservationRepository;
import com.wibawanto.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * @author andika
 */
@Service
@RequiredArgsConstructor
public class ApiReservationService implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Override
    public Set<Reservation> findReservations(String guestEmail) {
        Guest guest = guestRepository.findById(guestEmail).get();
        return guest.getReservations();
    }

    @Override
    public Reservation create(ReservationForm reservationForm) {
        Hotel hotel = hotelRepository.findById(reservationForm.getHotelId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Hotel with hotelId : '%s' not found!", reservationForm.getHotelId())));

        Room room = roomRepository.findById(new HotelRoom(hotel, reservationForm.getRoomNumber()))
                .orElseThrow(()->new ResourceNotFoundException(String.format("Room with roomId : '%d' not found!", reservationForm.getRoomNumber())));

        Guest guest = reservationForm.extractGuest();
        guestRepository.save(guest);

        Reservation reservation = new Reservation(guest, room, reservationForm.getCheckInDate(), reservationForm.getCheckOutDate());

        return reservationRepository.save(reservation);
    }
}
