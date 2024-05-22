package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.InventoryEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryDao extends JpaRepository<InventoryEntity,String> {

    @Query("SELECT SUM(i.qty) FROM InventoryEntity i WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :shoeSize")
    Integer getTotalQuantityByShoeCodeAndSize(@Param("shoeCode") String shoeCode, @Param("shoeSize") int shoeSize);

    @Query("SELECT i FROM InventoryEntity i WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :size")
    InventoryEntity findByShoeCodeAndSize(@Param("shoeCode") String shoeCode, @Param("size") int size);

    @Query("SELECT MAX(i.code) FROM InventoryEntity i")
    String findMaxId();

    @Modifying
    @Transactional
    @Query("UPDATE InventoryEntity i SET i.qty = :qty WHERE i.itemEntity.shoeCode = :shoeCode AND i.size = :size")
    void updateQtyByShoeCodeAndSize(String shoeCode, int size, int qty);
}
