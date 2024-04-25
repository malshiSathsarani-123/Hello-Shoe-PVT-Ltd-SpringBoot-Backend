package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.entity.EmployeeStatus;
import com.example.helloshoepvtltdspringboot.entity.Gender;
import com.example.helloshoepvtltdspringboot.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String code;
    private String name;
    private String profilePic;
    private Gender gender;
    private EmployeeStatus status;
    private String designation ;
    private Role role;
    private LocalDate dob;
    private LocalDate dateOfJoin;
    private String branchName;
    private String address;
    private String contact;
    private String email;
    private String guardianName;
    private String emergencyContact;
}
