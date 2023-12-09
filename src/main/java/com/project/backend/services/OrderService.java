package com.project.backend.services;

import com.project.backend.entities.Order;
import com.project.backend.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
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

    public Order insert(Order order){
        return repository.save(order);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
