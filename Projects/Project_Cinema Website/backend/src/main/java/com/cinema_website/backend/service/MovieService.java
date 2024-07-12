package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.MovieDTO;
import com.cinema_website.backend.mapper.MovieMapper;
import com.cinema_website.backend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@SuppressWarnings("all")
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    // GET
    public MovieDTO getMovie(int movieId) {
        return movieRepository.getMovieById(movieId);
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository.getAllMovies();
    }


    // INSERT
    public boolean addMovie(MovieDTO movie) {
        return movieRepository.addMovie(movie);
    }


    // UPDATE
    public boolean updateMovie(int movieId, MovieDTO updatedMovie) {
        return movieRepository.updateMovieById(movieId, updatedMovie);
    }


    // DELETE
    public boolean deleteMovie(int movieId) {
        return movieRepository.deleteMovieById(movieId);
    }


}
