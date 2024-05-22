package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.OrderDTO;
import com.example.helloshoepvtltdspringboot.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOS, String customerCode);

    String nextOrderId();
}
