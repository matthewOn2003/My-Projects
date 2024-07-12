package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.CinemaDTO;
import com.cinema_website.backend.service.CinemaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {

    private final ObjectMapper objectMapper;
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(ObjectMapper objectMapper, CinemaService cinemaService) {
        this.objectMapper = objectMapper;
        this.cinemaService = cinemaService;
    }

    // GET
    @GetMapping("/getCinema/{cinemaId}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable int cinemaId) {
        CinemaDTO cinema = cinemaService.getCinema(cinemaId);
        if (cinema != null) {
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCinemas")
    public ResponseEntity<List<CinemaDTO>> getAllCinemas() {
        List<CinemaDTO> cinemaList = cinemaService.getAllCinemas();
        if (cinemaList != null && !cinemaList.isEmpty()) {
            return new ResponseEntity<>(cinemaList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addCinema")
    public ResponseEntity<Boolean> addCinema(@RequestBody CinemaDTO cinema) {
        boolean result = cinemaService.addCinema(cinema);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateCinema/{cinemaId}")
    public ResponseEntity<Boolean> updateCinema(@PathVariable int cinemaId, @RequestBody CinemaDTO updatedCinema) {
        boolean result = cinemaService.updateCinema(cinemaId, updatedCinema);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteCinema/{cinemaId}")
    public ResponseEntity<Boolean> deleteCinema(@PathVariable int cinemaId) {
        boolean result = cinemaService.deleteCinema(cinemaId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
