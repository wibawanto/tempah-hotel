package com.wibawanto.hotel.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author andika
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HotelRoom implements Serializable {
    private Hotel hotel;
    private Integer roomNumber;
}
