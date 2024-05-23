package com.example.helloshoepvtltdspringboot.entity;

import com.example.helloshoepvtltdspringboot.enums.Gender;
import com.example.helloshoepvtltdspringboot.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity{
    @Id
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

    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntities;

    public CustomerEntity(String code, String name, Gender gender, LocalDate joinDate, Level level, Integer totalPoints, LocalDate dob, String address, String contact, String email, Timestamp recentPurchaseDateAndTime) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.joinDate = joinDate;
        this.level = level;
        this.totalPoints = totalPoints;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.recentPurchaseDateAndTime = recentPurchaseDateAndTime;
    }
}
