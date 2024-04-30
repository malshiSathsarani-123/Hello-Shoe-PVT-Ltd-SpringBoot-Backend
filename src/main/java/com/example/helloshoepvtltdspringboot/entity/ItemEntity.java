package com.example.helloshoepvtltdspringboot.entity;

import com.example.helloshoepvtltdspringboot.enums.ItemGender;
import com.example.helloshoepvtltdspringboot.enums.Occasion;
import com.example.helloshoepvtltdspringboot.enums.Verities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    private String shoeCode;
    private String description;
    private ItemGender itemGender;
    private Occasion occasion;
    private Verities verities;

    @OneToMany(mappedBy = "itemEntity",cascade = CascadeType.ALL)
    private List<InventoryEntity> inventoryEntities;
}
