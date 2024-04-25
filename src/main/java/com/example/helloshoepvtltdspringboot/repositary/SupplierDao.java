package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierDao extends JpaRepository<SupplierEntity,String> {
    @Query("SELECT MAX(s.code) FROM SupplierEntity s")
    String findMaxId();
}
