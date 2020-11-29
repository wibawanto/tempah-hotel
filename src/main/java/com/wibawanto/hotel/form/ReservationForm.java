package com.wibawanto.hotel.form;

import com.wibawanto.hotel.converter.ReservationFormToGuestConverter;
import com.wibawanto.hotel.domain.Guest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author andika
 */
@Getter
@Setter
public class ReservationForm implements Serializable {
    @NotBlank(message = "guestEmail is mandatory")
    @Email(message = "Email should be valid")
    private String guestEmail;

    @NotBlank(message = "guestName is mandatory")
    @Size(min = 2, max = 100, message
            = "guestName must be between 2 and 100 characters")
    private String guestName;

    @NotBlank(message = "guestPhone is mandatory")
    private String guestPhone;

    @NotBlank(message = "hotelId is mandatory")
    private String hotelId;

    @NotNull(message = "roomNumber is mandatory")
    private Integer roomNumber;

    @NotNull(message = "checkInDate is mandatory")
    private LocalDate checkInDate;

    @NotNull(message = "checkOutDate is mandatory")
    private LocalDate checkOutDateh;

    public Guest extractGuest() {
        return new ReservationFormToGuestConverter().convert(this);
    }
}
