package models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
    private String content;

    private Date postedAt;

    private Long authorId;


    public Long getId() {
    	return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }

    public String getTitle() {
    	return this.title;
    }

    public void setTitle(String title) {
    	this.title = title;
    }

    public String getContent() {
    	return this.content;
    }

    public void setContent(String content) {
    	this.content = content;
    }

    public Date getPostedAd() {
    	return this.postedAt;
    }

    public void setPostedAd(Date postedAt) {
    	this.postedAt = postedAt;
    }

    public Long getAuthorId() {
    	return this.authorId;
    }

    public void setAuthorId(Long authorId) {
    	this.authorId = authorId;
    }

}