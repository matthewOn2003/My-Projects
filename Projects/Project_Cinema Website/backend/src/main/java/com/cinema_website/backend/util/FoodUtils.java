package com.cinema_website.backend.util;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.model.Food;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class FoodUtils {

    // Convert Strings to Timestamps
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static FoodDTO toFoodDTO(Food food) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setFoodId(food.getFoodId());
        foodDTO.setFoodNumber(food.getFoodNumber());
        foodDTO.setName(food.getName());
        foodDTO.setDescription(food.getDescription());
        foodDTO.setFoodImage(food.getFoodImage());
        foodDTO.setCategory(food.getCategory());
        foodDTO.setPrice(String.valueOf(food.getPrice()));

        if (food.getCreatedAt() != null) {
            foodDTO.setCreatedAt(food.getCreatedAt().toLocalDateTime().format(dateTimeFormatter));
        }
        if (food.getUpdatedAt() != null) {
            foodDTO.setUpdatedAt(food.getUpdatedAt().toLocalDateTime().format(dateTimeFormatter));
        }

        return foodDTO;
    }

    public static Food toFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setFoodId(foodDTO.getFoodId());
        food.setFoodNumber(foodDTO.getFoodNumber());
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setFoodImage(foodDTO.getFoodImage());
        food.setCategory(foodDTO.getCategory());
        food.setPrice(new java.math.BigDecimal(foodDTO.getPrice()));

        try {
            if (foodDTO.getCreatedAt() != null) {
                food.setCreatedAt(Timestamp.valueOf(foodDTO.getCreatedAt()));
            }
            if (foodDTO.getUpdatedAt() != null) {
                food.setUpdatedAt(Timestamp.valueOf(foodDTO.getUpdatedAt()));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception properly in real scenarios
        }

        return food;
    }
}
