package com.app.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String paymentMethod;
    private String paymentStatus;
    private String orderDetail; // Assuming this is a description field (not entity)

    @OneToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;

    
    public Payment() {} 

    public Payment(Long id, String paymentMethod, String paymentStatus, String orderDetail, OrderDetails orderDetails) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.orderDetail = orderDetail;
        this.orderDetails = orderDetails;
    }

}
