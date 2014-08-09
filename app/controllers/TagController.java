package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.jpa.Transactional;

import java.util.List;

import models.*;

import views.html.tags.*;

public class TagController extends Controller {

	private static Form<Tag> tagForm = Form.form(Tag.class);

    @Transactional
    public static Result tags() {
        List<Tag> tagList = Tag.findAll();
        return ok(tags.render(tagList));
    }

    public static Result create() {
    	return ok(newTag.render(tagForm));
    }

    @Transactional
    public static Result save() {
        Form<Tag> newForm = tagForm.bindFromRequest();
        if (newForm.hasErrors()) {
            return badRequest(newTag.render(newForm));
        }
        Tag tag = newForm.get();
        tag.save();
        return redirect(routes.TagController.tags());
    }

    @Transactional
    public static Result edit(Long id) {
        Tag tag = Tag.findById(id);
        Form<Tag> editForm = tagForm.fill(tag);
        return ok(editTag.render(id, editForm));
    }

    @Transactional
    public static Result update(Long id) {
        Form<Tag> editForm = tagForm.bindFromRequest();
        if(editForm.hasErrors()) {
            return badRequest(editTag.render(id, editForm));
        }
        Tag tag = editForm.get();
        tag.update(id);
        return redirect(routes.TagController.tags());
    }

    @Transactional
    public static Result delete(Long id) {
        Tag tag = Tag.findById(id);
        tag.delete();
        return redirect(routes.TagController.tags());
    }

}
