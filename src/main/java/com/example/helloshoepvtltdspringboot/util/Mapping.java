package com.example.helloshoepvtltdspringboot.util;

import com.example.helloshoepvtltdspringboot.dto.*;
import com.example.helloshoepvtltdspringboot.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    //CustomerMapping
    public CustomerDTO toCustomerDTO(CustomerEntity customer) {
       return  mapper.map(customer, CustomerDTO.class);
    }
    public CustomerEntity toCustomer(CustomerDTO customerDTO) {
        return  mapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customers) {
       return mapper.map(customers, List.class);
    }

    //SupplierMapping
    public SupplierDTO toCSupplierDTO(SupplierEntity supplierEntity) {
        return  mapper.map(supplierEntity, SupplierDTO.class);
    }
    public SupplierEntity toSupplier(SupplierDTO supplierDTO) {
        return  mapper.map(supplierDTO, SupplierEntity.class);
    }
    public List<SupplierDTO> toSupplierDTOList(List<SupplierEntity> supplierEntities) {
        return mapper.map(supplierEntities, List.class);
    }

    //EmployeeMapping
    public EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity) {
        return  mapper.map(employeeEntity, EmployeeDTO.class);
    }
    public EmployeeEntity toEmployee(EmployeeDTO employeeDTO) {
        return  mapper.map(employeeDTO, EmployeeEntity.class);
    }
    public List<EmployeeDTO> toEmployeeDTOList(List<EmployeeEntity> employeeEntities) {
        return mapper.map(employeeEntities, List.class);
    }

    //ItemMapping
    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return  mapper.map(itemEntity, ItemDTO.class);
    }
    public ItemEntity toItem(ItemDTO itemDTO) {
        return  mapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> toItemDTOList(List<ItemEntity> itemEntityList) {
        return mapper.map(itemEntityList, List.class);
    }

    //InventoryMapping
    public InventoryDTO toInventoryDTO(InventoryEntity inventoryEntity) {
        return  mapper.map(inventoryEntity, InventoryDTO.class);
    }
    public InventoryEntity toInventory(InventoryDTO inventoryDTO) {
        return  mapper.map(inventoryDTO, InventoryEntity.class);
    }
    public List<InventoryDTO> toInventoryDTOList(List<InventoryEntity> inventoryEntities) {
        return mapper.map(inventoryEntities, List.class);
    }
    public List<InventoryEntity> toInventoryEntityList(List<InventoryDTO> inventoryDTOList) {
        return inventoryDTOList.stream()
                .map(this::toInventory)
                .collect(Collectors.toList());
    }
//    //UserMapping
//    public UserEntity toUserEntity(UserDTO userDTO) {
//        return mapper.map(userDTO, UserEntity.class);
//    }
//    public UserDTO toUserDTO(UserEntity userEntity) {
//        return  mapper.map(userEntity, UserDTO.class);
//    }

}
