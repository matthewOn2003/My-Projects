package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // GET
    public SeatDTO getSeat(int seatId) {
        return seatRepository.getSeatById(seatId);
    }

    public List<SeatDTO> getAllSeats() {
        return seatRepository.getAllSeats();
    }

    public List<SeatDTO> getSeatsByHallId(int hallId) {
        return seatRepository.getSeatsByHallId(hallId);
    }

    // INSERT
    public boolean addSeat(SeatDTO seat) {
        return seatRepository.addSeat(seat);
    }

    // UPDATE
    public boolean updateSeat(int seatId, SeatDTO updatedSeat) {
        return seatRepository.updateSeatById(seatId, updatedSeat);
    }

    // DELETE
    public boolean deleteSeat(int seatId) {
        return seatRepository.deleteSeatById(seatId);
    }
}
