package com.example.helloshoepvtltdspringboot.dto;

import com.example.helloshoepvtltdspringboot.enums.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO{
    private String code;
    private String customerName;
    private Double amount;
    private Date date;
    private Payment payment;
    private Integer point;
    private String userName;
}
