package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Reservation;
import com.wibawanto.hotel.repository.GuestRepository;
import com.wibawanto.hotel.repository.HotelRepository;
import com.wibawanto.hotel.repository.ReservationRepository;
import com.wibawanto.hotel.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author andika
 */
@ExtendWith(MockitoExtension.class)
public class HotelReservationServiceTest {
    @Mock
    private GuestRepository guestRepository;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private RoomRepository roomRepository;

    private ApiReservationService apiReservationService;

    @BeforeEach
    void init() {
        apiReservationService = new ApiReservationService(reservationRepository, guestRepository, hotelRepository, roomRepository);
    }

    @Test
    void should_has_empty_reservation() {
        Set<Reservation> reservations = apiReservationService.findReservations("andi@unknown.net");
        assertThat(reservations).isEmpty();
    }
}
