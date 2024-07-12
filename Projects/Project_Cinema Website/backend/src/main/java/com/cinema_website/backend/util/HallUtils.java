package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.HallDTO;
import com.cinema_website.backend.model.Hall;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@SuppressWarnings("all")

public class HallUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // parse Hall to HallDTO
    public static HallDTO toHallDTO(Hall hall) {
        HallDTO hallDTO = new HallDTO();
        hallDTO.setHallId(hall.getHallId());
        hallDTO.setCinemaId(hall.getCinemaId());
        hallDTO.setHallName(hall.getHallName());
        hallDTO.setExperienceType(hall.getExperienceType());
        hallDTO.setStatus(hall.getStatus());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (hall.getCreatedAt() != null) {
            hallDTO.setCreatedAt(dateFormat.format(hall.getCreatedAt()));
        }
        if (hall.getUpdatedAt() != null) {
            hallDTO.setUpdatedAt(dateFormat.format(hall.getUpdatedAt()));
        }

        return hallDTO;
    }

    // parse HallDTO to Hall
    public static Hall toHall(HallDTO hallDTO) {
        Hall hall = new Hall();
        hall.setHallId(hallDTO.getHallId());
        hall.setCinemaId(hallDTO.getCinemaId());
        hall.setHallName(hallDTO.getHallName());
        hall.setExperienceType(hallDTO.getExperienceType());
        hall.setStatus(hallDTO.getStatus());

        try {
            if (hallDTO.getCreatedAt() != null) {
                hall.setCreatedAt(new Timestamp(dateFormat.parse(hallDTO.getCreatedAt()).getTime()));
            }
            if (hallDTO.getUpdatedAt() != null) {
                hall.setUpdatedAt(new Timestamp(dateFormat.parse(hallDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return hall;
    }
}
