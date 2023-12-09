package com.project.backend.resources;

import com.project.backend.entities.Category;
import com.project.backend.entities.Order;
import com.project.backend.entities.Product;
import com.project.backend.entities.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public abstract class Resource {

    public URI getUri(User user){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    }

    public URI getUri(Product product){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
    }

    public URI getUri(Order order){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
    }

    public URI getUri(Category category){
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
    }

}
