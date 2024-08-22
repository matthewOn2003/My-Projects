package com.cinema_website.backend.dto;


@SuppressWarnings("all")
public class ReviewDTO {
    private int reviewId;
    private UserDTO userDTO;
    private int targetId;
    private String targetTable;
    private String targetName;
    private int rating;
    private String reviewText;
    private String reviewDate;
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public ReviewDTO() {
    }

    // Constructor
    public ReviewDTO(int reviewId, UserDTO userDTO, int targetId, String targetTable, String targetName, int rating, String reviewText, String reviewDate, String createdAt, String updatedAt) {
        this.reviewId = reviewId;
        this.userDTO = userDTO;
        this.targetId = targetId;
        this.targetTable = targetTable;
        this.targetName = targetName;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
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
        return "ReviewDTO{" +
                "reviewId=" + reviewId +
                ", userDTO=" + userDTO +
                ", targetId=" + targetId +
                ", targetTable='" + targetTable + '\'' +
                ", targetName='" + targetName + '\'' +
                ", rating=" + rating +
                ", reviewText='" + reviewText + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
