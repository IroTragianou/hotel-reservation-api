package com.hotelreservation.service;

import com.hotelreservation.entity.Customer;
import com.hotelreservation.exception.ResourceNotFoundException;
import com.hotelreservation.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){
        if (customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalArgumentException("Email already exists.");
        }

        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " was not found."));

    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
