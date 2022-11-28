package com.spring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.backend.domain.PM1;

@Repository
public interface PM1Repository extends JpaRepository<PM1, Long>{
    
}
