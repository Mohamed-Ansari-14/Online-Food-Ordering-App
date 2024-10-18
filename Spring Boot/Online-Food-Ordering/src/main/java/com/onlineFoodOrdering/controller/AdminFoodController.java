package com.onlineFoodOrdering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineFoodOrdering.model.Food;
import com.onlineFoodOrdering.model.Restaurant;
import com.onlineFoodOrdering.request.CreateFoodRequest;
import com.onlineFoodOrdering.response.MessageResponse;
import com.onlineFoodOrdering.service.FoodService;
import com.onlineFoodOrdering.service.RestaurantService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping
	public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req
										 /*@RequestHeader("Authorization")String jwt*/) throws Exception{
		
//		User user = userService.findUserByJwtToken(jwt);
		Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
		Food food = foodService.createFood(req, req.getCategory(), restaurant);
		
		return new ResponseEntity<>(food, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id) throws Exception{

		foodService.deleteFood(id);
		
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage("Food Deleted Successfully");
		
		return new ResponseEntity<>(messageResponse, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateAvailabilityStatus(@PathVariable Long foodId) throws Exception{

		Food food = foodService.updateAvailabilityStatus(foodId);
		
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
}


























