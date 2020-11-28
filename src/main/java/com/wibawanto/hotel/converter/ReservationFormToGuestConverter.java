package com.wibawanto.hotel.converter;

import com.wibawanto.hotel.domain.Guest;
import com.wibawanto.hotel.form.ReservationForm;
import org.springframework.core.convert.converter.Converter;

/**
 * @author andika
 */
public class ReservationFormToGuestConverter implements Converter<ReservationForm, Guest> {
    @Override
    public Guest convert(ReservationForm form) {
        return new Guest(form.getGuestEmail(), form.getGuestName(), form.getGuestPhone());
    }
}
