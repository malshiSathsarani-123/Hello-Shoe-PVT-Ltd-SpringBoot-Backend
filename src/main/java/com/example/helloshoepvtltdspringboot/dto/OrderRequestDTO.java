package com.example.helloshoepvtltdspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDTO {
    private String customerCode;
    private OrderDTO orderDTO;
    private List<OrderItemDTO> orderItemDTOS;
}
