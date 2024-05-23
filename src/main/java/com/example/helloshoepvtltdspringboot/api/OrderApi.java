package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.*;
import com.example.helloshoepvtltdspringboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<OrderDTO> GetAllOrder(){
        return orderService.getAllInventory();
    }


    @GetMapping("/getShoeCode/{orderCode}")
    public List<String> getShoeCodesByOrderCode(@PathVariable String orderCode) {
        return orderService.getSizesByOrderCode(orderCode);
    }

    @GetMapping("/getOrderItem")
    public Object getSizesByOrderCodeAndShoeCode(@RequestParam String orderCode, @RequestParam String shoeCode) {
        return orderService.getSizesByOrderCodeAndShoeCode(orderCode, shoeCode);
    }

    @PostMapping("/return")
    public void returnOrder(@RequestBody ReturnRequestDTO returnRequestDTO){
        orderService.returnOrder(returnRequestDTO.getOrderCode(),returnRequestDTO.getCustomerCode(),returnRequestDTO.getPoint(),returnRequestDTO.getOrderItemDTOS());
    }
}
