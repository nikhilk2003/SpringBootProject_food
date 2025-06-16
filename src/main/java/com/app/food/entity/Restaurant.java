package com.app.food.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String restaurantName;
    private String location;
    private Double averagePrice;
    private String cuisineType;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<FoodItem> menu;

    
    public Restaurant() {} 

    public Restaurant(Long id, String restaurantName, String location, Double averagePrice, String cuisineType,
            List<FoodItem> menu) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.location = location;
        this.averagePrice = averagePrice;
        this.cuisineType = cuisineType;
    }

}
