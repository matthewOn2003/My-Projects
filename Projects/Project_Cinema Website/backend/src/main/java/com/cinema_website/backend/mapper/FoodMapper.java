package com.cinema_website.backend.mapper;

import com.cinema_website.backend.model.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FoodMapper {
    Food getFoodById(int foodId);
    List<Food> getAllFoods();
    List<String> getAllCategories();
    boolean addFood(Food food);
    boolean updateFoodById(@Param("foodId") int foodId, @Param("food") Food food);
    boolean deleteFoodById(int foodId);
}
