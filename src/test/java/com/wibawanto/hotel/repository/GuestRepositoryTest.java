package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Guest;
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
public class GuestRepositoryTest {

    @Autowired
    private GuestRepository repository;

    @Test
    public void should_find_all_guests() {

        Iterable<Guest> guests = repository.findAll();

        int numOfGuests = 3;
        assertThat(guests).hasSize(numOfGuests);
    }
}
