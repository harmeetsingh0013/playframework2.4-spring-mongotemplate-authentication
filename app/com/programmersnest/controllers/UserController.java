package com.programmersnest.controllers;

import java.util.Optional;

import javax.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;

import com.programmersnest.documents.User;
import com.programmersnest.service.UserService;


public class UserController extends Controller{
 
	@Inject
	private UserService userService;
	
	public Result index() {
    	User user = new User();
    	user.setName("James");
    	Optional<String> optional = userService.saveNewUser(user);
    	optional.ifPresent(id -> System.out.println("User Id: "+id));
    	return ok("Done");
    }
}
