package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface OrderDao extends JpaRepository<OrderEntity,String> {

    @Query("SELECT MAX(o.code) FROM OrderEntity o")
    String findMaxId();

    @Query("SELECT SUM(o.amount) FROM OrderEntity o WHERE o.date = :date")
    Double findTotalAmountByDate(LocalDate date);

    @Query("SELECT SUM(o.profit) FROM OrderEntity o WHERE o.date = :date")
    Double findTotalProfitByDate(LocalDate date);
}
