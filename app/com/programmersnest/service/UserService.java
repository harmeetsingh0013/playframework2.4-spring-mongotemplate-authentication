/**
 * 
 */
package com.programmersnest.service;

import java.util.Optional;

import com.google.inject.ImplementedBy;
import com.programmersnest.documents.User;
import com.programmersnest.service.impl.UserServiceImpl;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@ImplementedBy(value=UserServiceImpl.class)
public interface UserService {

	public Optional<String> saveNewUser(User user);
	public Optional<User> findUserById(String id);
}
