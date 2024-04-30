package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.entity.ItemEntity;
import com.example.helloshoepvtltdspringboot.entity.SupplierEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO {
    @Id
    private String code;
    private String description;
    private String pic;
    private String category;
    private int size;
    private double unitPriceSale;
    private double unitPriceBuy;
    private double expectedProfit;
    private double profitMargin;
    private String status;
    private Integer qty;
    private LocalDate buyDate;

    @ManyToOne
    @JoinColumn(name = "supplierCode",nullable = false)
    private SupplierEntity supplierEntity;

    @ManyToOne
    @JoinColumn(name = "shoeCode",nullable = false)
    private ItemEntity itemEntity;
}
