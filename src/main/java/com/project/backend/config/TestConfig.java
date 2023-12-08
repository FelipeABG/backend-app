package com.project.backend.config;

import com.project.backend.entities.Category;
import com.project.backend.entities.Order;
import com.project.backend.entities.Product;
import com.project.backend.entities.User;
import com.project.backend.entities.enums.OrderStatus;
import com.project.backend.repositories.CategoryRepository;
import com.project.backend.repositories.OrderRepository;
import com.project.backend.repositories.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ProductRepository productRepo;

    @Override //Acts like a main method and runs everything inside it when the program is initialized
    public void run(String... args) throws Exception {

        User u1 = new User("Felipe", "felipe@gmail.com", "999841588", "root");
        User u2 = new User("Cleiton", "cleiton@gmail.com", "996056632", "root");

        Order o1 = new Order(Instant.now(), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(Instant.now(), u2, OrderStatus.WAITING_PAYMENT);

        Category c1 = new Category("Electronics");
        Category c2 = new Category("House");

        Product p1 = new Product("Computer", "this is a computer", 2350.0, "http//img", c1);
        Product p2 = new Product("Table", "this is a table", 1420.0, "http//img", c2);

        userRepo.saveAll(Arrays.asList(u1, u2));
        orderRepo.saveAll(Arrays.asList(o1,o2));
        categoryRepo.saveAll(Arrays.asList(c1,c2));
        productRepo.saveAll(Arrays.asList(p1,p2));

    }
}
