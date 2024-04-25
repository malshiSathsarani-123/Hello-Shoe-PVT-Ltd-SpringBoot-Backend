package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.entity.Category;
import com.example.helloshoepvtltdspringboot.entity.Gender;
import com.example.helloshoepvtltdspringboot.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private String code;
    private String name;
    private Category category;
    private String address;
    private String contact1;
    private String contact2;
    private String email;
}
