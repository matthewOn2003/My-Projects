package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    boolean addMovie(Movie movie);
    boolean updateMovieById(@Param("movieId") int movieId, @Param("movie") Movie movie);
    boolean deleteMovieById(int movieId);
}
