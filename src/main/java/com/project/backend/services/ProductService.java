package com.project.backend.services;

import com.project.backend.entities.Product;
import com.project.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findById(id).get();
    }

    public Product insert(Product product){
        return repository.save(product);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Product update (Long id, Product product){
        Product reference = repository.getReferenceById(id);
        updateData(reference,product);
        return repository.save(reference);
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
