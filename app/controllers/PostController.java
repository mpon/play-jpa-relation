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

    @Transactional
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

    @Transactional
    public static Result edit(Long id) {
        Post post = Post.findById(id);
        Form<Post> editForm = postForm.fill(post);
        return ok(editPost.render(id, editForm));
    }

    @Transactional
    public static Result update(Long id) {
        Form<Post> editForm = postForm.bindFromRequest();
        if (editForm.hasErrors()) {
            return badRequest(editPost.render(id, editForm));
        }
        Post post = editForm.get();
        post.update(id);
        Long userId = post.getAuthor().getId();
        return redirect(routes.PostController.posts(userId));
    }

    @Transactional
    public static Result delete(Long id) {
        Post post = Post.findById(id);
        post.delete();
        Long userId = post.getAuthor().getId();
        return redirect(routes.PostController.posts(userId));
    }

}
