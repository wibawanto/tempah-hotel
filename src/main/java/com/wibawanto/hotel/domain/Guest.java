package com.wibawanto.hotel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author andika
 */
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Guest {
    @Id
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reservation> reservations;

    public Guest(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }
}
