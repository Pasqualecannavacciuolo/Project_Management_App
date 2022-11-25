package com.spring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.backend.domain.PM2;

@Repository
public interface PM2Repository extends JpaRepository<PM2, Long>{
    
}
