package com.wibawanto.hotel.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author andika
 */
@Getter
@Setter
public class HotelRoom implements Serializable {
    private Hotel hotel;
    private int roomNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelRoom hotelRoom = (HotelRoom) o;
        return roomNumber == hotelRoom.roomNumber &&
                com.google.common.base.Objects.equal(hotel, hotelRoom.hotel);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(hotel, roomNumber);
    }
}
