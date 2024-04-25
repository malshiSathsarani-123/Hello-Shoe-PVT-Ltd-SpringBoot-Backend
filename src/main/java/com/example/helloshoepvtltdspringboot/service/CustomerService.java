package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomer();
}
