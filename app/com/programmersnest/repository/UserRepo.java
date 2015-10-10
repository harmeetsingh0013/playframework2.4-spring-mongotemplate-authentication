/**
 * 
 */
package com.programmersnest.repository;

import com.google.inject.ImplementedBy;
import com.programmersnest.documents.User;
import com.programmersnest.repository.impl.UserRepoImpl;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@ImplementedBy(value=UserRepoImpl.class)
public interface UserRepo extends GenericRepo<User>{

}
