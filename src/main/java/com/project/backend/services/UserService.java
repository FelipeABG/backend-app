package com.project.backend.services;

import com.project.backend.entities.User;
import com.project.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    //Attributes
    @Autowired
    private UserRepository repository;

    //Methods
    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }

    @GetMapping
    public User findById(Long id){
        return repository.findById(id).get();
    }
}
