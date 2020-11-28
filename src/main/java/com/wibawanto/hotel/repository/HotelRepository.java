package com.wibawanto.hotel.repository;

import com.wibawanto.hotel.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author andika
 */
@Repository
public interface HotelRepository extends CrudRepository<Hotel, String> {
}
