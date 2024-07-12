package com.cinema_website.backend.dto;

import com.cinema_website.backend.model.Cinema;
import com.cinema_website.backend.model.Hall;
import com.cinema_website.backend.model.Movie;

@SuppressWarnings("all")
public class ShowtimeDTO {
    private int showtimeId;
    private MovieDTO movie;
    private CinemaDTO cinema;
    private HallDTO hall;
//    private int movieId;
//    private int cinemaId;
//    private int hallId;
    private String showDate;
    private String startTime;
    private String endTime;
    private String createdAt;
    private String updatedAt;


    // Default Constructor
    public ShowtimeDTO() {

    }

    // Constructor with all fields

    public ShowtimeDTO(int showtimeId, MovieDTO movie, CinemaDTO cinema, HallDTO hall, String showDate, String startTime, String endTime, String createdAt, String updatedAt) {
        this.showtimeId = showtimeId;
        this.movie = movie;
        this.cinema = cinema;
        this.hall = hall;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    // Getter and Setter
    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public CinemaDTO getCinema() {
        return cinema;
    }

    public void setCinema(CinemaDTO cinema) {
        this.cinema = cinema;
    }

    public HallDTO getHall() {
        return hall;
    }

    public void setHall(HallDTO hall) {
        this.hall = hall;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "ShowtimeDTO{" +
                "showtimeId=" + showtimeId +
                ", movie=" + movie +
                ", cinema=" + cinema +
                ", hall=" + hall +
                ", showDate='" + showDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
