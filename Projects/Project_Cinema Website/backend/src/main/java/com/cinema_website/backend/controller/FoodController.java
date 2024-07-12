package com.cinema_website.backend.controller;

import com.cinema_website.backend.dto.FoodDTO;
import com.cinema_website.backend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // GET
    @GetMapping("/getFood/{foodId}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable int foodId) {
        FoodDTO food = foodService.getFood(foodId);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllFoods")
    public ResponseEntity<List<FoodDTO>> getAllFoods() {
        List<FoodDTO> foodList = foodService.getAllFoods();
        if (foodList != null && !foodList.isEmpty()) {
            return new ResponseEntity<>(foodList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = foodService.getAllCategories();
        if (categories != null && !categories.isEmpty()) {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // POST
    @PostMapping("/addFood")
    public ResponseEntity<Boolean> addFood(@RequestBody FoodDTO food) {
        boolean result = foodService.addFood(food);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    // PUT
    @PutMapping("/updateFood/{foodId}")
    public ResponseEntity<Boolean> updateFood(@PathVariable int foodId, @RequestBody FoodDTO updatedFood) {
        boolean result = foodService.updateFood(foodId, updatedFood);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/deleteFood/{foodId}")
    public ResponseEntity<Boolean> deleteFood(@PathVariable int foodId) {
        boolean result = foodService.deleteFood(foodId);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
