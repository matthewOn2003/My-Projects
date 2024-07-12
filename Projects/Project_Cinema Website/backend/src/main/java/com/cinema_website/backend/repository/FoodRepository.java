package com.cinema_website.backend.repository;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.mapper.FoodMapper;
import com.cinema_website.backend.model.Food;
import com.cinema_website.backend.util.FoodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    private final FoodMapper foodMapper;

    @Autowired
    public FoodRepository(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    // SELECT
    public FoodDTO getFoodById(int foodId) {
        Food food = foodMapper.getFoodById(foodId);
        return FoodUtils.toFoodDTO(food);
    }

    public List<FoodDTO> getAllFoods() {
        try {
            List<Food> foods = foodMapper.getAllFoods();
            List<FoodDTO> foodDTOs = new ArrayList<>();

            for (Food food : foods) {
                FoodDTO dto = FoodUtils.toFoodDTO(food);
                foodDTOs.add(dto);
            }

            return foodDTOs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAllCategories() {
        return foodMapper.getAllCategories();
    }


    // INSERT
    public boolean addFood(FoodDTO foodDTO) {
        try {
            Food food = FoodUtils.toFood(foodDTO);
            return foodMapper.addFood(food);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates insertion failure
        }
    }

    // UPDATE
    public boolean updateFoodById(int foodId, FoodDTO updatedFood) {
        try {
            Food food = FoodUtils.toFood(updatedFood);
            return foodMapper.updateFoodById(foodId, food);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates update failure
        }
    }

    // DELETE
    public boolean deleteFoodById(int foodId) {
        try {
            return foodMapper.deleteFoodById(foodId);
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false indicates deletion failure
        }
    }
}
