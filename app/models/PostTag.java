package models;

import javax.persistence.*;

import play.db.jpa.*;

import java.io.Serializable;


@Entity
@Table(name="posts_tags")
public class PostTag implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;
        
    public Post getPost() {
    	return this.post;
    }

    public void setPost(Post post) {
    	this.post = post;
    }

    public Tag getTag() {
    	return this.tag;
    }

    public void setTag(Tag tag) {
    	this.tag = tag;
    }

}