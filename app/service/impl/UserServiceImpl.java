/**
 * 
 */
package service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import documents.User;
import repository.UserRepo;
import service.UserService;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	public void saveNewUser(User user) {
		userRepo.save(user);
	}
	@Override
	public Optional<User> findUserById(String id) {
		return userRepo.findById(id);
	}
}
