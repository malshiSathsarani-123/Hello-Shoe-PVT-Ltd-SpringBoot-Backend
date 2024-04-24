package com.example.helloshoepvtltdspringboot.repositary;

import com.example.helloshoepvtltdspringboot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
    @Query("SELECT MAX(c.code) FROM CustomerEntity c")
    String findMaxId();
}
