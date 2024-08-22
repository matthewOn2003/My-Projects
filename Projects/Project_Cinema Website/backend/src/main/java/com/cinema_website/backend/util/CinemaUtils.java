package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.CinemaDTO;
import com.cinema_website.backend.model.Cinema;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@SuppressWarnings("all")
public class CinemaUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // parse Cinema to CinemaDTO
    public static CinemaDTO toCinemaDTO(Cinema cinema) {
        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setCinemaId(cinema.getCinemaId());
        cinemaDTO.setName(cinema.getName());
        cinemaDTO.setAddress(cinema.getAddress());
        cinemaDTO.setLocationLink(cinema.getLocationLink());
        cinemaDTO.setCity(cinema.getCity());
        cinemaDTO.setCinemaImage(cinema.getCinemaImage());
        cinemaDTO.setContactNo(cinema.getContactNo());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (cinema.getCreatedAt() != null) {
            cinemaDTO.setCreatedAt(dateFormat.format(cinema.getCreatedAt()));
        }
        if (cinema.getUpdatedAt() != null) {
            cinemaDTO.setUpdatedAt(dateFormat.format(cinema.getUpdatedAt()));
        }

        return cinemaDTO;
    }

    // parse CinemaDTO to Cinema
    public static Cinema toCinema(CinemaDTO cinemaDTO) {
        Cinema cinema = new Cinema();
        cinema.setCinemaId(cinemaDTO.getCinemaId());
        cinema.setName(cinemaDTO.getName());
        cinema.setAddress(cinemaDTO.getAddress());
        cinema.setLocationLink(cinemaDTO.getLocationLink());
        cinema.setCity(cinemaDTO.getCity());
        cinema.setCinemaImage(cinemaDTO.getCinemaImage());
        cinema.setContactNo(cinemaDTO.getContactNo());

        try {
            if (cinemaDTO.getCreatedAt() != null) {
                cinema.setCreatedAt(new Timestamp(dateFormat.parse(cinemaDTO.getCreatedAt()).getTime()));
            }
            if (cinemaDTO.getUpdatedAt() != null) {
                cinema.setUpdatedAt(new Timestamp(dateFormat.parse(cinemaDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return cinema;
    }
}
