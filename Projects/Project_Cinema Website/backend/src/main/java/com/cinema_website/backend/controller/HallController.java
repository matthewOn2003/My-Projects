package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.HallDTO;
import com.cinema_website.backend.service.HallService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
public class HallController {

    private final ObjectMapper objectMapper;
    private final HallService hallService;

    @Autowired
    public HallController(ObjectMapper objectMapper, HallService hallService) {
        this.objectMapper = objectMapper;
        this.hallService = hallService;
    }

    // GET
    @GetMapping("/getHall/{hallId}")
    public ResponseEntity<HallDTO> getHallById(@PathVariable int hallId) {
        HallDTO hall = hallService.getHall(hallId);
        if (hall != null) {
            return new ResponseEntity<>(hall, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllHalls")
    public ResponseEntity<List<HallDTO>> getAllHalls() {
        List<HallDTO> hallList = hallService.getAllHalls();
        if (hallList != null && !hallList.isEmpty()) {
            return new ResponseEntity<>(hallList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getHallsByCinemaId/{cinemaId}")
    public ResponseEntity<List<HallDTO>> getHallsByCinemaId(@PathVariable int cinemaId) {
        List<HallDTO> hallList = hallService.getHallsByCinemaId(cinemaId);
        if (hallList != null && !hallList.isEmpty()) {
            return new ResponseEntity<>(hallList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addHall")
    public ResponseEntity<Boolean> addHall(@RequestBody HallDTO hall) {
        boolean result = hallService.addHall(hall);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateHall/{hallId}")
    public ResponseEntity<Boolean> updateHall(@PathVariable int hallId, @RequestBody HallDTO updatedHall) {
        boolean result = hallService.updateHall(hallId, updatedHall);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteHall/{hallId}")
    public ResponseEntity<Boolean> deleteHall(@PathVariable int hallId) {
        boolean result = hallService.deleteHall(hallId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
