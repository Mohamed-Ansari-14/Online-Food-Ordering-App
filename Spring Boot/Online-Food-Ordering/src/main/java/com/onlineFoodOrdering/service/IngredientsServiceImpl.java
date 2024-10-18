package com.onlineFoodOrdering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineFoodOrdering.model.IngredientCategory;
import com.onlineFoodOrdering.model.IngredientsItem;
import com.onlineFoodOrdering.model.Restaurant;
import com.onlineFoodOrdering.repository.IngredientCategoryRepository;
import com.onlineFoodOrdering.repository.IngredientItemRepository;

@Service
public class IngredientsServiceImpl implements IngredientsService{

	@Autowired
	private IngredientCategoryRepository ingredientCategoryRepository;
	
	@Autowired
	private IngredientItemRepository ingredientItemRepository;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
		
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		
		IngredientCategory ingredientCategory = new IngredientCategory();
		ingredientCategory.setRestaurant(restaurant);
		ingredientCategory.setName(name);
		
		return ingredientCategoryRepository.save(ingredientCategory);
	}

	@Override
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
		
		Optional<IngredientCategory> optionalCategory = ingredientCategoryRepository.findById(id);
		
		if(optionalCategory.isEmpty()) {
			throw new Exception("ingredient category not found");
		}
		
		return optionalCategory.get();
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		
		restaurantService.findRestaurantById(id);
		return ingredientCategoryRepository.findByRestaurantId(id);
	}

	@Override
	public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category = findIngredientCategoryById(categoryId);
		
		IngredientsItem ingredientsItem = new IngredientsItem();
		ingredientsItem.setName(ingredientName);
		ingredientsItem.setRestaurant(restaurant);
		ingredientsItem.setCategory(category);
		
		IngredientsItem savedIngredientsItem = ingredientItemRepository.save(ingredientsItem);
		category.getIngredients().add(savedIngredientsItem);
		
		return savedIngredientsItem;
	}

	@Override
	public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId) {
		return ingredientItemRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public IngredientsItem updateStock(Long id) throws Exception {
		
		Optional<IngredientsItem> optionalIngredientsItem = ingredientItemRepository.findById(id);
		
		if(optionalIngredientsItem.isEmpty()) {
			throw new Exception("ingredient not found");
		}
		
		IngredientsItem ingredientsItem = optionalIngredientsItem.get();
		ingredientsItem.setInStock(!ingredientsItem.isInStock());
		return ingredientItemRepository.save(ingredientsItem);
	}
}

















