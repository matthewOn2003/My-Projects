package com.cinema_website.backend.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

@SuppressWarnings("all")
public class Seat {
    private int seatId;
    private int hallId;
    private String seatNumber;
    private String seatRow;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private BigDecimal price;

    // Default Constructor
    public Seat() {
    }

    // Constructor

    public Seat(int seatId, int hallId, String seatNumber, String seatRow, String status, Timestamp createdAt, Timestamp updatedAt, BigDecimal price) {
        this.seatId = seatId;
        this.hallId = hallId;
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
    }


    // Getter and Setter


    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    //

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", hallId=" + hallId +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                '}';
    }
}
