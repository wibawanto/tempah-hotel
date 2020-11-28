package com.wibawanto.hotel.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author andika
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public LocalDateTime convert(String source) {
        if (source.trim().length() == 0)
            return null;
        // first tries ISO format: 2019-07-15T16: 00: 00
        try {
            return LocalDateTime.parse(source);
        } catch (Exception e) {
            return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        }
    }
}
