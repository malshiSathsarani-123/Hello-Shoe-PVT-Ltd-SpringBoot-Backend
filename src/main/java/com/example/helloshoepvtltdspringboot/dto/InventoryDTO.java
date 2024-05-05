package com.example.helloshoepvtltdspringboot.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryDTO implements SuperDTO{
    private String code;
    private String shoeCode;
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

    private String supplierId;
    private String supplierName;

}
