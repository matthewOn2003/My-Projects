package com.cinema_website.backend.mapper;

import com.cinema_website.backend.dto.ShowtimeDTO;
import com.cinema_website.backend.model.Showtime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShowtimeMapper {
    // GET
    Showtime getShowtimeById(int showtimeId);
    List<Showtime> getAllShowtimes();
    List<Showtime> getShowtimesByMovieId(int movieId);
    List<Showtime> getShowtimesByCinemaId(int cinemaId);
    List<Showtime> getShowtimesByHallId(int hallId);
    List<Showtime> getShowtimesByMovieDateExperience(int movieId, String showDate, String experienceType);
    List<String> getShowtimesExperiences(int movieId, String showDate);


    // INSERT
    boolean addShowtime(Showtime showtime);

    // UPDATE
    boolean updateShowtimeById(@Param("showtimeId") int showtimeId, @Param("showtime") Showtime showtime);

    // DELETE
    boolean deleteShowtimeById(int showtimeId);
}
