package com.onlineFoodOrdering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineFoodOrdering.model.Order;
import com.onlineFoodOrdering.service.OrderService;

@RestController
@RequestMapping("/api/admin")
public class AdminOrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/restaurant/{id}")
	public ResponseEntity<List<Order>> getOrderHistory(@PathVariable long id,
										@RequestParam(required = false)String order_status)throws Exception{
		
		List<Order> orders = orderService.getRestaurantsOrders(id, order_status);
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@PutMapping("/order/{orderId}/orderStatus")
	public ResponseEntity<Order> updateOrderStatus(@PathVariable long orderId,
												   @PathVariable String orderStatus)throws Exception{
		
		Order order = orderService.updateOrder(orderId, orderStatus);
		
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
}













