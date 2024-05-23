package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.OrderDTO;
import com.example.helloshoepvtltdspringboot.dto.OrderItemDTO;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOS, String customerCode);

    String nextOrderId();

    List<OrderDTO> getAllInventory();

    List<String> getSizesByOrderCode(String orderCode);

    Object getSizesByOrderCodeAndShoeCode(String orderCode, String shoeCode);

    void returnOrder(String orderCode, String customerCode, Integer point, List<OrderItemDTO> orderItemDTOS);

}
