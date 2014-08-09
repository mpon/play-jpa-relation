package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.jpa.Transactional;

import java.util.List;

import models.*;

import views.html.users.*;

public class UserController extends Controller {

	private static Form<User> userForm = Form.form(User.class);

	@Transactional
    public static Result users() {
    	List<User> userList = User.findAll();
        return ok(users.render(userList));
    }

    public static Result newUser() {
    	return ok(newUser.render(userForm));
    }

    @Transactional
    public static Result createUser() {
    	Form<User> newForm = userForm.bindFromRequest();
    	User user = newForm.get();
    	user.save();
    	return redirect(routes.UserController.users());
    }

}
