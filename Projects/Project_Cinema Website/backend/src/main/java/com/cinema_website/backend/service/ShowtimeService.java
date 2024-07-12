package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.ShowtimeDTO;
import com.cinema_website.backend.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("all")
@Service
public class ShowtimeService {

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    // GET
    public ShowtimeDTO getShowtime(int showtimeId) {
        return showtimeRepository.getShowtimeById(showtimeId);
    }

    public List<ShowtimeDTO> getAllShowtimes() {
        return showtimeRepository.getAllShowtimes();
    }

    public List<ShowtimeDTO> getShowtimesByMovieId(int movieId) {
        return showtimeRepository.getShowtimesByMovieId(movieId);
    }

    public List<ShowtimeDTO> getShowtimesByCinemaId(int cinemaId) {
        return showtimeRepository.getShowtimesByCinemaId(cinemaId);
    }

    public List<ShowtimeDTO> getShowtimesByHallId(int hallId) {
        return showtimeRepository.getShowtimesByHallId(hallId);
    }

    public List<ShowtimeDTO> getShowtimesByMovieDateExperience(int movieId, String showDate, String experienceType) {
        return showtimeRepository.getShowtimesByMovieDateExperience(movieId, showDate, experienceType);
    }

    public List<String> getShowtimesExperiences(int movieId, String showDate) {
        return showtimeRepository.getShowtimesExperiences(movieId, showDate);
    }



    // INSERT
    public boolean addShowtime(ShowtimeDTO showtimeDTO) {
        return showtimeRepository.addShowtime(showtimeDTO);
    }

    // UPDATE
    public boolean updateShowtime(int showtimeId, ShowtimeDTO updatedShowtime) {
        return showtimeRepository.updateShowtimeById(showtimeId, updatedShowtime);
    }

    // DELETE
    public boolean deleteShowtime(int showtimeId) {
        return showtimeRepository.deleteShowtimeById(showtimeId);
    }
}
