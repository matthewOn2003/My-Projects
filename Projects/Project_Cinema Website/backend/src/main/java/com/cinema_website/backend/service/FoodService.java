package com.cinema_website.backend.service;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // GET
    public FoodDTO getFood(int foodId) {
        return foodRepository.getFoodById(foodId);
    }

    public List<FoodDTO> getAllFoods() {
        return foodRepository.getAllFoods();
    }

    public List<String> getAllCategories() {
        return foodRepository.getAllCategories();
    }


    // INSERT
    public boolean addFood(FoodDTO food) {
        return foodRepository.addFood(food);
    }

    // UPDATE
    public boolean updateFood(int foodId, FoodDTO updatedFood) {
        return foodRepository.updateFoodById(foodId, updatedFood);
    }

    // DELETE
    public boolean deleteFood(int foodId) {
        return foodRepository.deleteFoodById(foodId);
    }
}
