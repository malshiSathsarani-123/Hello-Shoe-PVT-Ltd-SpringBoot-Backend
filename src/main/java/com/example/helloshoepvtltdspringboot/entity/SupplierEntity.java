package com.example.helloshoepvtltdspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String code;
    private String name;
    private Category category;
    private String address;
    private String contact1;
    private String contact2;
    private String email;
}
