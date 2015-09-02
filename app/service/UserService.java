/**
 * 
 */
package service;

import java.util.Optional;

import com.google.inject.ImplementedBy;

import documents.User;
import service.impl.UserServiceImpl;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@ImplementedBy(UserServiceImpl.class)
public interface UserService {

	public void saveNewUser(User user);
	public Optional<User> findUserById(String id);
}
