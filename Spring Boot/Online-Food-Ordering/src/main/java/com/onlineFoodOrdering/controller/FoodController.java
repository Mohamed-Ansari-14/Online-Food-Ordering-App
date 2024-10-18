package com.onlineFoodOrdering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineFoodOrdering.model.Food;
import com.onlineFoodOrdering.service.FoodService;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword) throws Exception{
		
		List<Food> food = foodService.searchFood(keyword);
		
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>> getRestaurantsFood(
						@PathVariable Long restaurantId,
						@RequestParam boolean vegetarian,
						@RequestParam boolean seasonal,
						@RequestParam boolean nonveg,
						@RequestParam(required = false)String foodCategory) throws Exception{
		
		List<Food> food = foodService.getRestaurantsFood(restaurantId, vegetarian, nonveg, 
														 seasonal, foodCategory);
		
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
}




















