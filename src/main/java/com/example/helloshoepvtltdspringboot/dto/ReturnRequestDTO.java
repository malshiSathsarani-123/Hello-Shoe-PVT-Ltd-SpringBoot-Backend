package com.example.helloshoepvtltdspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnRequestDTO {
    private String customerCode;
    private Integer point;
    private String orderCode;
    private List<OrderItemDTO> orderItemDTOS;
}
