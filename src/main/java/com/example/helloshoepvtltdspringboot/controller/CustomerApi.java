package com.example.helloshoepvtltdspringboot.controller;

import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class CustomerApi {

    @Autowired
    private final CustomerService customerService;
    @GetMapping
    public String getCustomer(){
        return "heee";
    }

    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }
}
