package com.app.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.food.Repository.FoodItemRepo;
import com.app.food.entity.FoodItem;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepo foodItemRepo;

    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepo.save(foodItem);
    }

    public FoodItem getFoodItem(Long id) {
        return foodItemRepo.findById(id).orElseThrow(() -> new RuntimeException("FoodItem is not found"));

    }

    public List<FoodItem> getAllFoodItem() {
        return foodItemRepo.findAll();
    }

    public FoodItem updateFoodItem(Long id, FoodItem updatedFoodItem) {
        FoodItem existing = getFoodItem(id);
        existing.setItemName(updatedFoodItem.getItemName());
        existing.setCategory(updatedFoodItem.getCategory());
        existing.setPrice(updatedFoodItem.getPrice());
        return foodItemRepo.save(existing);
    }

    public void deleteFoodItem(Long id) {
        foodItemRepo.deleteById(id);
    }

}
