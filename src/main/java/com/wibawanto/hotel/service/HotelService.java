package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Hotel;
import com.wibawanto.hotel.domain.Room;

import java.util.Set;

/**
 * @author andika
 */
public interface HotelService {
    Iterable<Hotel> findAll();
    Iterable<Room> findAvailableRooms(String hotelId);
}
