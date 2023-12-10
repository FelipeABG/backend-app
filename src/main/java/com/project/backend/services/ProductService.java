package com.project.backend.services;

import com.project.backend.entities.Product;
import com.project.backend.repositories.ProductRepository;
import com.project.backend.services.exceptions.DataBaseException;
import com.project.backend.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //Attributes
    @Autowired
    private ProductRepository repository;

    //Methods
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product insert(Product product){
        return repository.save(product);
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

    public Product update (Long id, Product product){
        try {
            Product reference = repository.getReferenceById(id);
            updateData(reference, product);
            return repository.save(reference);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //Auxiliary methods
    private void updateData(Product reference, Product product){
        reference.setName(product.getName());
        reference.setCategory(product.getCategory());
        reference.setDescription(product.getDescription());
        reference.setPrice(product.getPrice());
        reference.setImgUrl(product.getImgUrl());
    }
}
