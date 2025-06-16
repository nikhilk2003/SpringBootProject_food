package com.app.food.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.food.entity.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long>{
        // Get orders by customer ID
    @Query("SELECT o FROM OrderDetails o WHERE o.customer.id = ?1")
    List<OrderDetails> findByCustomerId(Long customerId);

    // Get orders by restaurant ID
    @Query("SELECT o FROM OrderDetails o WHERE o.restaurant.id = ?1")
    List<OrderDetails> findByRestaurantId(Long restaurantId);

    // Get orders by food item ID
    @Query("SELECT o FROM OrderDetails o WHERE o.foodItem.id = ?1")
    List<OrderDetails> findByFoodItemId(Long foodItemId);
    
}
