package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.ItemGender;
import com.example.helloshoepvtltdspringboot.enums.Occasion;
import com.example.helloshoepvtltdspringboot.enums.Verities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemDTO {
    @Id
    private String shoeCode;
    private String description;
    private ItemGender itemGender;
    private Occasion occasion;
    private Verities verities;
}
