package com.wibawanto.hotel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author andika
 */
@Entity
@IdClass(HotelRoom.class)
@Getter
@Setter
public class Room {
    @Id
    @Column(nullable = false, unique = true)
    private int roomNumber;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private BigDecimal costPerNight;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    public void setReservation(Reservation reservation) {
        if (reservation != null) {
            this.reservation = reservation;
            reservation.setRoom(this);
        }
    }

    public boolean isReserved() {
        return reservation != null;
    }
}
