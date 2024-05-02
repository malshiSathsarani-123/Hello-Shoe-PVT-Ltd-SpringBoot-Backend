package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryDao extends JpaRepository<InventoryEntity,String> {

    @Query("SELECT SUM(i.qty) FROM InventoryEntity i WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :shoeSize")
    Integer getTotalQuantityByShoeCodeAndSize(@Param("shoeCode") String shoeCode, @Param("shoeSize") int shoeSize);
}
