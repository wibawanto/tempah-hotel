package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author andika
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class HotelRepositoryTest {

    @Autowired
    private HotelRepository repository;

    @Test
    public void should_find_all_hotels() {

        Iterable<Hotel> hotels = repository.findAll();

        for (Hotel hotel : hotels) {
            System.out.println(hotel.getRooms());
        }

        int numOfHotels = 2;
        assertThat(hotels).hasSize(numOfHotels);
    }
}
