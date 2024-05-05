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
public class SupplierEntity implements SuperEntity{
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

    public SupplierEntity(String code, String name, Category category, String address, String contact1, String contact2, String email) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.address = address;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.email = email;
    }

    public SupplierEntity(String code) {
        this.code = code;
    }
}
