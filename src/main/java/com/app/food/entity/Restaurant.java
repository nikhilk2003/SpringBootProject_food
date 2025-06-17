package com.app.food.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantName;
    private String location;
    private Double averagePrice;
    private String cuisineType;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<FoodItem> menu;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderDetails> orders;

    public Restaurant() {
    }

    public Restaurant(Long id, String restaurantName, String location, Double averagePrice, String cuisineType,
            List<FoodItem> menu, List<OrderDetails> orders) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.location = location;
        this.averagePrice = averagePrice;
        this.cuisineType = cuisineType;
        this.menu = menu;
        this.orders = orders;
    }

}
