package com.onlineFoodOrdering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineFoodOrdering.config.JwtProvider;
import com.onlineFoodOrdering.model.User;
import com.onlineFoodOrdering.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Override
	public User findUserByJwtToken(String jwt) throws Exception {
		
		String email = jwtProvider.getEmailFromJwtToken(jwt);
		User user = findUserByEmail(email);
		
		return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new Exception("User not Found!!!");
		}
		
		return user;
	}

}















