package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author andika
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
