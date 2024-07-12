package com.cinema_website.backend.dto;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class OrderDTO {
//    private int orderId;
    private int orderNumber;
    private int userId;
    private int showtimeId;
    private String transactionDate;
    private String totalAmount;
    private List<FoodDTO> foods; // Nullable
    private List<SeatDTO> seats; // Nullable
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public OrderDTO() {
    }

    // Constructor with all fields
    public OrderDTO(int orderNumber, int userId, int showtimeId, String transactionDate,
                    String totalAmount, List<FoodDTO> foods, List<SeatDTO> seats, String createdAt, String updatedAt) {
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
        this.foods = foods;
        this.seats = seats;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<FoodDTO> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodDTO> foods) {
        this.foods = foods;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
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
        return "OrderDTO{" +
                "  orderNumber=" + orderNumber +
                ", userId=" + userId +
                ", showtimeId=" + showtimeId +
                ", transactionDate='" + transactionDate + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", foods=" + foods.toString() +
                ", seats=" + seats.toString() +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
