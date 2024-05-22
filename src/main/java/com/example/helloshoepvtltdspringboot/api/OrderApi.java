package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.OrderRequestDTO;
import com.example.helloshoepvtltdspringboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class OrderApi {
    @Autowired
    private final OrderService orderService;

    @PostMapping
    public void purchaseOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        orderRequestDTO.getOrderDTO().setCode(orderService.nextOrderId());
        orderService.purchaseOrder(orderRequestDTO.getOrderDTO(),orderRequestDTO.getOrderItemDTOS(),orderRequestDTO.getCustomerCode());
    }
}
