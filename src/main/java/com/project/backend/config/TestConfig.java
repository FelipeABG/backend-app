package com.project.backend.config;

import com.project.backend.entities.Order;
import com.project.backend.entities.User;
import com.project.backend.entities.enums.OrderStatus;
import com.project.backend.repositories.OrderRepository;
import com.project.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private OrderRepository orderRepo;

    @Override //Acts like a main method and runs everything inside it when the program is initialized
    public void run(String... args) throws Exception {

        User u1 = new User("Felipe", "felipe@gmail.com", "999841588", "root");
        User u2 = new User("Cleiton", "cleiton@gmail.com", "996056632", "root");

        Order o1 = new Order(Instant.now(), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(Instant.now(), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(Instant.now(), u1, OrderStatus.WAITING_PAYMENT);
        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.saveAll(Arrays.asList(o1,o2, o3));

    }
}
