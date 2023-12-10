package com.project.backend.services;

import com.project.backend.entities.User;
import com.project.backend.repositories.UserRepository;
import com.project.backend.services.exceptions.DataBaseException;
import com.project.backend.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Attributes
    @Autowired
    private UserRepository repository;

    //Methods
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
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

    public User update(Long id, User user){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    //Auxiliary methods
    private void updateData(User reference, User user){
        reference.setName(user.getName());
        reference.setPhone(user.getPhone());
        reference.setEmail(user.getEmail());
    }
}
