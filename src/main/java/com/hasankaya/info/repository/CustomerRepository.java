package com.hasankaya.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hasankaya.info.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
