package com.example.helloshoepvtltdspringboot.util;

import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.dto.ItemDTO;
import com.example.helloshoepvtltdspringboot.dto.SupplierDTO;
import com.example.helloshoepvtltdspringboot.entity.CustomerEntity;
import com.example.helloshoepvtltdspringboot.entity.EmployeeEntity;
import com.example.helloshoepvtltdspringboot.entity.ItemEntity;
import com.example.helloshoepvtltdspringboot.entity.SupplierEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
//    //UserMapping
//    public UserEntity toUserEntity(UserDTO userDTO) {
//        return mapper.map(userDTO, UserEntity.class);
//    }
//    public UserDTO toUserDTO(UserEntity userEntity) {
//        return  mapper.map(userEntity, UserDTO.class);
//    }

}
