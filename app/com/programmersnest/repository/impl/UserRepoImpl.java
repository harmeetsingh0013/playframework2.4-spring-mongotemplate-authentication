/**
 * 
 */
package com.programmersnest.repository.impl;

import javax.inject.Named;
import javax.inject.Singleton;

import com.programmersnest.documents.User;
import com.programmersnest.repository.UserRepo;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Singleton @Named(value="userRepo")
public class UserRepoImpl extends GenericRepoImpl<User> implements UserRepo{

}
