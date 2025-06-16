package com.app.food.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.food.entity.*;
@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
        // Get restaurants by cuisine type
    @Query("SELECT r FROM Restaurant r WHERE r.cuisineType = ?1")
    List<Restaurant> findByCuisineType(String cuisineType);

    // Get restaurants with average price less than a value
    @Query("SELECT r FROM Restaurant r WHERE r.averagePrice < ?1")
    List<Restaurant> findAffordableRestaurants(Double maxPrice);

}

