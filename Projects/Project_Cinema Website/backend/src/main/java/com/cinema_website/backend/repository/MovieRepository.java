package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.MovieDTO;
import com.cinema_website.backend.mapper.MovieMapper;
import com.cinema_website.backend.model.Movie;
import com.cinema_website.backend.util.MovieUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("all")
@Repository
public class MovieRepository {

    private final MovieMapper movieMapper;

    public MovieRepository(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }


    // SELECT
    public MovieDTO getMovieById(int movieId) {
        Movie movie = movieMapper.getMovieById(movieId);
        return MovieUtils.toMovieDTO(movie);
    }

    public List<MovieDTO> getAllMovies() {
        try {
            List<Movie> movies = movieMapper.getAllMovies();

            List<MovieDTO> movieDTOS = new ArrayList<>();;

            for (Movie movie : movies) {
                MovieDTO element = MovieUtils.toMovieDTO(movie);
                movieDTOS.add(element);
            }

            return movieDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }



    // INSERT
    public boolean addMovie(MovieDTO movie) {
        try {
            return movieMapper.addMovie(MovieUtils.toMovie(movie));
        } catch (Exception e) {
            // 记录异常信息
            e.printStackTrace();
            return false; // 返回false表示更新失败
        }
    }


    // UPDATE
    public boolean updateMovieById(int movieId, MovieDTO updatedMovie) {
        try {

            return movieMapper.updateMovieById(movieId, MovieUtils.toMovie(updatedMovie));
        } catch (Exception e) {
            // 记录异常信息
            e.printStackTrace();
            return false; // 返回false表示更新失败
        }
    }


    // DELETE
    public boolean deleteMovieById(int movieId) {
        try {
            return movieMapper.deleteMovieById(movieId);
        } catch (Exception e) {
            // 记录异常信息
            e.printStackTrace();
            return false; // 返回false表示更新失败
        }
    }




}
