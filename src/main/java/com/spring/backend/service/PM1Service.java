package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.PM1;
import com.spring.backend.repository.PM1Repository;

@Service
public class PM1Service {

    @Autowired
    PM1Repository pm1Repository;

    public PM1 findById(Long id) {
        return pm1Repository.findById(id).orElse(null);
    }

    public List<PM1> findAll() {
        return pm1Repository.findAll();
    }

    public PM1 saveOne(PM1 pm1) {
        return pm1Repository.save(pm1);
    }
    
}
