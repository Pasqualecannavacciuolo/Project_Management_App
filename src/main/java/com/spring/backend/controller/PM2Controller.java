package com.spring.backend.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import com.spring.backend.domain.PM3;
import com.spring.backend.service.PM2Service;
import com.spring.backend.service.PM3Service;

@RestController
@CrossOrigin("*")
public class PM2Controller {

    @Autowired
    PM2Service pm2Service;
    @Autowired
    PM3Service pm3Service;

    @GetMapping(path = "/pm2/{id}")
    ResponseEntity<PM2> findById(@PathVariable Long id) {
        PM2 pm_2 = pm2Service.findById(id);
        return new ResponseEntity<>(pm_2, HttpStatus.OK);
    }

    @GetMapping("/pm2/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(pm2Service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/pm2/saveOne")
    ResponseEntity<PM2> saveOne(@RequestBody PM2 pm_2) {
        PM2 pm_2_new = pm2Service.saveOne(pm_2);
        return new ResponseEntity<>(pm_2_new, HttpStatus.OK);
    }
}
