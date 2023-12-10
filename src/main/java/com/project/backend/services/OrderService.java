package com.project.backend.services;

import com.project.backend.entities.Order;
import com.project.backend.repositories.OrderRepository;
import com.project.backend.services.exceptions.DataBaseException;
import com.project.backend.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order order){
        return repository.save(order);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order order){
        try {
            Order reference = repository.getReferenceById(id);
            updateData(reference, order);
            return repository.save(reference);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //Auxiliary methods
    private void updateData(Order reference, Order order){
        reference.setStatus(order.getStatus());
    }
}
