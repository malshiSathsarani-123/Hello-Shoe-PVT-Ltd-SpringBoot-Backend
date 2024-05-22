package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemDao extends JpaRepository<OrderItemEntity,String> {

    @Query("SELECT MAX(oi.id) FROM OrderItemEntity oi")
    String findMaxId();
}
