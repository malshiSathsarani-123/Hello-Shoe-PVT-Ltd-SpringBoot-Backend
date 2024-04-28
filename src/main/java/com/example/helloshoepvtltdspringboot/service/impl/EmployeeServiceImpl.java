package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.entity.EmployeeEntity;
import com.example.helloshoepvtltdspringboot.exception.NotFoundException;
import com.example.helloshoepvtltdspringboot.repositary.EmployeeDao;
import com.example.helloshoepvtltdspringboot.service.EmployeeService;
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

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapping.toEmployeeDTOList(employeeDao.findAll());
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> tmpEmployee = employeeDao.findById(employeeDTO.getCode());
        if (!tmpEmployee.isPresent())throw new NotFoundException("EMPLOYEE IS NOT FOUND");
        tmpEmployee.get().setName(employeeDTO.getName());
        tmpEmployee.get().setProfilePic(employeeDTO.getProfilePic());
        tmpEmployee.get().setGender(employeeDTO.getGender());
        tmpEmployee.get().setStatus(employeeDTO.getStatus());
        tmpEmployee.get().setDesignation(employeeDTO.getDesignation());
        tmpEmployee.get().setRole(employeeDTO.getRole());
        tmpEmployee.get().setDob(employeeDTO.getDob());
        tmpEmployee.get().setDateOfJoin(employeeDTO.getDateOfJoin());
        tmpEmployee.get().setBranchName(employeeDTO.getBranchName());
        tmpEmployee.get().setAddress(employeeDTO.getAddress());
        tmpEmployee.get().setContact(employeeDTO.getContact());
        tmpEmployee.get().setEmail(employeeDTO.getEmail());
        tmpEmployee.get().setGuardianName(employeeDTO.getGuardianName());
        tmpEmployee.get().setEmergencyContact(employeeDTO.getEmergencyContact());
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
