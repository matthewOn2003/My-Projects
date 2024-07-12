package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.ShowtimeDTO;
import com.cinema_website.backend.mapper.ShowtimeMapper;
import com.cinema_website.backend.model.Showtime;
import com.cinema_website.backend.service.CinemaService;
import com.cinema_website.backend.service.HallService;
import com.cinema_website.backend.service.MovieService;
import com.cinema_website.backend.util.ShowtimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowtimeRepository {

    private final ShowtimeMapper showtimeMapper;
    private final MovieService movieService;
    private final CinemaService cinemaService;
    private final HallService hallService;

    @Autowired
    public ShowtimeRepository(ShowtimeMapper showtimeMapper, MovieService movieService, CinemaService cinemaService, HallService hallService) {
        this.showtimeMapper = showtimeMapper;
        this.movieService = movieService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }

    // SELECT
    public ShowtimeDTO getShowtimeById(int showtimeId) {
        Showtime showtime = showtimeMapper.getShowtimeById(showtimeId);
        return ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
    }

    public List<ShowtimeDTO> getAllShowtimes() {
        try {
            List<Showtime> showtimes = showtimeMapper.getAllShowtimes();
            List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();

            for (Showtime showtime : showtimes) {
                ShowtimeDTO dto = ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
                showtimeDTOs.add(dto);
            }

            return showtimeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShowtimeDTO> getShowtimesByMovieId(int movieId) {
        try {
            List<Showtime> showtimes = showtimeMapper.getShowtimesByMovieId(movieId);
            List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();

            for (Showtime showtime : showtimes) {
                ShowtimeDTO dto = ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
                showtimeDTOs.add(dto);
            }

            return showtimeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShowtimeDTO> getShowtimesByCinemaId(int cinemaId) {
        try {
            List<Showtime> showtimes = showtimeMapper.getShowtimesByCinemaId(cinemaId);
            List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();

            for (Showtime showtime : showtimes) {
                ShowtimeDTO dto = ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
                showtimeDTOs.add(dto);
            }

            return showtimeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShowtimeDTO> getShowtimesByHallId(int hallId) {
        try {
            List<Showtime> showtimes = showtimeMapper.getShowtimesByHallId(hallId);
            List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();

            for (Showtime showtime : showtimes) {
                ShowtimeDTO dto = ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
                showtimeDTOs.add(dto);
            }
            return showtimeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShowtimeDTO> getShowtimesByMovieDateExperience(int movieId, String showDate, String experienceType) {
        try {
            List<Showtime> showtimes = showtimeMapper.getShowtimesByMovieDateExperience(movieId, showDate, experienceType);
            List<ShowtimeDTO> showtimeDTOs = new ArrayList<>();

            for (Showtime showtime : showtimes) {
                ShowtimeDTO dto = ShowtimeUtils.toShowtimeDTO(showtime, movieService, cinemaService, hallService);
                showtimeDTOs.add(dto);
            }

            return showtimeDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getShowtimesExperiences(int movieId, String showDate) {
        try {
            List<String> showtimes = showtimeMapper.getShowtimesExperiences(movieId, showDate);
            List<String> showtimeExperiences = new ArrayList<>();

            for (String experience : showtimes) {
                showtimeExperiences.add(experience);
            }

            return showtimeExperiences;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // INSERT
    public boolean addShowtime(ShowtimeDTO showtimeDTO) {
        try {
            Showtime showtime = ShowtimeUtils.toShowtime(showtimeDTO);
            return showtimeMapper.addShowtime(showtime);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates insertion failure
        }
    }

    // UPDATE
    public boolean updateShowtimeById(int showtimeId, ShowtimeDTO updatedShowtime) {
        try {
            Showtime showtime = ShowtimeUtils.toShowtime(updatedShowtime);
            return showtimeMapper.updateShowtimeById(showtimeId, showtime);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates update failure
        }
    }

    // DELETE
    public boolean deleteShowtimeById(int showtimeId) {
        try {
            return showtimeMapper.deleteShowtimeById(showtimeId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates deletion failure
        }
    }
}
