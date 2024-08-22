package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.MovieDTO;
import com.cinema_website.backend.model.Movie;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@SuppressWarnings("all")

public class MovieUtils {

    // Convert Strings to Timestamps
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    // parse Movie to MovieDTO
    public static MovieDTO toMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setGenre(movie.getGenre());

        // Convert duration from minutes to "HH hr MM mins"
        int hours = movie.getDuration() / 60;
        int minutes = movie.getDuration() % 60;
        String formattedDuration = String.format("%d hr %02d mins", hours, minutes);
        movieDTO.setDuration(formattedDuration);

        movieDTO.setLanguage(movie.getLanguage());
        movieDTO.setSubtitle(movie.getSubtitle());
        movieDTO.setPosterImage(movie.getPosterImage());
        movieDTO.setTrailerLink(movie.getTrailerLink());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setSynopsis(movie.getSynopsis());

        // Convert Timestamps to String format (assuming format "yyyy-MM-dd HH:mm:ss")
        if (movie.getReleaseDate() != null) {
            movieDTO.setReleaseDate(dateFormat.format(movie.getReleaseDate()));
        }
        if (movie.getCreatedAt() != null) {
            movieDTO.setCreatedAt(dateFormat.format(movie.getCreatedAt()));
        }
        if (movie.getUpdatedAt() != null) {
            movieDTO.setUpdatedAt(dateFormat.format(movie.getUpdatedAt()));
        }

        return movieDTO;
    }



    // parse MovieDTO to Movie
    public static Movie toMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setMovieId(movieDTO.getMovieId());
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());

        // Convert duration from "HH hr MM mins" to minutes
        String durationString = movieDTO.getDuration();
        if (durationString != null && !durationString.isEmpty()) {
            String[] parts = durationString.split("hr | mins");
            int hours = Integer.parseInt(parts[0].trim());
            int minutes = Integer.parseInt(parts[1].trim());
            int totalMinutes = hours * 60 + minutes;
            movie.setDuration(totalMinutes);
        }

        movie.setLanguage(movieDTO.getLanguage());
        movie.setSubtitle(movieDTO.getSubtitle());
        movie.setPosterImage(movieDTO.getPosterImage());
        movie.setTrailerLink(movieDTO.getTrailerLink());
        movie.setDirector(movieDTO.getDirector());
        movie.setSynopsis(movieDTO.getSynopsis());


        try {
            if (movieDTO.getReleaseDate() != null) {
                movie.setReleaseDate(new Timestamp(dateFormat.parse(movieDTO.getReleaseDate()).getTime()));
            }
            if (movieDTO.getCreatedAt() != null) {
                movie.setCreatedAt(new Timestamp(dateFormat.parse(movieDTO.getCreatedAt()).getTime()));
            }
            if (movieDTO.getUpdatedAt() != null) {
                movie.setUpdatedAt(new Timestamp(dateFormat.parse(movieDTO.getUpdatedAt()).getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return movie;
    }

}
