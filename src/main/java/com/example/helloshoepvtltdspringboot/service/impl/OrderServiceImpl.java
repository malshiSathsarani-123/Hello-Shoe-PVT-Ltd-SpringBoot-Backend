package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.OrderDTO;
import com.example.helloshoepvtltdspringboot.dto.OrderItemDTO;
import com.example.helloshoepvtltdspringboot.entity.*;
import com.example.helloshoepvtltdspringboot.enums.Level;
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
import java.util.stream.Collectors;

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
        Optional<CustomerEntity> byId = customerDao.findById(customerCode);
        CustomerEntity customerEntity = new CustomerEntity(customerCode, byId.get().getName(), byId.get().getGender(), byId.get().getJoinDate(), byId.get().getLevel(), byId.get().getTotalPoints(), byId.get().getDob(), byId.get().getAddress(), byId.get().getContact(), byId.get().getEmail(), byId.get().getRecentPurchaseDateAndTime());
        orderEntity.setCustomerEntity(customerEntity);
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
        updateCustomerData(customerCode,orderEntity.getPoint());
    }



    private void updateCustomerData(String customerCode, Integer point) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(customerCode);
        if (!tmpCustomer.isPresent())throw new NotFoundException("CUSTOMER NOT FOUND");
        Integer totalPoints = tmpCustomer.get().getTotalPoints();
        Integer newTotal = totalPoints+point;
        tmpCustomer.get().setTotalPoints(newTotal);
        if (newTotal >= 50 && newTotal < 100){
            tmpCustomer.get().setLevel(Level.BRONZE);
        }if (newTotal >= 100 && newTotal < 200){
            tmpCustomer.get().setLevel(Level.SILVER);
        }if (newTotal >= 200){
            tmpCustomer.get().setLevel(Level.GOLD);
        }
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

    @Override
    public List<OrderDTO> getAllInventory() {
        List<OrderEntity> orderEntityList = orderDao.findAll();
        return orderEntityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getSizesByOrderCode(String orderCode) {
        return orderItemDao.findSizesByOrderCode(orderCode);
    }

    @Override
    public Object getSizesByOrderCodeAndShoeCode(String orderCode, String shoeCode) {
        return orderItemDao.findAllByOrderCodeAndShoeCode(orderCode,shoeCode);
    }

    @Override
    public void returnOrder(String orderCode, String customerCode, Integer point, List<OrderItemDTO> orderItemDTOS) {
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            InventoryEntity byShoeCodeAndSize = inventoryDao.findByShoeCodeAndSize(orderItemDTO.getShoeCode(), orderItemDTO.getSize());
            Integer qty = byShoeCodeAndSize.getQty();
            Integer newQty = qty + orderItemDTO.getQty();
            inventoryDao.updateQtyByShoeCodeAndSize(orderItemDTO.getShoeCode(),orderItemDTO.getSize(),newQty);
            updateOrderQty(orderItemDTO);
        }
//        updateCustomerPoint(customerCode,point);
    }

    private void updateOrderQty(OrderItemDTO orderItemDTO) {
        Integer qty = orderItemDao.getOrderQty(orderItemDTO.getId());
        Integer newQty = qty - orderItemDTO.getQty();
        orderItemDao.updateQty(newQty,orderItemDTO.getId());
    }

    private OrderDTO convertToDTO(OrderEntity orderEntity) {
        return new OrderDTO(
                orderEntity.getCode(),
                orderEntity.getCustomerName(),
                orderEntity.getCustomerEntity().getCode(),
                orderEntity.getAmount(),
                orderEntity.getProfit(),
                orderEntity.getDate(),
                orderEntity.getPayment(),
                orderEntity.getPoint(),
                orderEntity.getUserName()
        );
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
