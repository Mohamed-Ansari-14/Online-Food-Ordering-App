package com.onlineFoodOrdering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineFoodOrdering.model.IngredientCategory;
import com.onlineFoodOrdering.model.IngredientsItem;
import com.onlineFoodOrdering.request.IngredientCategoryRequest;
import com.onlineFoodOrdering.request.IngredientItemRequest;
import com.onlineFoodOrdering.service.IngredientsService;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

	@Autowired
	private IngredientsService ingredientsService;
	
	@PostMapping("/category")
	public ResponseEntity<IngredientCategory> createIngredientCategory(
							@RequestBody IngredientCategoryRequest req) throws Exception{
		
		IngredientCategory ingredientCategory = ingredientsService.createIngredientCategory(
														req.getName(), req.getRestaurantId());
		
		return new ResponseEntity<>(ingredientCategory, HttpStatus.CREATED);
	}
	
	@PostMapping()
	public ResponseEntity<IngredientsItem> createIngredientItem(
							@RequestBody IngredientItemRequest req) throws Exception{
		
		IngredientsItem ingredientsItem = ingredientsService.createIngredientItem(req.getRestaurantId(), 
																				  req.getName(),
																				  req.getCategoryId());
		
		return new ResponseEntity<>(ingredientsItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/stock")
	public ResponseEntity<IngredientsItem> updateIngredientStock(@PathVariable Long id) throws Exception{
		
		IngredientsItem ingredientsItem = ingredientsService.updateStock(id);
		
		return new ResponseEntity<>(ingredientsItem, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<List<IngredientsItem>> getRestaurantIngredient(@PathVariable Long id) throws Exception{
		
		List<IngredientsItem> ingredientsItems = ingredientsService.findRestaurantsIngredients(id);
		
		return new ResponseEntity<>(ingredientsItems, HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}/category")	
	public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(@PathVariable Long id) throws Exception{
		
		List<IngredientCategory> ingredientCategories = ingredientsService.findIngredientCategoryByRestaurantId(id);
		
		return new ResponseEntity<>(ingredientCategories, HttpStatus.OK);
	}
}





















