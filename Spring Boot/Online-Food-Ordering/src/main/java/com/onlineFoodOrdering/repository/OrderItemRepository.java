package com.onlineFoodOrdering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineFoodOrdering.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
