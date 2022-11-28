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
import com.spring.backend.domain.PM2;
import com.spring.backend.service.PM1Service;
import com.spring.backend.service.PM2Service;
import com.spring.backend.service.PM3Service;

@RestController
@CrossOrigin("*")
public class PM2Controller {

    @Autowired
    PM2Service pm2Service;
    @Autowired
    PM3Service pm3Service;
    @Autowired
    PM1Service pm1Service;

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

    /**
     * Aggiunge al PM di tipo 3 un collegamento al PM di tipo 2 che lo gestisce
     * @param pm3_id -- > PM di tipo 3 a cui aggiungere un superiore (PM di tipo 2)
     * @param pm2_id --> PM di tipo 2 da aggiungere come superiore al PM di tipo 3
     * @return --> Il PM di tipo 3 aggiornato con il superiore aggiunto
     */
    @PostMapping("/pm2/savePm1/{pm2_id}/{pm1_id}")
    ResponseEntity<PM2> savePm2(@PathVariable Long pm1_id, @PathVariable Long pm2_id) {
        PM1 pm1_to_find = pm1Service.findById(pm1_id);
        PM2 pm2_to_find = pm2Service.findById(pm2_id);
        pm2_to_find.setPm1(pm1_to_find);
        PM2 pm_2_updated = pm2Service.saveOne(pm2_to_find);
        return new ResponseEntity<>(pm_2_updated, HttpStatus.OK);
    }
}
