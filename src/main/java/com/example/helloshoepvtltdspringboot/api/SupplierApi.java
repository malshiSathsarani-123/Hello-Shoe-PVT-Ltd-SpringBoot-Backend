package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;
import com.example.helloshoepvtltdspringboot.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class SupplierApi {
    @Autowired
    private final SupplierService supplierService;

    @PostMapping
    public void saveSupplier(@RequestBody SupplierDTO supplierDTO){
        supplierService.saveSupplier(supplierDTO);
    }

    @PutMapping
    public void updateSupplier(@RequestBody SupplierDTO supplierDTO){
        supplierService.updateSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAllSuppliers(){
        return supplierService.getAllCustomer();
    }
    @DeleteMapping("/{code}")
    public void deleteSupplier(@PathVariable("code") String code){
        supplierService.deleteSupplier(code);
    }
}
