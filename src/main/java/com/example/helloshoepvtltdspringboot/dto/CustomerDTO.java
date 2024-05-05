package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.Gender;
import com.example.helloshoepvtltdspringboot.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO implements SuperDTO{
    private String code;
    private String name;
    private Gender gender;
    private LocalDate joinDate;
    private Level level;
    private Integer totalPoints;
    private LocalDate dob;
    private String address;
    private String contact;
    private String email;
    private Timestamp recentPurchaseDateAndTime;
}
