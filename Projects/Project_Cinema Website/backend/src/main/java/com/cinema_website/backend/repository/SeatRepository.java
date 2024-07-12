package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.mapper.SeatMapper;
import com.cinema_website.backend.model.Seat;
import com.cinema_website.backend.util.SeatUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatRepository {

    private final SeatMapper seatMapper;

    public SeatRepository(SeatMapper seatMapper) {
        this.seatMapper = seatMapper;
    }

    // SELECT
    public SeatDTO getSeatById(int seatId) {
        Seat seat = seatMapper.getSeatById(seatId);
        return SeatUtils.toSeatDTO(seat);
    }

    public List<SeatDTO> getAllSeats() {
        try {
            List<Seat> seats = seatMapper.getAllSeats();
            List<SeatDTO> seatDTOs = new ArrayList<>();
            for (Seat seat : seats) {
                SeatDTO seatDTO = SeatUtils.toSeatDTO(seat);
                seatDTOs.add(seatDTO);
            }
            return seatDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SeatDTO> getSeatsByHallId(int hallId) {
        try {
            List<Seat> seats = seatMapper.getSeatsByHallId(hallId);
            List<SeatDTO> seatDTOs = new ArrayList<>();
            for (Seat seat : seats) {
                SeatDTO seatDTO = SeatUtils.toSeatDTO(seat);
                seatDTOs.add(seatDTO);
            }
            return seatDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT
    public boolean addSeat(SeatDTO seatDTO) {
        try {
            Seat seat = SeatUtils.toSeat(seatDTO);
            return seatMapper.addSeat(seat);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE
    public boolean updateSeatById(int seatId, SeatDTO updatedSeatDTO) {
        try {
            Seat updatedSeat = SeatUtils.toSeat(updatedSeatDTO);
            return seatMapper.updateSeatById(seatId, updatedSeat);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean deleteSeatById(int seatId) {
        try {
            return seatMapper.deleteSeatById(seatId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
