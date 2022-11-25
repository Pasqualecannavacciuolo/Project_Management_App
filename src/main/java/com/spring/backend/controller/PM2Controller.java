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

import com.spring.backend.domain.PM2;
import com.spring.backend.service.PM2Service;

@RestController
@CrossOrigin("*")
public class PM2Controller {

    @Autowired
    PM2Service pm2Service;

    @GetMapping(path = "/pm2/{id}")
    ResponseEntity<PM2> findById(@PathVariable Long id) {
        PM2 pm_3 = pm2Service.findById(id);
        return new ResponseEntity<>(pm_3, HttpStatus.OK);
    }

    @GetMapping("/pm2/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pm2Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/pm2/saveOne")
    ResponseEntity<PM2> saveOne(@RequestBody PM2 pm_3) {
        PM2 pm_3_new = pm2Service.saveOne(pm_3);
        return new ResponseEntity<>(pm_3_new, HttpStatus.OK);
    }
    
}
