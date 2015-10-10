/**
 * 
 */
package com.programmersnest.service.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.programmersnest.documents.User;
import com.programmersnest.repository.UserRepo;
import com.programmersnest.service.UserService;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Singleton @Named(value="userService")
public class UserServiceImpl implements UserService{

	@Inject
	private UserRepo userRepo;
	
	public Optional<String> saveNewUser(User user) {
		
		return userRepo.save(user);
	}
	@Override
	public Optional<User> findUserById(String id) {
		return Optional.empty();
	}
}
