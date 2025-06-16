package com.app.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.food.entity.*;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
        // Get payment by order ID
    @Query("SELECT p FROM Payment p WHERE p.orderDetails.id = ?1")
    Payment findByOrderId(Long orderId);

    // Get all successful payments
    @Query("SELECT p FROM Payment p WHERE p.paymentStatus = 'SUCCESS'")
    java.util.List<Payment> findSuccessfulPayments();

    
} 
