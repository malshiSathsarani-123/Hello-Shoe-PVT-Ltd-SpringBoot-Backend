package com.example.helloshoepvtltdspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "inventory")
public class InventoryEntity  implements SuperEntity{
    @Id
    private String code;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shoeCode",nullable = false)
    private ItemEntity itemEntity;
    private String description;
    @Column(columnDefinition = "LONGTEXT")
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

    @OneToMany(mappedBy = "inventoryEntity",cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierCode",nullable = false)
    private SupplierEntity supplierEntity;
    private String supplierName;


}
