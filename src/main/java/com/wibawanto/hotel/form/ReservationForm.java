package com.wibawanto.hotel.form;

import com.wibawanto.hotel.converter.ReservationFormToGuestConverter;
import com.wibawanto.hotel.domain.Guest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author andika
 */
@Getter
@Setter
public class ReservationForm implements Serializable {
    @NotBlank(message = "guestEmail is mandatory")
    private String guestEmail;

    @NotBlank(message = "guestName is mandatory")
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
    private LocalDate checkOutDate;

    public Guest extractGuest() {
        return new ReservationFormToGuestConverter().convert(this);
    }
}
