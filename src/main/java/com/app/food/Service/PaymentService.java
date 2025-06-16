package com.app.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.food.Repository.PaymentRepo;
import com.app.food.entity.Payment;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Payment getPayment(Long id){
        return paymentRepo.findById(id).orElseThrow(()-> new RuntimeException("Payment not found"));
    }

    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }

    public Payment updatePayment(Long id, Payment updatedPayment){
        Payment existing = getPayment(id);
        existing.setPaymentMethod(updatedPayment.getPaymentMethod());
        existing.setPaymentStatus(updatedPayment.getPaymentStatus());
        existing.setOrderDetail(updatedPayment.getOrderDetail());
        return paymentRepo.save(existing);
    }

    public void deletePayment(Long id){
        paymentRepo.deleteById(id);
    }
}
