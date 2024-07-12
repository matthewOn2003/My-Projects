package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class CinemaDTO {

    private int cinemaId;
    private String name;
    private String address;
    private String city;
    private String cinemaImage;
    private String contactNo;
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public CinemaDTO() {
    }

    // Constructor
    public CinemaDTO(int cinemaId, String name, String address, String city, String cinemaImage, String contactNo, String createdAt, String updatedAt) {
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
        return "CinemaDTO{" +
                "cinemaId=" + cinemaId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", cinemaImage='" + cinemaImage + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
