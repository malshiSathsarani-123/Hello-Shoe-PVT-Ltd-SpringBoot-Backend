package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.entity.CustomerEntity;
import com.example.helloshoepvtltdspringboot.repositary.CustomerDao;
import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.service.CustomerService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public String nextCustomerId() {
        String maxId = customerDao.findMaxId();
        if (maxId != null){
            return generateNextCustomerId(maxId);
        }else {
            return "C001";
        }
    }

    private static String generateNextCustomerId(String lastCustomerId) {
        String numericPart = lastCustomerId.substring(1);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "C" + nextNumericPart;
    }
}
