package com.spring.backend.repository;

import org.springframework.stereotype.Repository;

import com.spring.backend.domain.PM3;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PM3Repository extends JpaRepository<PM3, Long>{
    
}
