package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import documents.User;
import play.*;
import play.mvc.*;
import service.UserService;
import views.html.*;

@Singleton
public class Application extends Controller {

	@Autowired
	private UserService userService;
	
    public Result index() {
    	User user = new User();
    	user.setName("James");
    	
    	userService.saveNewUser(user);
        return ok(index.render("Your new application is ready."));
    }
    
}
