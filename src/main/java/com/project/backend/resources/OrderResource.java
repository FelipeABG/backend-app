package com.project.backend.resources;

import com.project.backend.entities.Order;
import com.project.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    //Attributes
    @Autowired
    private OrderService service;

    //Methods
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(Long.parseLong(id)));
    }

}
