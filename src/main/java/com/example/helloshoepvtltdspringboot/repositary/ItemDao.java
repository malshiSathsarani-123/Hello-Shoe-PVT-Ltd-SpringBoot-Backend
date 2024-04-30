package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemDao extends JpaRepository<ItemEntity,String> {
@Query(value = "SELECT MAX(CAST(SUBSTRING(it.shoeCode, 5) AS INTEGER)) FROM ItemEntity it")
    String findMaxId();
}
