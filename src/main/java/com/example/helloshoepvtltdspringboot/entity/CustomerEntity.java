package com.example.helloshoepvtltdspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
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
