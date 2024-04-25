package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.repositary.EmployeeDao;
import com.example.helloshoepvtltdspringboot.service.EmployeeService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeDao employeeDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setCode(nextEmployeeId());
        mapping.toEmployeeDTO(employeeDao.save(mapping.toEmployee(employeeDTO)));
    }

    public String nextEmployeeId() {
        String maxId = employeeDao.findMaxId();
        if (maxId != null){
            return generateNextEmployeeId(maxId);
        }else {
            return "E-001";
        }
    }

    private static String generateNextEmployeeId(String lastEmployeeId) {
        String numericPart = lastEmployeeId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        System.out.println(nextNumericPart);
        return "E-" + nextNumericPart;
    }
}
