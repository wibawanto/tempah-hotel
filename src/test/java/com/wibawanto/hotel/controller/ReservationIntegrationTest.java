package com.wibawanto.hotel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wibawanto.hotel.form.ReservationForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author andika
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReservationIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String RESERVATIONS_URL = "/v1/reservations";

    @Test
    public void reservation_form_shall_not_empty() throws Exception {
        ReservationForm form = new ReservationForm();
        String json = objectMapper.writeValueAsString(form);
        MvcResult result = this.mockMvc.perform(
                post(RESERVATIONS_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void shall_reserve_room_successfully() throws Exception {
        ReservationForm form = new ReservationForm();
        form.setGuestName("Andika");
        form.setGuestEmail("andika@gmail.com");
        form.setGuestPhone("01220455");
        form.setHotelId("HiltonKL");
        form.setRoomNumber(111);
        form.setCheckInDate(LocalDate.now());
        form.setCheckOutDate(LocalDate.now());

        String json = objectMapper.writeValueAsString(form);
        MvcResult result = this.mockMvc.perform(
                post(RESERVATIONS_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();
    }
}
