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

import com.spring.backend.domain.PM3;
import com.spring.backend.service.PM3Service;

@RestController
@CrossOrigin("*")
public class PM3Controller {

    @Autowired
    PM3Service pm3Service;

    @GetMapping(path = "/pm3/{id}")
    ResponseEntity<PM3> findById(@PathVariable Long id) {
        PM3 pm_3 = pm3Service.findById(id);
        return new ResponseEntity<>(pm_3, HttpStatus.OK);
    }

    @GetMapping("/pm3/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pm3Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/pm3/saveOne")
    ResponseEntity<PM3> saveOne(@RequestBody PM3 pm_3) {
        PM3 pm_3_new = pm3Service.saveOne(pm_3);
        return new ResponseEntity<>(pm_3_new, HttpStatus.OK);
    }
    
}
