package com.project.backend.config;

import com.project.backend.entities.User;
import com.project.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override //Acts like a main method and runs everything inside it when the program is initialized
    public void run(String... args) throws Exception {

        User u = new User("Felipe", "felipe@gmail.com", "999841588", "root");
        User u1 = new User("Cleiton", "cleiton@gmail.com", "996056632", "root");

        repository.save(u);
        repository.save(u1);

    }
}