package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO{
    private String code;
    private String customerName;
    private String customerId;
    private Double amount;
    private Double profit;
    private LocalDate date;
    private Payment payment;
    private Integer point;
    private String userName;
}
