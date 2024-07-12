package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.SeatDTO;
import com.cinema_website.backend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // GET
    @GetMapping("/getSeat/{seatId}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable int seatId) {
        SeatDTO seat = seatService.getSeat(seatId);
        if (seat != null) {
            return new ResponseEntity<>(seat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSeats")
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        List<SeatDTO> seatList = seatService.getAllSeats();
        if (seatList != null && !seatList.isEmpty()) {
            return new ResponseEntity<>(seatList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSeatsByHallId/{hallId}")
    public ResponseEntity<List<SeatDTO>> getSeatsByHallId(@PathVariable int hallId) {
        List<SeatDTO> seatList = seatService.getSeatsByHallId(hallId);
        if (seatList != null && !seatList.isEmpty()) {
            return new ResponseEntity<>(seatList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addSeat")
    public ResponseEntity<Boolean> addSeat(@RequestBody SeatDTO seat) {
        boolean result = seatService.addSeat(seat);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateSeat/{seatId}")
    public ResponseEntity<Boolean> updateSeat(@PathVariable int seatId, @RequestBody SeatDTO updatedSeat) {
        boolean result = seatService.updateSeat(seatId, updatedSeat);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteSeat/{seatId}")
    public ResponseEntity<Boolean> deleteSeat(@PathVariable int seatId) {
        boolean result = seatService.deleteSeat(seatId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
