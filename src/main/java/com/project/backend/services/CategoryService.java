package com.project.backend.services;

import com.project.backend.entities.Category;
import com.project.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    //Attributes
    @Autowired
    private CategoryRepository repository;

    //Methods
    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id).get();
    }

    public Category insert(Category category){
        return repository.save(category);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Category update(Long id, Category category){
        Category reference = repository.getReferenceById(id);
        updateData(reference, category);
        return repository.save(reference);
    }

    //Auxiliary methods
    private void updateData(Category reference, Category category){
        reference.setName(category.getName());
    }
}
