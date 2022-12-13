package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.PM2;
import com.spring.backend.domain.PM3;
import com.spring.backend.repository.PM3Repository;

@Service
public class PM3Service {
    @Autowired
    PM3Repository pm3Repository;
    @Autowired
    PM2Service pm2Service;

    public PM3 findById(Long id) {
        return pm3Repository.findById(id).orElse(null);
    }

    public List<PM3> findAll() {
        return pm3Repository.findAll();
    }

    public PM3 saveOne(PM3 pm3) {
        return pm3Repository.save(pm3);
    }

    public PM3 savePm2(Long pm3_id, Long pm2_id) {
        PM3 pm3_to_find = this.findById(pm3_id);
        PM2 pm2_to_find = pm2Service.findById(pm2_id);
        pm3_to_find.setPm2(pm2_to_find);
        PM3 pm3_updated = this.saveOne(pm3_to_find);
        return pm3_updated;
    }
}
