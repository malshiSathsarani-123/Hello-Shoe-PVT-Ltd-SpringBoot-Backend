package com.example.helloshoepvtltdspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderItem")
public class OrderItemEntity {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "orderCode")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "shoeCode")
    private InventoryEntity inventoryEntity;

    private String description;
    private Integer size;
    private Double unitPrice;
    private Integer qty;
}
