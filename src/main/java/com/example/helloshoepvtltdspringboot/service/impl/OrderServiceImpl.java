package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.OrderDTO;
import com.example.helloshoepvtltdspringboot.dto.OrderItemDTO;
import com.example.helloshoepvtltdspringboot.entity.*;
import com.example.helloshoepvtltdspringboot.exception.NotFoundException;
import com.example.helloshoepvtltdspringboot.repositary.*;
import com.example.helloshoepvtltdspringboot.service.OrderService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderDao orderDao;

    @Autowired
    private final OrderItemDao orderItemDao;

    @Autowired
    private final ItemDao itemDao;

    @Autowired
    private final InventoryDao inventoryDao;

    @Autowired
    private final CustomerDao customerDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void purchaseOrder(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOS, String customerCode) {
        OrderEntity orderEntity = mapping.toOrderEntity(orderDTO);
        orderDao.save(orderEntity);
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            orderItemDTO.setId(nextOrderItemId());
            OrderItemEntity orderItem = mapping.toOrderItem(orderItemDTO);
            orderItem.setOrderEntity(orderEntity);
            orderItemDao.save(orderItem);

            InventoryEntity byShoeCodeAndSize = inventoryDao.findByShoeCodeAndSize(orderItem.getShoeCode(), orderItem.getSize());
            Integer qty = byShoeCodeAndSize.getQty();
            Integer newQty = qty - orderItem.getQty();
            inventoryDao.updateQtyByShoeCodeAndSize(orderItem.getShoeCode(),orderItem.getSize(),newQty);
        }
        updateCustomerPoint(customerCode,orderEntity.getPoint());
    }



    private void updateCustomerPoint(String customerCode, Integer point) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customerCode);
        if (!tmpCustomer.isPresent())throw new NotFoundException("CUSTOMER NOT FOUND");
        Integer totalPoints = tmpCustomer.get().getTotalPoints();
        tmpCustomer.get().setTotalPoints(totalPoints+point);
    }

    @Override
    public String nextOrderId() {
        String maxId = orderDao.findMaxId();
        if (maxId != null){
            return generateNextOrderId(maxId);
        }else {
            return "O-001";
        }
    }

    private static String generateNextOrderId(String lastOrderId) {
        String numericPart = lastOrderId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "O-" + nextNumericPart;
    }

    public String nextOrderItemId() {
        String maxId = orderItemDao.findMaxId();
        if (maxId != null){
            return generateNextOrderItemId(maxId);
        }else {
            return "OI001";
        }
    }

    private static String generateNextOrderItemId(String lastOrderItemId) {
        String numericPart = lastOrderItemId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "OI" + nextNumericPart;
    }
}
