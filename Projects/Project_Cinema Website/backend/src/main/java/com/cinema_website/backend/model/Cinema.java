package com.cinema_website.backend.model;

import java.sql.Timestamp;

@SuppressWarnings("all")
public class Cinema {
    private int cinemaId;
    private String name;
    private String address;
    private String city;
    private String cinemaImage;
    private String contactNo;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Cinema() {
    }

    // Constructor
    public Cinema(int cinemaId, String name, String address, String city, String cinemaImage, String contactNo, Timestamp createdAt, Timestamp updatedAt) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.cinemaImage = cinemaImage;
        this.contactNo = contactNo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCinemaImage() {
        return cinemaImage;
    }

    public void setCinemaImage(String cinemaImage) {
        this.cinemaImage = cinemaImage;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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
        return "Cinema{" +
                "cinemaId=" + cinemaId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", cinemaImage='" + cinemaImage + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
