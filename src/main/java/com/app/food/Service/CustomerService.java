package com.app.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.food.Repository.CustomerRepo;
import com.app.food.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
    return customerRepo.save(customer);
}


    public Customer getCustomer(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existing = getCustomer(id);
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
        return customerRepo.save(existing);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
}
