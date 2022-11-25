package com.spring.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend.domain.User;
import com.spring.backend.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository usersRepository;

    public User findById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User saveOne(User user) {
        return usersRepository.save(user);
    }

}
