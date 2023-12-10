package com.project.backend.services;

import com.project.backend.entities.Category;
import com.project.backend.repositories.CategoryRepository;
import com.project.backend.services.exceptions.DataBaseException;
import com.project.backend.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Category insert(Category category){
        return repository.save(category);
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

    public Category update(Long id, Category category){
        try {
            Category reference = repository.getReferenceById(id);
            updateData(reference, category);
            return repository.save(reference);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //Auxiliary methods
    private void updateData(Category reference, Category category){
        reference.setName(category.getName());
    }
}
