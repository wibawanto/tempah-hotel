package com.wibawanto.hotel.service;

import com.wibawanto.hotel.domain.Guest;
import com.wibawanto.hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author andika
 */
@Service
@RequiredArgsConstructor
public class ApiGuestService implements GuestService {
    private final GuestRepository guestRepository;

    @Override
    public Guest register(Guest guest) {
        guest.setRegisterDate(LocalDateTime.now());
        return guestRepository.save(guest);
    }
}
