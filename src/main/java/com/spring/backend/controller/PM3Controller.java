package com.spring.backend.controller;

import java.util.ArrayList;
import java.util.Set;

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
import com.spring.backend.domain.User;
import com.spring.backend.service.PM2Service;
import com.spring.backend.service.PM3Service;
import com.spring.backend.service.UserService;

@RestController
@CrossOrigin("*")
public class PM3Controller {

    @Autowired
    PM3Service pm3Service;
    @Autowired
    PM2Service pm2Service;
    @Autowired
    UserService userService;

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

    /**
     * Aggiunge al PM di tipo 3 un collegamento al PM di tipo 2 che lo gestisce
     * @param pm3_id -- > PM di tipo 3 a cui aggiungere un superiore (PM di tipo 2)
     * @param pm2_id --> PM di tipo 2 da aggiungere come superiore al PM di tipo 3
     * @return --> Il PM di tipo 3 aggiornato con il superiore aggiunto
     */
    @PostMapping("/pm3/savePm2/{pm3_id}/{pm2_id}")
    ResponseEntity<PM3> savePm2(@PathVariable Long pm3_id, @PathVariable Long pm2_id) {
        PM3 pm_3_updated = pm3Service.savePm2(pm3_id, pm2_id);
        return new ResponseEntity<>(pm_3_updated, HttpStatus.OK);
    }

    /**
     * Aggiunge una lista di utenti al PM di tipo 3 che quest'ultimo pu?? gestire
     * @param users
     * @param pm3_id
     * @return
     */
    @PostMapping("/pm3/addUsers/{pm3_id}")
    ResponseEntity<PM3> addUsers(@RequestBody ArrayList<Long> users, @PathVariable Long pm3_id) {
        PM3 pm3_where_to_add = pm3Service.findById(pm3_id);
        for (int i = 0; i < users.size(); i++) {
            User user_tmp_to_find = userService.findById(users.get(i));
            Set<User> tmp_set = pm3_where_to_add.getUsers_assigned();
            tmp_set.add(user_tmp_to_find);
            pm3_where_to_add.setUsers_assigned(tmp_set);
            pm3Service.saveOne(pm3_where_to_add);
        }
        return new ResponseEntity<>(pm3_where_to_add,HttpStatus.OK);
    }
    
}
