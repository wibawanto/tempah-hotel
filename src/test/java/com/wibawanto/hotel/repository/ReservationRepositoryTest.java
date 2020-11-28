package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author andika
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void should_find_all_reservations() {

        Iterable<Reservation> reservations = repository.findAll();

        int numOfReservations = 1;
        assertThat(reservations).hasSize(numOfReservations);
    }
}
