package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDao extends JpaRepository<InventoryEntity,String> {
}
