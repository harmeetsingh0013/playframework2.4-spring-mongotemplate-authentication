/**
 * 
 */
package repository;

import org.springframework.stereotype.Repository;

import documents.User;
import repository.custom.UserRepoCustom;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@Repository
public interface UserRepo extends GenericRepository<User, String>, UserRepoCustom{

}
