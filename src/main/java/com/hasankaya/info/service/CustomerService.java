package com.hasankaya.info.service;

import com.hasankaya.info.entity.Customer;
import com.hasankaya.info.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Transactional
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
