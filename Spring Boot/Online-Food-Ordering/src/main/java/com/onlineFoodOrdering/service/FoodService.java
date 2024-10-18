package com.onlineFoodOrdering.service;

import java.util.List;

import com.onlineFoodOrdering.model.Category;
import com.onlineFoodOrdering.model.Food;
import com.onlineFoodOrdering.model.Restaurant;
import com.onlineFoodOrdering.request.CreateFoodRequest;

public interface FoodService {

	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
	
	public void deleteFood(Long foodId) throws Exception;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
										 boolean isVegitarian, 
										 boolean isNonVeg, 
										 boolean isSeasonal, 
										 String foodCategory);
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws Exception;
	
	public Food updateAvailabilityStatus(Long foodId) throws Exception;
	
	
}
