package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Guest;
import com.wibawanto.hotel.repository.GuestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author andika
 */
@ExtendWith(MockitoExtension.class)
public class HotelGuestServiceTest {
    @Mock
    private GuestRepository guestRepository;

    private ApiGuestService apiGuestService;

    @BeforeEach
    void init() {
        apiGuestService = new ApiGuestService(guestRepository);
    }

    @Test
    void should_has_registered_date() {
        Guest newGuest = new Guest("andi@gmail.com", "Andi", "0123545");
        apiGuestService.register(newGuest);
        assertThat(newGuest.getRegisterDate()).isNotNull();
    }
}
