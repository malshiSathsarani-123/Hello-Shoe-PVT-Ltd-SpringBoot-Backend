package com.example.helloshoepvtltdspringboot.util;

import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.entity.CustomerEntity;
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
//    //UserMapping
//    public UserEntity toUserEntity(UserDTO userDTO) {
//        return mapper.map(userDTO, UserEntity.class);
//    }
//    public UserDTO toUserDTO(UserEntity userEntity) {
//        return  mapper.map(userEntity, UserDTO.class);
//    }

}
