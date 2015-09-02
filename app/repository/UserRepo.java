/**
 * 
 */
package repository;

import javax.inject.Named;
import javax.inject.Singleton;

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
