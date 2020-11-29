package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Hotel;
import com.wibawanto.hotel.domain.HotelRoom;
import com.wibawanto.hotel.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author andika
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, HotelRoom> {
    Iterable<Room> findRoomsByHotelId(String hotelId);
}
