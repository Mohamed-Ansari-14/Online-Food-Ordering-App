package com.onlineFoodOrdering.response;

import com.onlineFoodOrdering.model.UserRole;

import lombok.Data;

@Data
public class AuthResponse {

	private String jwt;
	
	private String message;
	
	private UserRole role;
}
