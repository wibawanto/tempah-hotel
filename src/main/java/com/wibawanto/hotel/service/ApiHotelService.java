package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Hotel;
import com.wibawanto.hotel.domain.Room;
import com.wibawanto.hotel.repository.HotelRepository;
import com.wibawanto.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author andika
 */
@Service
@RequiredArgsConstructor
public class ApiHotelService implements HotelService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    @Override
    public Iterable<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Iterable<Room> findAvailableRooms(String hotelId) {
        return roomRepository.findRoomsByHotelId(hotelId);
    }
}
