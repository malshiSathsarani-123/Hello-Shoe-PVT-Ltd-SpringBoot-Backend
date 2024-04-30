package com.example.helloshoepvtltdspringboot.entity;

import com.example.helloshoepvtltdspringboot.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "supplierEntity",cascade = CascadeType.ALL)
    private List<InventoryEntity> inventoryEntities;
}
