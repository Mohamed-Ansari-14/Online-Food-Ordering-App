package com.onlineFoodOrdering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineFoodOrdering.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	
}
