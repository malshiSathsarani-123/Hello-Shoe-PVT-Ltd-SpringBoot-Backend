package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO supplierDTO);

    void updateSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> getAllCustomer();

    void deleteSupplier(String code);
}
