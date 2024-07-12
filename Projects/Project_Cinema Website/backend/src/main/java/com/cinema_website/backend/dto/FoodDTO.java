package com.cinema_website.backend.dto;

@SuppressWarnings("all")
public class FoodDTO {
    private int foodId;
    private String foodNumber;
    private String name;
    private String description;
    private String foodImage;
    private String category;
    private String price;
    private String createdAt;
    private String updatedAt;

    // Default Constructor
    public FoodDTO() {
    }

    // Constructor with all fields
    public FoodDTO(int foodId, String foodNumber, String name, String description, String foodImage, String category, String price, String createdAt, String updatedAt) {
        this.foodId = foodId;
        this.foodNumber = foodNumber;
        this.name = name;
        this.description = description;
        this.foodImage = foodImage;
        this.category = category;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(String foodNumber) {
        this.foodNumber = foodNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        return "FoodDTO{" +
                "foodId=" + foodId +
                ", foodNumber='" + foodNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foodImage='" + foodImage + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
