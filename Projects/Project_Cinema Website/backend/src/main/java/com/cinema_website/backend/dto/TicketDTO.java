package com.cinema_website.backend.dto;


public class TicketDTO {

    private int ticketId;
    private OrderDTO order; // Changed to reference OrderDTO
    private String hallName;
    private String movieTitle;
    private String cinemaName;
    private String showDate;
    private String createdAt; // Changed from Timestamp to String
    private String updatedAt; // Changed from Timestamp to String

    // Default Constructor
    public TicketDTO() {

    }

    // Constructor with all fields
    public TicketDTO(int ticketId, OrderDTO order, String hallName, String movieTitle, String cinemaName, String showDate, String createdAt, String updatedAt) {
        this.ticketId = ticketId;
        this.order = order;
        this.hallName = hallName;
        this.movieTitle = movieTitle;
        this.cinemaName = cinemaName;
        this.showDate = showDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
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
        return "TicketDTO{" +
                "ticketId=" + ticketId +
                ", order=" + order +
                ", hallName='" + hallName + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", showDate='" + showDate + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
