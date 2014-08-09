package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.jpa.Transactional;

import java.util.List;

import models.*;

import views.html.posts.*;

public class PostController extends Controller {

	private static Form<Post> postForm = Form.form(Post.class);

    @Transactional
    public static Result posts(Long userId) {
        List<Post> postList = Post.findAllByUserId(userId);
        return ok(posts.render(userId, postList));
    }

    public static Result create(Long userId) {
    	return ok(newPost.render(userId, postForm));
    }

    @Transactional
    public static Result save(Long userId) {
    	Form<Post> newForm = postForm.bindFromRequest();
        if (newForm.hasErrors()) {
            return badRequest(newPost.render(userId, newForm));
        }
    	Post post = newForm.get();
        User user = User.findById(userId);
        post.save(user);
    	return redirect(routes.PostController.posts(userId));
    }

}
