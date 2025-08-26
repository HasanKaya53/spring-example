package com.hasankaya.info.controller;


import com.hasankaya.info.dto.LoginDTO;
import com.hasankaya.info.dto.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Customer {

    @PostMapping("/login")
    public String loginChecker(@RequestBody LoginDTO body){

        try{
            String username = body.getUsername();
            String password = body.getPassword();

            if(username.equals("hasan")  && password.equals("1234")){
                return "Login Successful";
            }else{
                return "Login Failed ";
            }
        }catch (Exception e){
            return "Error: "+e.getMessage();
        }
    }


    @PostMapping("/register")
    public String Register(@Valid @RequestBody RegisterDTO body){

        String username = body.getUsername();
        String password = body.getPassword();
        String email = body.getEmail();
        String phone = body.getPhone();




        return "Register Successful";
    }

}
