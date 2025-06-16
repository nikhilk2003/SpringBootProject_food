package com.app.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;
    private String category;
    private Double price;

      @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    
    public FoodItem() {} 

      public FoodItem(Long id, String itemName, String category, Double price, Restaurant restaurant) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.restaurant = restaurant;
      }

}
