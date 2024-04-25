package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeDao extends JpaRepository<EmployeeEntity,String> {
    @Query("SELECT MAX(e.code) FROM EmployeeEntity e")
    String findMaxId();
}
