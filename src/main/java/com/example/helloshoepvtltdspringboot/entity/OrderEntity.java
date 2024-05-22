package com.example.helloshoepvtltdspringboot.entity;

import com.example.helloshoepvtltdspringboot.enums.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String code;
    private String customerName;
    private Double amount;
    private Double profit;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    private Integer point;
    private String userName;

    @ManyToOne
    private CustomerEntity customerEntity;
    @ManyToOne
    private UserEntity userEntity;
    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItemEntityList;
}
