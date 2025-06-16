package com.app.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.food.entity.FoodItem;
@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long>{
    
    // Get food items by category
    @Query("SELECT f FROM FoodItem f WHERE f.category = ?1")
    List<FoodItem> findByCategory(String category);

    // Get food items by restaurant ID
    @Query("SELECT f FROM FoodItem f WHERE f.restaurant.id = ?1")
    List<FoodItem> findByRestaurantId(Long restaurantId);
    
}
