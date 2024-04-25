package com.example.helloshoepvtltdspringboot.api;

import ch.qos.logback.core.status.StatusBase;
import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;
import com.example.helloshoepvtltdspringboot.entity.EmployeeStatus;
import com.example.helloshoepvtltdspringboot.entity.Gender;
import com.example.helloshoepvtltdspringboot.entity.Role;
import com.example.helloshoepvtltdspringboot.service.EmployeeService;
import com.example.helloshoepvtltdspringboot.util.UtilMatters;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeApi {
    @Autowired
    private final EmployeeService employeeService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void saveEmployee(@RequestPart("name") String name,
                             @RequestPart("profilePic") String profilePic,
                             @RequestPart("gender") String gender,
                             @RequestPart("status") String status,
                             @RequestPart("designation") String designation,
                             @RequestPart("role") String role,
                             @RequestPart("dob") String dob,
                             @RequestPart("dateOfJoin") String dateOfJoin,
                             @RequestPart("branchName") String branchName,
                             @RequestPart("address") String address,
                             @RequestPart("contact") String contact,
                             @RequestPart("email") String email,
                             @RequestPart("guardianName") String guardianName,
                             @RequestPart("emergencyContact") String emergencyContact
    ){

        String base64ProPic = UtilMatters.covertBase64(profilePic);

        Gender gender1 = Gender.valueOf(gender);
        EmployeeStatus status1 = EmployeeStatus.valueOf(status);
        Role role1 = Role.valueOf(role);
        LocalDate dob1 = LocalDate.parse(dob);
        LocalDate dateOfJoin1 = LocalDate.parse(dateOfJoin);

        EmployeeDTO employeeDTO = new EmployeeDTO(name, base64ProPic, gender1, status1, designation, role1, dob1, dateOfJoin1, branchName, address, contact, email, guardianName, emergencyContact);
        employeeService.saveEmployee(employeeDTO);

    }
}
