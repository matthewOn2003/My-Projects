package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.model.Seat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SuppressWarnings("all")
public class SeatUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // parse Seat to SeatDTO
    public static SeatDTO toSeatDTO(Seat seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setSeatId(seat.getSeatId());
        seatDTO.setHallId(seat.getHallId());
        seatDTO.setSeatNumber(seat.getSeatNumber());
        seatDTO.setSeatRow(seat.getSeatRow());
        seatDTO.setStatus(seat.getStatus());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (seat.getCreatedAt() != null) {
            seatDTO.setCreatedAt(dateFormat.format(seat.getCreatedAt()));
        }
        if (seat.getUpdatedAt() != null) {
            seatDTO.setUpdatedAt(dateFormat.format(seat.getUpdatedAt()));
        }

        seatDTO.setPrice(String.valueOf(seat.getPrice()));

        return seatDTO;
    }

    // parse SeatDTO to Seat
    public static Seat toSeat(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setSeatId(seatDTO.getSeatId());
        seat.setHallId(seatDTO.getHallId());
        seat.setSeatNumber(seatDTO.getSeatNumber());
        seat.setSeatRow(seatDTO.getSeatRow());
        seat.setStatus(seatDTO.getStatus());

        try {
            if (seatDTO.getCreatedAt() != null) {
                seat.setCreatedAt(new Timestamp(dateFormat.parse(seatDTO.getCreatedAt()).getTime()));
            }
            if (seatDTO.getUpdatedAt() != null) {
                seat.setUpdatedAt(new Timestamp(dateFormat.parse(seatDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        seat.setPrice(new BigDecimal(seatDTO.getPrice()));

        return seat;
    }
}
