package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.OrderItemEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderItemDao extends JpaRepository<OrderItemEntity,String> {

    @Query("SELECT MAX(oi.id) FROM OrderItemEntity oi")
    String findMaxId();
    @Query("SELECT oi.shoeCode FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    String findBestSellingShoeCodeByDate(LocalDate date);

    @Query("SELECT oi.pic FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    String findBestSellingShoeCodeImageByDate(LocalDate date);
    @Query("SELECT  SUM(oi.qty) FROM OrderItemEntity oi JOIN oi.orderEntity o ON oi.orderEntity.code = o.code WHERE o.date =:date GROUP BY oi.shoeCode ORDER BY SUM(oi.qty) DESC LIMIT 1")
    Integer findBestSellingShoeCodeQtyByDate(LocalDate date);

    @Query("SELECT oi.shoeCode FROM OrderItemEntity oi WHERE oi.orderEntity.code = :orderCode")
    List<String> findSizesByOrderCode(String orderCode);
    @Query("SELECT oi.size, oi.description, oi.unitPrice, oi.qty ,oi.id FROM OrderItemEntity oi WHERE oi.orderEntity.code = :orderCode AND oi.shoeCode = :shoeCode")
    Object findAllByOrderCodeAndShoeCode(String orderCode,String shoeCode);

    @Query("select oi.qty from OrderItemEntity oi where oi.id = :id")
    Integer getOrderQty(String id);

    @Modifying
    @Transactional
    @Query("UPDATE OrderItemEntity  oi SET oi.qty = :newQty WHERE oi.id = :id")
    void updateQty(Integer newQty, String id);
}
