package com.project.backend.services;

import com.project.backend.entities.User;
import com.project.backend.repositories.UserRepository;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.findById(id).get();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    //Auxiliary methods
    private void updateData(User reference, User user){
        reference.setName(user.getName());
        reference.setPhone(user.getPhone());
        reference.setEmail(user.getEmail());
    }
}
