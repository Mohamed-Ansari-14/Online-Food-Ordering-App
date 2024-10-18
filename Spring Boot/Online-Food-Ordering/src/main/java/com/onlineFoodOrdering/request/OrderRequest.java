package com.onlineFoodOrdering.request;

import com.onlineFoodOrdering.model.Address;

import lombok.Data;

@Data
public class OrderRequest {

	private Long restaurantId;
	
	private Address deliveryAddress;
}
