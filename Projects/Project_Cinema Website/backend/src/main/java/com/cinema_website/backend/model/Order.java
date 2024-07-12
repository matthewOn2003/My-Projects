package com.cinema_website.backend.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order {
    private int orderId;
    private int orderNumber;
    private int userId;
    private int showtimeId;
    private Timestamp transactionDate;
    private BigDecimal totalAmount;
    private int foodId; // Nullable
    private int seatId; // Nullable
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Order() {
    }

    // Constructor with all fields
    public Order(int orderId, int orderNumber, int userId, int showtimeId, Timestamp transactionDate,
                 BigDecimal totalAmount, int foodId, int seatId, Timestamp createdAt, Timestamp updatedAt) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.showtimeId = showtimeId;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
        this.foodId = foodId;
        this.seatId = seatId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
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
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber=" + orderNumber +
                ", userId=" + userId +
                ", showtimeId=" + showtimeId +
                ", transactionDate=" + transactionDate +
                ", totalAmount=" + totalAmount +
                ", foodId=" + foodId +
                ", seatId=" + seatId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
