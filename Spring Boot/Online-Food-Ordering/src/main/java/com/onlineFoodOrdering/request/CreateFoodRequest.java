package com.onlineFoodOrdering.request;

import java.util.List;

import com.onlineFoodOrdering.model.Category;
import com.onlineFoodOrdering.model.IngredientsItem;

import lombok.Data;

@Data
public class CreateFoodRequest {

	private String name;

	private String description;

	private Long price;

	private Category category;

	private List<String> images;

	private Long restaurantId;

	private boolean vegetarin;

	private boolean seasional;

	private List<IngredientsItem> ingredients;
}
