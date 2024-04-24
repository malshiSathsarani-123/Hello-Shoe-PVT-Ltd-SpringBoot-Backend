package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.entity.Gender;
import com.example.helloshoepvtltdspringboot.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String code;
    private String name;
    private Gender gender;
    private Date joinDate;
    private Level level;
    private Integer totalPoints;
    private Date dob;
    private String address;
    private String contact;
    private String email;
    private Timestamp recentPurchaseDateAndTime;
}
