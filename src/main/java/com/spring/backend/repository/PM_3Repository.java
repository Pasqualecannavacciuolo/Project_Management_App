package com.spring.backend.repository;

import org.springframework.stereotype.Repository;

import com.spring.backend.domain.PM_3;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PM_3Repository extends JpaRepository<PM_3, Long>{
    
}
