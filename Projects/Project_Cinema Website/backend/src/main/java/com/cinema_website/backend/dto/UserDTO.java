package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class UserDTO {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String role;
    private String status;
    private String profilePicture;
    private String phoneNumber;
    private String birthDate;
    private String lastLogin;
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public UserDTO() {
    }

    // Constructor
    public UserDTO(int userId, String username, String email, String password, String fullName, String role, String status,
                   String profilePicture, String phoneNumber, String birthDate, String lastLogin,
                   String createdAt, String updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.status = status;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
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
        return "UserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
