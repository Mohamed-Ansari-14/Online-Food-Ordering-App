package com.onlineFoodOrdering.service;

import java.util.List;

import com.onlineFoodOrdering.model.Order;
import com.onlineFoodOrdering.model.User;
import com.onlineFoodOrdering.request.OrderRequest;

public interface OrderService {

	public Order createOrder(OrderRequest order, User user) throws Exception;
	
	public Order updateOrder(Long orderId, String orderStatus) throws Exception;
	
	public void cancelOrder(Long orderId) throws Exception;
	
	public List<Order> getUsersOrders(Long userId) throws Exception;
	
	public List<Order> getRestaurantsOrders(Long restaurantId, String orderStatus) throws Exception;
	
	public Order findOrderById(Long orderId) throws Exception;
}
