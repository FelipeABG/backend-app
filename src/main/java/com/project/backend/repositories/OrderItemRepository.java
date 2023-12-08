package com.project.backend.repositories;

import com.project.backend.entities.OrderItem;
import com.project.backend.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
