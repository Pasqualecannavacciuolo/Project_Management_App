package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.PM2;
import com.spring.backend.repository.PM2Repository;

@Service
public class PM2Service {

    @Autowired
    PM2Repository pm2Repository;


    public PM2 findById(Long id) {
        return pm2Repository.findById(id).orElse(null);
    }

    public List<PM2> findAll() {
        return pm2Repository.findAll();
    }

    public PM2 saveOne(PM2 pm2) {
        return pm2Repository.save(pm2);
    }
    
}
