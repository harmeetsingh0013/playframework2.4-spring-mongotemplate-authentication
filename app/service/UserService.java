/**
 * 
 */
package service;

import java.util.Optional;

import documents.User;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

public interface UserService {

	public void saveNewUser(User user);
	public Optional<User> findUserById(String id);
}
