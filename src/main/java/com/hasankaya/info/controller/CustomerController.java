package com.hasankaya.info.controller;


import com.hasankaya.info.dto.LoginDTO;
import com.hasankaya.info.dto.RegisterDTO;
import com.hasankaya.info.entity.Customer;
import com.hasankaya.info.repository.CustomerRepository;
import com.hasankaya.info.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @PostMapping("/login")
    public String loginChecker(@RequestBody LoginDTO body){

        Customer c = new Customer();

        try{
            String username = body.getUsername();
            String password = body.getPassword();

            c = customerRepository.findAll().stream()
                    .filter(customer -> customer.getUsername().equals(username) && customer.getPassword().equals(password))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Invalid username or password"));

            return "Login Successful "+c.getId();
        }catch (Exception e){
            return "Error: "+e.getMessage();
        }
    }


    @PostMapping("/register")
    public String Register(@Valid @RequestBody RegisterDTO body){


        Customer c = new Customer();
        c.setUsername(body.getUsername());
        c.setPassword(body.getPassword());
        c.setEmail(body.getEmail());
        c.setPhone(body.getPhone());
        Customer saved = customerRepository.save(c);




        return "Register Successful "+saved.getId();
    }

}
