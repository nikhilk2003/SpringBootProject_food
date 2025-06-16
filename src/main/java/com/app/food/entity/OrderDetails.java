package com.app.food.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String details;
    private int quantity;

    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne(mappedBy = "orderDetails", cascade = CascadeType.ALL)
    private Payment payment;

    
    public OrderDetails() {} 

    public OrderDetails(Long id, String details, int quantity, Customer customer, FoodItem foodItem,
            Restaurant restaurant, Payment payment) {
        this.id = id;
        this.details = details;
        this.quantity = quantity;
        this.customer = customer;
        this.foodItem = foodItem;
        this.restaurant = restaurant;
        this.payment = payment;
    }

}