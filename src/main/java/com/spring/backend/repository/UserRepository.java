package com.spring.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.backend.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
