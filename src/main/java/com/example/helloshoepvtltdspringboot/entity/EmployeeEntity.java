package com.example.helloshoepvtltdspringboot.entity;

import com.example.helloshoepvtltdspringboot.enums.EmployeeStatus;
import com.example.helloshoepvtltdspringboot.enums.Gender;
import com.example.helloshoepvtltdspringboot.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity implements SuperEntity{
    @Id
    private String code;
    private String name;
    @Column(columnDefinition = "LONGTEXT")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userCode")
    private UserEntity userEntity;
}
