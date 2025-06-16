package com.app.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.food.Repository.CustomerRepo;
import com.app.food.Repository.FoodItemRepo;
import com.app.food.Repository.OrderDetailsRepo;
import com.app.food.Repository.PaymentRepo;
import com.app.food.Repository.RestaurantRepo;
import com.app.food.entity.OrderDetails;
import com.app.food.entity.Payment;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    public OrderDetails createOrderDetails(OrderDetails orderDetails) {
        try {
            Long customerId = orderDetails.getCustomer().getId();
            Long foodItemId = orderDetails.getFoodItem().getId();
            Long restaurantId = orderDetails.getRestaurant().getId();

            orderDetails.setCustomer(customerRepo.findById(customerId)
                    .orElseThrow(() -> new RuntimeException("Customer not found")));
            orderDetails.setFoodItem(foodItemRepo.findById(foodItemId)
                    .orElseThrow(() -> new RuntimeException("FoodItem not found")));
            orderDetails.setRestaurant(restaurantRepo.findById(restaurantId)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found")));

            Payment payment = orderDetails.getPayment();
            orderDetails.setPayment(null);

            OrderDetails savedOrder = orderDetailsRepo.save(orderDetails);

            if (payment != null) {
                payment.setOrderDetails(savedOrder);
                paymentRepo.save(payment);
                savedOrder.setPayment(payment);
            }

            return savedOrder;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create order: " + e.getMessage());
        }
    }

    public OrderDetails getOrderDetails(Long id) {
        return orderDetailsRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetails not found"));
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepo.findAll();
    }

    public Page<OrderDetails> getPagedOrders(Pageable pageable) {
        return orderDetailsRepo.findAll(pageable);
    }

    public OrderDetails updateOrderDetails(Long id, OrderDetails updatedOrderDetails) {
        OrderDetails existing = getOrderDetails(id);
        existing.setDetails(updatedOrderDetails.getDetails());
        existing.setQuantity(updatedOrderDetails.getQuantity());
        return orderDetailsRepo.save(existing);
    }

    public void deleteOrderDetails(Long id) {
        orderDetailsRepo.deleteById(id);
    }
}
