package com.onlineFoodOrdering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineFoodOrdering.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	
}
