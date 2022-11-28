package com.spring.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.domain.PM1;
import com.spring.backend.service.PM1Service;

@RestController
@CrossOrigin("*")
public class PM1Controller {

    @Autowired
    PM1Service pm1Service;

    @GetMapping(path = "/pm1/{id}")
    ResponseEntity<PM1> findById(@PathVariable Long id) {
        PM1 pm_1 = pm1Service.findById(id);
        return new ResponseEntity<>(pm_1, HttpStatus.OK);
    }

    @GetMapping("/pm1/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pm1Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/pm1/saveOne")
    ResponseEntity<PM1> saveOne(@RequestBody PM1 pm_1) {
        PM1 pm_1_new = pm1Service.saveOne(pm_1);
        return new ResponseEntity<>(pm_1_new, HttpStatus.OK);
    }
    
}
