package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface OrderItemDao extends JpaRepository<OrderItemEntity,String> {

    @Query("SELECT MAX(oi.id) FROM OrderItemEntity oi")
    String findMaxId();
    @Query("SELECT oi.shoeCode FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    String findBestSellingShoeCodeByDate(LocalDate date);

    @Query("SELECT oi.pic FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    String findBestSellingShoeCodeImageByDate(LocalDate date);
    @Query("SELECT  SUM(oi.qty) FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    Integer findBestSellingShoeCodeQtyByDate(LocalDate date);

}
