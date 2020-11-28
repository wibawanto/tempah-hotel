package com.wibawanto.hotel.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author andika
 */
public class LocalDateConverter implements Converter<String, LocalDate> {
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public LocalDate convert(String source) {
        if (source.trim().length() == 0)
            return null;
        try {
            return LocalDate.parse(source);
        } catch (Exception e) {
            return LocalDate.parse(source, DateTimeFormatter.ofPattern(DATE_PATTERN));
        }
    }
}
