package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.entity.CustomerEntity;
import com.example.helloshoepvtltdspringboot.exception.NotFoundException;
import com.example.helloshoepvtltdspringboot.repositary.CustomerDao;
import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.service.CustomerService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private final CustomerDao customerDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCode(nextCustomerId());
        mapping.toCustomerDTO(customerDao.save(mapping.toCustomer(customerDTO)));
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.toCustomerDTOList(customerDao.findAll());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customerDTO.getCode());
        if (!tmpCustomer.isPresent())throw new NotFoundException("CUSTOMER NOT FOUND");
        tmpCustomer.get().setName(customerDTO.getName());
        tmpCustomer.get().setGender(customerDTO.getGender());
        tmpCustomer.get().setJoinDate(customerDTO.getJoinDate());
        tmpCustomer.get().setLevel(customerDTO.getLevel());
        tmpCustomer.get().setTotalPoints(customerDTO.getTotalPoints());
        tmpCustomer.get().setDob(customerDTO.getDob());
        tmpCustomer.get().setAddress(customerDTO.getAddress());
        tmpCustomer.get().setContact(customerDTO.getContact());
        tmpCustomer.get().setEmail(customerDTO.getEmail());
        tmpCustomer.get().setRecentPurchaseDateAndTime(customerDTO.getRecentPurchaseDateAndTime());

    }

    @Override
    public void deleteCustomer(String code) {
        customerDao.deleteById(code);
    }

    public String nextCustomerId() {
        String maxId = customerDao.findMaxId();
        if (maxId != null){
            return generateNextCustomerId(maxId);
        }else {
            return "C-001";
        }
    }

    private static String generateNextCustomerId(String lastCustomerId) {
        String numericPart = lastCustomerId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "C-" + nextNumericPart;
    }
}
