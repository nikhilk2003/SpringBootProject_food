package com.app.food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.food.Service.FoodItemService;
import com.app.food.entity.FoodItem;

@RestController
@RequestMapping("/api/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public ResponseEntity<FoodItem> create(@RequestBody FoodItem foodItem) {
        return new ResponseEntity<>(foodItemService.createFoodItem(foodItem), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> get(@PathVariable Long id) {
        return ResponseEntity.ok(foodItemService.getFoodItem(id));
    }

    @GetMapping
    public List<FoodItem> getAll() {
        return foodItemService.getAllFoodItem();
    }

  @PutMapping("/{id}")
public ResponseEntity<FoodItem> update(@PathVariable Long id, @RequestBody FoodItem foodItem) {
    return ResponseEntity.ok(foodItemService.updateFoodItem(id, foodItem));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    foodItemService.deleteFoodItem(id);
    return ResponseEntity.noContent().build();
}

}
