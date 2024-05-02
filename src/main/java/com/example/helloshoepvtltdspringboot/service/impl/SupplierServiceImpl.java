package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;
import com.example.helloshoepvtltdspringboot.entity.SupplierEntity;
import com.example.helloshoepvtltdspringboot.exception.NotFoundException;
import com.example.helloshoepvtltdspringboot.repositary.SupplierDao;
import com.example.helloshoepvtltdspringboot.service.SupplierService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void updateSupplier(SupplierDTO supplierDTO) {
        Optional<SupplierEntity> tmpSupplier = supplierDao.findById(supplierDTO.getCode());
        if (!tmpSupplier.isPresent())throw new NotFoundException("SUPPLIER NOT FOUND");
        tmpSupplier.get().setName(supplierDTO.getName());
        tmpSupplier.get().setCategory(supplierDTO.getCategory());
        tmpSupplier.get().setAddress(supplierDTO.getAddress());
        tmpSupplier.get().setContact1(supplierDTO.getContact1());
        tmpSupplier.get().setContact2(supplierDTO.getContact2());
        tmpSupplier.get().setEmail(supplierDTO.getEmail());
    }

    @Override
    public List<SupplierDTO> getAllCustomer(){
        List<SupplierEntity> supplierEntities = supplierDao.findAll();
        return supplierEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private SupplierDTO convertToDTO(SupplierEntity supplierEntity) {
        return new SupplierDTO(
                supplierEntity.getCode(),
                supplierEntity.getName(),
                supplierEntity.getCategory(),
                supplierEntity.getAddress(),
                supplierEntity.getContact1(),
                supplierEntity.getContact2(),
                supplierEntity.getEmail()
        );
    }
    @Override
    public void deleteSupplier(String code) {
        supplierDao.deleteById(code);
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
        String numericPart = lastSupplierId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "S-" + nextNumericPart;
    }
}
