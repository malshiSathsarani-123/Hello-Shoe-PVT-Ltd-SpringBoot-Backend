package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class CustomerApi {
    @Autowired
    private final CustomerService customerService;

    @GetMapping
    List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }
    @PostMapping
    public void saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }
    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
    }
    @DeleteMapping(value = "/{code}")
    public void deleteCustomer(@PathVariable("code") String code){
        customerService.deleteCustomer(code);
    }

}
