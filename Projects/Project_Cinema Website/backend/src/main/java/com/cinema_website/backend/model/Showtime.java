package com.cinema_website.backend.model;

import java.sql.Timestamp;

@SuppressWarnings("all")
public class Showtime {
    private int showtimeId;
    private int movieId;
    private int cinemaId;
    private int hallId;
    private Timestamp showDate;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Showtime() {
    }

    // Constructor
    public Showtime(int showtimeId, int movieId, int cinemaId, int hallId, Timestamp showDate, Timestamp startTime, Timestamp endTime, Timestamp createdAt, Timestamp updatedAt) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.hallId = hallId;
        this.showDate = showDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public Timestamp getShowDate() {
        return showDate;
    }

    public void setShowDate(Timestamp showDate) {
        this.showDate = showDate;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "showtimeId=" + showtimeId +
                ", movieId=" + movieId +
                ", cinemaId=" + cinemaId +
                ", hallId=" + hallId +
                ", showDate=" + showDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
