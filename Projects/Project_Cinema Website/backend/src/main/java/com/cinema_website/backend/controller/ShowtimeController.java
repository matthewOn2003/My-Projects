package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.ShowtimeDTO;
import com.cinema_website.backend.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    // GET
    @GetMapping("/getShowtime/{showtimeId}")
    public ResponseEntity<ShowtimeDTO> getShowtimeById(@PathVariable int showtimeId) {
        ShowtimeDTO showtime = showtimeService.getShowtime(showtimeId);
        if (showtime != null) {
            return new ResponseEntity<>(showtime, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllShowtimes")
    public ResponseEntity<List<ShowtimeDTO>> getAllShowtimes() {
        List<ShowtimeDTO> showtimeList = showtimeService.getAllShowtimes();
        if (showtimeList != null && !showtimeList.isEmpty()) {
            return new ResponseEntity<>(showtimeList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getShowtimesByMovieId/{movieId}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByMovieId(@PathVariable int movieId) {
        List<ShowtimeDTO> showtimeList = showtimeService.getShowtimesByMovieId(movieId);
        if (showtimeList != null && !showtimeList.isEmpty()) {
            return new ResponseEntity<>(showtimeList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getShowtimesByCinemaId/{cinemaId}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByCinemaId(@PathVariable int cinemaId) {
        List<ShowtimeDTO> showtimeList = showtimeService.getShowtimesByCinemaId(cinemaId);
        if (showtimeList != null && !showtimeList.isEmpty()) {
            return new ResponseEntity<>(showtimeList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getShowtimesByHallId/{hallId}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByHallId(@PathVariable int hallId) {
        List<ShowtimeDTO> showtimeList = showtimeService.getShowtimesByHallId(hallId);
        if (showtimeList != null && !showtimeList.isEmpty()) {
            return new ResponseEntity<>(showtimeList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getShowtimesByMovieDateExperience/{movieId}/{showDate}/{experienceType}")
    public ResponseEntity<List<ShowtimeDTO>> getShowtimesByMovieDateExperience(@PathVariable int movieId,
                                                                               @PathVariable String showDate,
                                                                               @PathVariable String experienceType) {
        List<ShowtimeDTO> showtimeList = showtimeService.getShowtimesByMovieDateExperience(movieId, showDate, experienceType);
        if (showtimeList != null && !showtimeList.isEmpty()) {
            return new ResponseEntity<>(showtimeList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getShowtimesExperiences/{movieId}/{showDate}")
    public ResponseEntity<List<String>> getShowtimesExperiences(@PathVariable int movieId,
                                                                     @PathVariable String showDate) {
        List<String> experiences = showtimeService.getShowtimesExperiences(movieId, showDate);
        if (experiences != null && !experiences.isEmpty()) {
            return new ResponseEntity<>(experiences, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }




    // POST
    @PostMapping("/addShowtime")
    public ResponseEntity<Boolean> addShowtime(@RequestBody ShowtimeDTO showtimeDTO) {
        boolean result = showtimeService.addShowtime(showtimeDTO);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateShowtime/{showtimeId}")
    public ResponseEntity<Boolean> updateShowtime(@PathVariable int showtimeId, @RequestBody ShowtimeDTO updatedShowtime) {
        boolean result = showtimeService.updateShowtime(showtimeId, updatedShowtime);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteShowtime/{showtimeId}")
    public ResponseEntity<Boolean> deleteShowtime(@PathVariable int showtimeId) {
        boolean result = showtimeService.deleteShowtime(showtimeId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
