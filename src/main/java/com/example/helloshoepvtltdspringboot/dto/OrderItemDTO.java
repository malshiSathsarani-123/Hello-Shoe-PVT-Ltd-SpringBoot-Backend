package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.entity.InventoryEntity;
import com.example.helloshoepvtltdspringboot.entity.OrderEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO implements SuperDTO {
    private String id;
    private String orderCode;
    private String shoeCode;
    private String description;
    private Integer size;
    private Double unitPrice;
    private Integer qty;
    private String pic;
}
