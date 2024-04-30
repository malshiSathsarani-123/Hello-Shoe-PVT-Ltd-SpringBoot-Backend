package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.enums.EmployeeStatus;
import com.example.helloshoepvtltdspringboot.enums.Gender;
import com.example.helloshoepvtltdspringboot.enums.Role;
import com.example.helloshoepvtltdspringboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
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


        Gender gender1 = Gender.valueOf(gender);
        EmployeeStatus status1 = EmployeeStatus.valueOf(status);
        Role role1 = Role.valueOf(role);
        LocalDate dob1 = LocalDate.parse(dob);
        LocalDate dateOfJoin1 = LocalDate.parse(dateOfJoin);

        EmployeeDTO employeeDTO = new EmployeeDTO(name, profilePic, gender1, status1, designation, role1, dob1, dateOfJoin1, branchName, address, contact, email, guardianName, emergencyContact);
        employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateEmployee(@RequestPart("code") String code,
                               @RequestPart("name") String name,
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
                             @RequestPart("emergencyContact") String emergencyContact){

        Gender gender1 = Gender.valueOf(gender);
        EmployeeStatus status1 = EmployeeStatus.valueOf(status);
        Role role1 = Role.valueOf(role);
        LocalDate dob1 = LocalDate.parse(dob);
        LocalDate dateOfJoin1 = LocalDate.parse(dateOfJoin);

        EmployeeDTO employeeDTO = new EmployeeDTO(code,name, profilePic, gender1, status1, designation, role1, dob1, dateOfJoin1, branchName, address, contact, email, guardianName, emergencyContact);
        employeeService.updateEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/{code}")
    public void deleteMapping(@PathVariable("code") String code){
        employeeService.deleteEmployee(code);
    }
}
