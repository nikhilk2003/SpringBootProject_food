package com.app.food.Service;

import com.app.food.Repository.RestaurantRepo;
import com.app.food.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepo.findAll();
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        Restaurant existing = getRestaurant(id);

        existing.setRestaurantName(updatedRestaurant.getRestaurantName());
        existing.setLocation(updatedRestaurant.getLocation());
        existing.setAveragePrice(updatedRestaurant.getAveragePrice());
        existing.setCuisineType(updatedRestaurant.getCuisineType());

        return restaurantRepo.save(existing);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteById(id);
    }
}
