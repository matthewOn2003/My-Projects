package com.cinema_website.backend.model;

import java.sql.Date;
import java.sql.Timestamp;

@SuppressWarnings("all")
public class Review {
    private int reviewId;
    private int userId;
    private int targetId;
    private String targetTable;
    private String targetName;
    private int rating;
    private String reviewText;
    private Timestamp reviewDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Review() {
    }

    // Constructor
    public Review(int reviewId, int userId, int targetId, String targetTable, String targetName, int rating, String reviewText, Timestamp reviewDate, Timestamp createdAt, Timestamp updatedAt) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.targetId = targetId;
        this.targetTable = targetTable;
        this.targetName = targetName;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewDate= reviewDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }


    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
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
        return "Review{" +
                "reviewId=" + reviewId +
                ", userId=" + userId +
                ", targetId=" + targetId +
                ", targetTable='" + targetTable + '\'' +
                ", targetName='" + targetName + '\'' +
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate=" + reviewDate+
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
