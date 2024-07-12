package com.cinema_website.backend.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

@SuppressWarnings("all")
public class Food {
    private int foodId;
    private String foodNumber;
    private String name;
    private String description;
    private String foodImage;
    private String category;
    private BigDecimal price;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Default Constructor
    public Food() {
    }

    // Constructor
    public Food(int foodId, String foodNumber, String name, String description, String foodImage, String category, BigDecimal price, Timestamp createdAt, Timestamp updatedAt) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
        return "Food{" +
                "foodId=" + foodId +
                ", foodNumber='" + foodNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", foodImage='" + foodImage + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
