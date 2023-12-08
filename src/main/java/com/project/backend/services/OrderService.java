package com.project.backend.services;

import com.project.backend.entities.Order;
import com.project.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    //Attributes
    @Autowired
    private OrderRepository repository;

    //Methods
    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        return repository.findById(id).get();
    }
}
