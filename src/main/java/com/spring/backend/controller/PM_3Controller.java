package com.spring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.backend.domain.PM_3;
import com.spring.backend.service.PM_3Service;

public class PM_3Controller {

    @Autowired
    PM_3Service pm_3Service;

    @GetMapping(path = "/{id}")
    ResponseEntity<PM_3> findById(@PathVariable Long id) {
        PM_3 pm_3 = pm_3Service.findById(id);
        return new ResponseEntity<>(pm_3, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pm_3Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/saveOne")
    ResponseEntity<PM_3> saveOne(@RequestBody PM_3 pm_3) {
        PM_3 pm_3_new = pm_3Service.saveOne(pm_3);
        return new ResponseEntity<>(pm_3_new, HttpStatus.OK);
    }
    
}
