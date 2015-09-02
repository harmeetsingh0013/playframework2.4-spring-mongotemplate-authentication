/**
 * 
 */
package service.impl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;

import documents.User;
import repository.UserRepo;
import service.UserService;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Named @Singleton
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	public void saveNewUser(User user) {
		userRepo.save(user);
	}
	@Override
	public Optional<User> findUserById(String id) {
		return Optional.empty();
	}
}
