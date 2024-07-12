package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class HallDTO {
    private int hallId;
    private int cinemaId;
    private String hallName;
    private String experienceType;
    private String status;
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public HallDTO() {
    }

    // Constructor with all fields
    public HallDTO(int hallId, int cinemaId, String hallName, String experienceType, String status, String createdAt, String updatedAt) {
        this.hallId = hallId;
        this.cinemaId = cinemaId;
        this.hallName = hallName;
        this.experienceType = experienceType;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(String experienceType) {
        this.experienceType = experienceType;
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

    @Override
    public String toString() {
        return "HallDTO{" +
                "hallId=" + hallId +
                ", cinemaId=" + cinemaId +
                ", hallName='" + hallName + '\'' +
                ", experienceType='" + experienceType + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
