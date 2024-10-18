package com.onlineFoodOrdering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineFoodOrdering.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	public Cart findByCustomerId(Long userId);
}
