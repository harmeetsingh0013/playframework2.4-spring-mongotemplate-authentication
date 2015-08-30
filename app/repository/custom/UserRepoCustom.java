/**
 * 
 */
package repository.custom;

import java.util.List;
import java.util.Optional;

import documents.User;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

public interface UserRepoCustom {

	public Optional<List<User>> searchUsersByName(String name);
}
