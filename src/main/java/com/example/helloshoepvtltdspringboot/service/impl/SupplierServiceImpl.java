package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;
import com.example.helloshoepvtltdspringboot.repositary.SupplierDao;
import com.example.helloshoepvtltdspringboot.service.SupplierService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private final SupplierDao supplierDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void saveSupplier(SupplierDTO supplierDTO) {
        supplierDTO.setCode(nextSupplierId());
        mapping.toCSupplierDTO(supplierDao.save(mapping.toSupplier(supplierDTO)));
    }

    public String nextSupplierId() {
        String maxId = supplierDao.findMaxId();
        if (maxId != null){
            return generateNextSupplierId(maxId);
        }else {
            return "S-001";
        }
    }

    private static String generateNextSupplierId(String lastSupplierId) {
        String numericPart = lastSupplierId.substring(1);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "S-" + nextNumericPart;
    }
}
