package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.PM3;
import com.spring.backend.repository.PM3Repository;

@Service
public class PM3Service {
    @Autowired
    PM3Repository pm3Repository;

    public PM3 findById(Long id) {
        return pm3Repository.findById(id).orElse(null);
    }

    public List<PM3> findAll() {
        return pm3Repository.findAll();
    }

    public PM3 saveOne(PM3 pm3) {
        return pm3Repository.save(pm3);
    }
}
