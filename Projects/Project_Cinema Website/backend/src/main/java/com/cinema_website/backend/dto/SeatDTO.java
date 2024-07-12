package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class SeatDTO {
    private int seatId;
    private int hallId;
    private String seatNumber;
    private String seatRow;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String price;

    // Default constructor
    public SeatDTO() {

    }

    // Constructor with all fields
    public SeatDTO(int seatId, int hallId, String seatNumber, String seatRow, String status, String createdAt, String updatedAt, String price) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //

    @Override
    public String toString() {
        return "SeatDTO{" +
                "seatId=" + seatId +
                ", hallId=" + hallId +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
