package com.cinema_website.backend.model;

import java.sql.Timestamp;

public class Ticket {

    private int ticketId;
    private int referenceNo;
    private String hallName;
    private String movieTitle;
    private String cinemaName;
    private Timestamp createdAt;
    private Timestamp updatedAt;


    // Default Constructor
    public Ticket() {
    }


    // Constructor with all fields
    public Ticket(int ticketId, int referenceNo, String hallName, String movieTitle, String cinemaName, Timestamp createdAt, Timestamp updatedAt) {
        this.ticketId = ticketId;
        this.referenceNo = referenceNo;
        this.hallName = hallName;
        this.movieTitle = movieTitle;
        this.cinemaName = cinemaName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(int referenceNo) {
        this.referenceNo = referenceNo;
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
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", referenceNo=" + referenceNo +
                ", hallName='" + hallName + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
