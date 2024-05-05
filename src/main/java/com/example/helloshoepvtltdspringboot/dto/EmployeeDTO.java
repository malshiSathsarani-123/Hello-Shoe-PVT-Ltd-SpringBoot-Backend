package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.EmployeeStatus;
import com.example.helloshoepvtltdspringboot.enums.Gender;
import com.example.helloshoepvtltdspringboot.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO implements SuperDTO{
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

    public EmployeeDTO(String name, String profilePic, Gender gender, EmployeeStatus status, String designation, Role role, LocalDate dob, LocalDate dateOfJoin, String branchName, String address, String contact, String email, String guardianName, String emergencyContact) {
        this.name = name;
        this.profilePic = profilePic;
        this.gender = gender;
        this.status = status;
        this.designation = designation;
        this.role = role;
        this.dob = dob;
        this.dateOfJoin = dateOfJoin;
        this.branchName = branchName;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.guardianName = guardianName;
        this.emergencyContact = emergencyContact;
    }
}
