package com.app.food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.food.Service.OrderDetailsService;
import com.app.food.entity.OrderDetails;

@RestController
@RequestMapping("/api/orders")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    // Create new order
    @PostMapping
    public ResponseEntity<OrderDetails> create(@RequestBody OrderDetails orderDetails) {
        return new ResponseEntity<>(orderDetailsService.createOrderDetails(orderDetails), HttpStatus.CREATED);
    }

    // Get single order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> get(@PathVariable Long id) {
        return ResponseEntity.ok(orderDetailsService.getOrderDetails(id));
    }

    // Get all orders (non-paginated)
    @GetMapping
    public List<OrderDetails> getAll() {
        return orderDetailsService.getAllOrderDetails();
    }

    // Update order
    @PutMapping("/{id}")
    public ResponseEntity<OrderDetails> update(@PathVariable Long id, @RequestBody OrderDetails orderDetails) {
        return ResponseEntity.ok(orderDetailsService.updateOrderDetails(id, orderDetails));
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderDetailsService.deleteOrderDetails(id);
        return ResponseEntity.noContent().build();
    }

    // Get paginated and sorted orders
    @GetMapping("/paged")
    public Page<OrderDetails> getPagedOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        String sortBy = sort[0];
        String direction = sort.length > 1 ? sort[1] : "asc";

        Pageable pageable = PageRequest.of(
            page,
            size,
            direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()
        );

        return orderDetailsService.getPagedOrders(pageable);
    }
}
