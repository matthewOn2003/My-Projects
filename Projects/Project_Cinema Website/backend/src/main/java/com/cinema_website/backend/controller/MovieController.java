package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.MovieDTO;
import com.cinema_website.backend.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("all")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final ObjectMapper objectMapper;
    private final MovieService movieService;

    @Autowired
    public MovieController(ObjectMapper objectMapper, MovieService movieService) {
        this.objectMapper = objectMapper;
        this.movieService = movieService;
    }

    // GET
    @GetMapping("/getMovie/{movieId}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable int movieId) {
        MovieDTO movie = movieService.getMovie(movieId);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movieList = movieService.getAllMovies();
        if (movieList != null && !movieList.isEmpty()) {
            return new ResponseEntity<>(movieList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // POST
    @PostMapping("/addMovie")
    public ResponseEntity<Boolean> addMovie(@RequestBody MovieDTO movie) {
        boolean result = movieService.addMovie(movie);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateMovie/{movieId}")
    public ResponseEntity<Boolean> updateMovie(@PathVariable int movieId, @RequestBody MovieDTO updatedMovie) {
        boolean result = movieService.updateMovie(movieId, updatedMovie);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable int movieId) {
        boolean result = movieService.deleteMovie(movieId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}

