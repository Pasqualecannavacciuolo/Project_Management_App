package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.PM_3;
import com.spring.backend.repository.PM_3Repository;

@Service
public class PM_3Service {
    @Autowired
    PM_3Repository pm_3Repository;

    public PM_3 findById(Long id) {
        return pm_3Repository.findById(id).orElse(null);
    }

    public List<PM_3> findAll() {
        return pm_3Repository.findAll();
    }

    public PM_3 saveOne(PM_3 pm_3) {
        return pm_3Repository.save(pm_3);
    }
}
