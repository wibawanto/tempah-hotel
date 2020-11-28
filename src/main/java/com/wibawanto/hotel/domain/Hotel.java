package com.wibawanto.hotel.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author andika
 */
@Entity
@Getter
@Setter
public class Hotel {
    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @Column(nullable = false)
    private int stars;

}
