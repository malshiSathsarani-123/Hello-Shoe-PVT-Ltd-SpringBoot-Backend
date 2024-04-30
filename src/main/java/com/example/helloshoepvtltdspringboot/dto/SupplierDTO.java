package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
