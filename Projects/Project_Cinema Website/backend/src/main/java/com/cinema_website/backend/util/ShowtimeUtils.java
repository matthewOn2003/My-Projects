package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.ShowtimeDTO;
import com.cinema_website.backend.model.Showtime;
import com.cinema_website.backend.service.CinemaService;
import com.cinema_website.backend.service.HallService;
import com.cinema_website.backend.service.MovieService;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class ShowtimeUtils {

    // Convert Strings to Timestamps
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static ShowtimeDTO toShowtimeDTO(Showtime showtime, MovieService movieService, CinemaService cinemaService, HallService hallService) {
        ShowtimeDTO showtimeDTO = new ShowtimeDTO();
        showtimeDTO.setShowtimeId(showtime.getShowtimeId());
        showtimeDTO.setMovie(movieService.getMovie(showtime.getMovieId()));
        showtimeDTO.setCinema(cinemaService.getCinema(showtime.getCinemaId()));
        showtimeDTO.setHall(hallService.getHall(showtime.getHallId()));

        if (showtime.getShowDate() != null) {
            showtimeDTO.setShowDate(showtime.getShowDate().toLocalDateTime().format(dateTimeFormatter));
        }
        if (showtime.getStartTime() != null) {
            showtimeDTO.setStartTime(showtime.getStartTime().toLocalDateTime().format(dateTimeFormatter));
        }
        if (showtime.getEndTime() != null) {
            showtimeDTO.setEndTime(showtime.getEndTime().toLocalDateTime().format(dateTimeFormatter));
        }

        if (showtime.getCreatedAt() != null) {
            showtimeDTO.setCreatedAt(showtime.getCreatedAt().toLocalDateTime().format(dateTimeFormatter));
        }
        if (showtime.getUpdatedAt() != null) {
            showtimeDTO.setUpdatedAt(showtime.getUpdatedAt().toLocalDateTime().format(dateTimeFormatter));
        }

        return showtimeDTO;
    }

    public static Showtime toShowtime(ShowtimeDTO showtimeDTO) {
        Showtime showtime = new Showtime();
        showtime.setShowtimeId(showtimeDTO.getShowtimeId());
        showtime.setMovieId(showtimeDTO.getMovie().getMovieId());
        showtime.setCinemaId(showtimeDTO.getCinema().getCinemaId());
        showtime.setHallId(showtimeDTO.getHall().getHallId());

        try {
            if (showtimeDTO.getShowDate() != null) {
                showtime.setShowDate(Timestamp.valueOf(showtimeDTO.getShowDate()));
            }
            if (showtimeDTO.getStartTime() != null) {
                showtime.setStartTime(Timestamp.valueOf(showtimeDTO.getStartTime()));
            }
            if (showtimeDTO.getEndTime() != null) {
                showtime.setEndTime(Timestamp.valueOf(showtimeDTO.getEndTime()));
            }
            if (showtimeDTO.getCreatedAt() != null) {
                showtime.setCreatedAt(Timestamp.valueOf(showtimeDTO.getCreatedAt()));
            }
            if (showtimeDTO.getUpdatedAt() != null) {
                showtime.setUpdatedAt(Timestamp.valueOf(showtimeDTO.getUpdatedAt()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return showtime;
    }
}
