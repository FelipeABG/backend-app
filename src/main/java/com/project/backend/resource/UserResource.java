package com.project.backend.resource;

import com.project.backend.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("Felipe", "felipe@gmail.com", "999845188", "root");

        return ResponseEntity.ok().body(u);
    }

}
