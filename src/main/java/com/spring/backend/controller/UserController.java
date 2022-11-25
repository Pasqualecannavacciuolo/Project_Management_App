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

import com.spring.backend.domain.User;
import com.spring.backend.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/message")
    public String getMessage() {
        return "Ciao dalla funzione getMessage!";
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/saveOne")
    ResponseEntity<User> saveOne(@RequestBody User user) {
        User user1 = userService.saveOne(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    
}
